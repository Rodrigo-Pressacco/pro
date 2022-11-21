package com.DH.ProyectoFinal.Dto.login;

import com.DH.ProyectoFinal.Dto.ReservaDto;
import com.DH.ProyectoFinal.persistence.entities.Reserva;
import com.DH.ProyectoFinal.persistence.entities.login.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UsuarioDto implements Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private Set<ReservaDto> reservas = new HashSet<>();

    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UsuarioDto(Usuario u){
        this.id = u.getId();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
    }

    public Usuario toEntity(){
        Usuario entity = new Usuario();

        entity.setId(id);
        entity.setNombre(nombre);
        entity.setApellido(apellido);
        entity.setEmail(email);

        Set<Reserva> reservas1 = new HashSet<>();
        for (ReservaDto r: reservas){
            reservas1.add(r.toEntity());
        }
        entity.setReservas(reservas1);

        return entity;
    }
}
