package com.DH.ProyectoFinal.persistence.repository;

import com.DH.ProyectoFinal.persistence.entities.Caracteristica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
}
