package com.DH.ProyectoFinal.persistence.repository;

import com.DH.ProyectoFinal.persistence.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}
