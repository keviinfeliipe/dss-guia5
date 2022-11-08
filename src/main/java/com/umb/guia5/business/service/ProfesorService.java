package com.umb.guia5.business.service;

import com.umb.guia5.business.service.helper.ProfesorMapper;
import com.umb.guia5.model.dto.ProfesorDto;
import com.umb.guia5.model.entity.Profesor;
import com.umb.guia5.model.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    public ProfesorService(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    public List<ProfesorDto> getAll(){
        return profesorMapper.toDtoList(profesorRepository.findAll());
    }

    public Optional<Profesor> findByCedula(Integer cedula){
        return profesorRepository.findProfesorByCedula(cedula);
    }

    public ProfesorDto save(ProfesorDto profesorDto){
        var profesor = profesorMapper.toEntity(profesorDto);
        return profesorMapper.toDto(profesorRepository.save(profesor));
    }

    public ProfesorDto update(ProfesorDto profesorDto){
        var profesor = profesorRepository.findProfesorByCedula(profesorDto.getCedula()).orElseThrow();
        profesor.setNombre(profesorDto.getNombre());
        profesor.setApellido(profesorDto.getApellido());
        profesor.setFacultad(profesorDto.getFacultad());
        profesor.setEmail(profesorDto.getEmail());
        return profesorMapper.toDto(profesorRepository.save(profesor));
    }

    public void delete (Profesor profesor){
        profesorRepository.delete(profesor);
    }

}
