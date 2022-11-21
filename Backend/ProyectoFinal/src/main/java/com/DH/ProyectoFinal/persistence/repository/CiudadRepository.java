package com.DH.ProyectoFinal.persistence.repository;


import com.DH.ProyectoFinal.persistence.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}
