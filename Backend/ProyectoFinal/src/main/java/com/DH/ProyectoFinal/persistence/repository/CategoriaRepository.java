package com.DH.ProyectoFinal.persistence.repository;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.persistence.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
