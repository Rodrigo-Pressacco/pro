package com.DH.ProyectoFinal.Dto;

import com.DH.ProyectoFinal.persistence.entities.Imagen;
import com.DH.ProyectoFinal.persistence.entities.Producto;
import com.DH.ProyectoFinal.persistence.entities.Reserva;
import com.DH.ProyectoFinal.persistence.entities.login.Usuario;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ReservaDto {

    private Integer id;
    private LocalTime horaLlegada;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String ciudadUsuario;
    private String mensajeDuenio;
    private Integer covid;
    private Integer producto;
    private Integer usuario;



    public ReservaDto() {
    }

    public ReservaDto(Integer id, LocalTime horaLlegada, LocalDate fechaInicio, LocalDate fechaFinal, String ciudadUsuario, String mensajeDuenio, Integer covid, Integer producto, Integer usuario) {
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

    public ReservaDto(Reserva reserva) {
        this.id = reserva.getId();
        this.horaLlegada = reserva.getHoraLlegada();
        this.fechaInicio = reserva.getFechaInicio();
        this.fechaFinal = reserva.getFechaFinal();
        this.ciudadUsuario = reserva.getCiudadUsuario();
        this.mensajeDuenio = reserva.getMensajeDuenio();
        this.covid = reserva.getCovid();
        this.producto = reserva.getProducto().getId();
        this.usuario = reserva.getUsuario().getId();
    }

    public Reserva toEntity (){
        Reserva entity = new Reserva();

        entity.setId(id);
        entity.setHoraLlegada(horaLlegada);
        entity.setFechaInicio(fechaInicio);
        entity.setFechaFinal(fechaFinal);
        entity.setCiudadUsuario(ciudadUsuario);
        entity.setMensajeDuenio(mensajeDuenio);
        entity.setCovid(covid);
        entity.setProducto(new Producto(producto));
        entity.setUsuario(new Usuario(usuario));

        return entity;
    }
}
