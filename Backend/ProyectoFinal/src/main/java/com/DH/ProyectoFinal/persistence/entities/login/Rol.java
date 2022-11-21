package com.DH.ProyectoFinal.persistence.entities.login;

import com.DH.ProyectoFinal.persistence.entities.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "neotravel")
@Getter @Setter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String nombre;

    @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuarios;

    public Rol() {
    }

    public Rol(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
