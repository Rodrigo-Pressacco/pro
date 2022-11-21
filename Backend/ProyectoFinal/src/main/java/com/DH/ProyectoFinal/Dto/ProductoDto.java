package com.DH.ProyectoFinal.Dto;


import com.DH.ProyectoFinal.persistence.entities.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ProductoDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private double latitud;
    private double longitud;
    private Set<Caracteristica> caracteristicas = new HashSet<>();
    private Set<ImagenDto> imagen = new HashSet<>();
    private CiudadDto ciudad;
    private CategoriaDto categoria;
    private Set<ReservaDto> reservas = new HashSet<>();

    public ProductoDto() {
    }

    public ProductoDto(Integer id, String nombre, String descripcion, CiudadDto ciudad, CategoriaDto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public ProductoDto(Integer id, String nombre, String descripcion, Set<Caracteristica> caracteristicas, CiudadDto ciudad, CategoriaDto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public ProductoDto(Integer id, String nombre, String descripcion, CiudadDto ciudad, CategoriaDto categoria, double latitud, double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public ProductoDto(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.ciudad = new CiudadDto(producto.getCiudad());
        this.categoria = new CategoriaDto(producto.getCategoria());
        this.latitud = producto.getLatitud();
        this.longitud = producto.getLongitud();
    }

    public Producto toEntity(){
        Producto entity = new Producto();

        entity.setId(id);
        entity.setNombre(nombre);
        entity.setDescripcion(descripcion);
        entity.setCaracteristicas(caracteristicas);
        entity.setCategoria(categoria.toEntity());
        entity.setCiudad(ciudad.toEntity());
        entity.setLatitud(latitud);
        entity.setLongitud(longitud);

        Set<Imagen> imagen1 = new HashSet<>();
        for (ImagenDto i: imagen){
            imagen1.add(i.toEntity());
        }
        entity.setImagenes(imagen1);

        Set<Reserva> reservas1 = new HashSet<>();
        for (ReservaDto r: reservas){
            reservas1.add(r.toEntity());
        }
        entity.setReservas(reservas1);

        return entity;
    }

}
