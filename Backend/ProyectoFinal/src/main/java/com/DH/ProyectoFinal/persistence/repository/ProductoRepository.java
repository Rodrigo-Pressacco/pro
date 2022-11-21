package com.DH.ProyectoFinal.persistence.repository;

import com.DH.ProyectoFinal.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
