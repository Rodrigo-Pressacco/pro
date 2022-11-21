package com.DH.ProyectoFinal.Dto.login;

import com.DH.ProyectoFinal.persistence.entities.login.Rol;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RolDto implements Serializable {

    private Integer id;
    private String nombre;

    public RolDto() {
    }

    public RolDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public RolDto (Rol r){
        this.id = r.getId();
        this.nombre = r.getNombre();
    }

    public Rol toEntity(){
        Rol entity = new Rol();

        entity.setId(id);
        entity.setNombre(nombre);

        return entity;
    }
}
