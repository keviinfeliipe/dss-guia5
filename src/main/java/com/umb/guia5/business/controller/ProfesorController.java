package com.umb.guia5.business.controller;

import com.umb.guia5.business.service.ProfesorService;
import com.umb.guia5.model.dto.ProfesorDto;
import com.umb.guia5.model.entity.Profesor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/profesor")
@CrossOrigin("*")
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }
    @GetMapping()
    public ResponseEntity<List<ProfesorDto>> getAll(){
        return ResponseEntity.ok(profesorService.getAll());
    }
    @GetMapping("/{cedula}")
    public ResponseEntity<Profesor> findById(@PathVariable int cedula){
        var profesor = profesorService.findByCedula(cedula);
        if (profesor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesor.get());

    }
    @PostMapping()
    public ResponseEntity<ProfesorDto> save(@RequestBody ProfesorDto profesorDto){
        return ResponseEntity.ok(profesorService.save(profesorDto));
    }
    @PutMapping("/{cedula}")
    public ResponseEntity<ProfesorDto> update(@PathVariable int cedula, @RequestBody ProfesorDto profesorDto){
        var profesor = profesorService.findByCedula(cedula);
        if (profesor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesorService.update(profesorDto));
    }
    @DeleteMapping("/{cedula}")
    public ResponseEntity<ProfesorDto> delete(@PathVariable Integer cedula){
        var profesor = profesorService.findByCedula(cedula);
        if (profesor.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        profesorService.delete(profesor.get());
        return ResponseEntity.noContent().build();
    }
}
