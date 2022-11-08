package com.umb.guia5.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ProfesorDto {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String facultad;
    private String email;
}
