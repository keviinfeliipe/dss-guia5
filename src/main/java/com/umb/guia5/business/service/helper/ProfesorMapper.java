package com.umb.guia5.business.service.helper;

import com.umb.guia5.model.dto.ProfesorDto;
import com.umb.guia5.model.entity.Profesor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfesorMapper {
    public Profesor toEntity(ProfesorDto profesorDto){
        return Profesor
                .builder()
                .cedula(profesorDto.getCedula())
                .nombre(profesorDto.getNombre())
                .apellido(profesorDto.getApellido())
                .facultad(profesorDto.getFacultad())
                .email(profesorDto.getEmail())
                .build();
    }

    public ProfesorDto toDto(Profesor profesor){
        return ProfesorDto
                .builder()
                .cedula(profesor.getCedula())
                .nombre(profesor.getNombre())
                .apellido(profesor.getApellido())
                .facultad(profesor.getFacultad())
                .email(profesor.getEmail())
                .build();
    }

    public List<ProfesorDto> toDtoList(List<Profesor> profesors){
        return profesors
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
