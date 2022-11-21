package com.DH.ProyectoFinal.persistence.entities;

import com.DH.ProyectoFinal.persistence.entities.login.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name ="reservas", schema = "neotravel")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private LocalTime horaLlegada;
    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaFinal;
    @Column
    private String ciudadUsuario;
    @Column
    private String mensajeDuenio;
    @Column
    private Integer covid;

    @ManyToOne(optional = false , fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id", nullable = false)
    private Producto producto;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario usuario;


    public Reserva() {
    }

    public Reserva(Integer id, LocalTime horaLlegada, LocalDate fechaInicio, LocalDate fechaFinal, String ciudadUsuario, String mensajeDuenio, Integer covid, Producto producto, Usuario usuario) {
        this.id = id;
        this.horaLlegada = horaLlegada;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.ciudadUsuario = ciudadUsuario;
        this.mensajeDuenio = mensajeDuenio;
        this.covid = covid;
        this.producto = producto;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", horaLlegada=" + horaLlegada +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", CiudadUsuario='" + ciudadUsuario + '\'' +
                ", MensajeDuenio='" + mensajeDuenio + '\'' +
                ", covid=" + covid +
                ", producto=" + producto +
                ", usuario=" + usuario +
                '}';
    }
}
