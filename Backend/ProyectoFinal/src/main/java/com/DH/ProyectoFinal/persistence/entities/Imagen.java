package com.DH.ProyectoFinal.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name ="imagenes", schema = "neotravel")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String titulo;
    @Column
    private String url_imagen;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="productos_id", nullable = false)
    private Producto producto;

    public Imagen() {
    }


    public Imagen(String titulo, String url_imagen, Producto producto) {
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", url_imagen='" + url_imagen + '\'' +
                ", producto=" + producto +
                '}';
    }
}
