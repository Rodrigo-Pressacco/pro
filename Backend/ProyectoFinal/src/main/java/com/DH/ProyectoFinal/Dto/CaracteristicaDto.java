package com.DH.ProyectoFinal.Dto;

import com.DH.ProyectoFinal.persistence.entities.Caracteristica;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CaracteristicaDto implements Serializable {

    private Integer id;
    private String nombre;
    private String icono;

    public CaracteristicaDto() {
    }

    public CaracteristicaDto(Integer id, String nombre, String icono) {
        this.id = id;
        this.nombre = nombre;
        this.icono = icono;
    }

    public CaracteristicaDto(Caracteristica c) {
        this.id = c.getId();
        this.nombre = c.getNombre();
        this.icono = c.getIcono();
    }

    public Caracteristica toEntity(){
        Caracteristica entity = new Caracteristica();

        entity.setId(id);
        entity.setNombre(nombre);
        entity.setIcono(icono);

        return entity;
    }
}
