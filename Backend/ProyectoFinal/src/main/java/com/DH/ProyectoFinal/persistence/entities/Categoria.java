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
@Table(name ="categorias", schema = "neotravel")
public class Categoria {

    @Id
    //@SequenceGenerator(name = "categorias_sequence", sequenceName = "categorias_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY /*, generator = "categorias_sequence"*/)
    @Column
    private Integer id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String url_imagen;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(String titulo, String descripcion, String url_imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + url_imagen + '\'' +
                '}';
    }
}
