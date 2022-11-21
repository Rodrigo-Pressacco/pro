package com.DH.ProyectoFinal.persistence.repository.login;

import com.DH.ProyectoFinal.persistence.entities.login.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
