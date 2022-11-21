package com.DH.ProyectoFinal.persistence.repository;

import com.DH.ProyectoFinal.persistence.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
