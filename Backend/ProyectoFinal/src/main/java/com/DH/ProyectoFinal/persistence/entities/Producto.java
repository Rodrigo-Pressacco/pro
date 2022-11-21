package com.DH.ProyectoFinal.persistence.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name ="productos", schema = "neotravel")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private double latitud;
    @Column
    private double longitud;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "atributos",
            joinColumns = @JoinColumn(name = "productos_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristicas_id")
    )
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private Set<Imagen> imagenes = new HashSet<>();


    @ManyToOne(optional = false , fetch = FetchType.EAGER)
    @JoinColumn(name="ciudad_id", nullable = false)
    private Ciudad ciudad;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private Set<Reserva> reservas = new HashSet<>();

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(String nombre, String descripcion, Set<Caracteristica> caracteristicas, Set<Imagen> imagenes, Ciudad ciudad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.imagenes = imagenes;
        this.ciudad = ciudad;
    }

    public Producto(String nombre, String descripcion, double latitud, double longitud, Set<Caracteristica> caracteristicas, Set<Imagen> imagenes, Ciudad ciudad, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.caracteristicas = caracteristicas;
        this.imagenes = imagenes;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public Producto(Integer id, String nombre, String descripcion, double latitud, double longitud, Set<Caracteristica> caracteristicas, Set<Imagen> imagenes, Ciudad ciudad, Categoria categoria, Set<Reserva> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.caracteristicas = caracteristicas;
        this.imagenes = imagenes;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", caracteristicas=" + caracteristicas +
                ", imagenes=" + imagenes +
                ", ciudad=" + ciudad +
                ", categoria=" + categoria +
                '}';
    }
}
