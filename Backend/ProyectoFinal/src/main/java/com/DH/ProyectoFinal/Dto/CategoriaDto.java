package com.DH.ProyectoFinal.Dto;

import com.DH.ProyectoFinal.persistence.entities.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaDto implements Serializable {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String url_imagen;

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String titulo, String descripcion, String url_imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
    }

    public CategoriaDto(Categoria c) {
        this.id = c.getId();
        this.titulo = c.getTitulo();
        this.descripcion = c.getDescripcion();
        this.url_imagen = c.getUrl_imagen();
    }

    public Categoria toEntity() {
        Categoria entity = new Categoria();

        entity.setId(id);
        entity.setTitulo(titulo);
        entity.setDescripcion(descripcion);
        entity.setUrl_imagen(url_imagen);

        return entity;
    }
}
