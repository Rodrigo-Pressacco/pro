package com.DH.ProyectoFinal.persistence.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name ="ciudades", schema = "neotravel")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String pais;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Ciudad() {
    }

    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Ciudades{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
