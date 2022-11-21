package com.DH.ProyectoFinal.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name ="caracteristicas", schema = "neotravel")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String icono;

    @ManyToMany(mappedBy = "caracteristicas", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Producto> productos;

    public Caracteristica() {
    }

    public Caracteristica(String nombre, String icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", icono='" + icono + '\'' +
                '}';
    }
}
