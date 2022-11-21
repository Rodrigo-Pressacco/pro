package com.DH.ProyectoFinal.Dto;

import com.DH.ProyectoFinal.persistence.entities.Ciudad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CiudadDto {

    private Integer id;
    private String nombre;
    private String pais;

    public CiudadDto() {
    }

    public CiudadDto(Integer id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public CiudadDto(Ciudad c) {
        this.id = c.getId();
        this.nombre = c.getNombre();
        this.pais = c.getPais();
    }

    public Ciudad toEntity() {
        Ciudad entity = new Ciudad();

        entity.setId(id);
        entity.setNombre(nombre);
        entity.setPais(pais);

        return entity;
    }


}
