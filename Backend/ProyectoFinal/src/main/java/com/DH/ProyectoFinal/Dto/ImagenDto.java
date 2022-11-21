package com.DH.ProyectoFinal.Dto;

import com.DH.ProyectoFinal.persistence.entities.Imagen;
import com.DH.ProyectoFinal.persistence.entities.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Getter @Setter
public class ImagenDto implements Serializable {

    private Integer id;
    private String titulo;
    private String url_imagen;
    private Integer producto;

    public ImagenDto() {
    }

    public ImagenDto(Integer id, String titulo, String url_imagen) {
        this.id = id;
        this.titulo = titulo;
        this.url_imagen = url_imagen;
    }

    public ImagenDto(Integer id, String titulo, String url_imagen, Integer producto) {
        this.id = id;
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.producto = producto;
    }

    public ImagenDto(Imagen i){
        this.id = i.getId();
        this.titulo = i.getTitulo();
        this.url_imagen = i.getUrl_imagen();
        this.producto = i.getProducto().getId();
    }

    public Imagen toEntity (){
        Imagen entity = new Imagen();

        entity.setId(id);
        entity.setTitulo(titulo);
        entity.setUrl_imagen(url_imagen);
        entity.setProducto(new Producto(producto));

        return entity;
    }
}
