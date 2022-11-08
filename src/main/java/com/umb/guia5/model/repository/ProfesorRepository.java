package com.umb.guia5.model.repository;

import com.umb.guia5.model.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    Optional<Profesor> findProfesorByCedula(Integer cedula);
}
