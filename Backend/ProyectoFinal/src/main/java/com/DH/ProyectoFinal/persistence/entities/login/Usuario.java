package com.DH.ProyectoFinal.persistence.entities.login;

import com.DH.ProyectoFinal.persistence.entities.Reserva;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "neotravel")
@Getter @Setter
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="rol_id", referencedColumnName = "id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Reserva> reservas = new HashSet<>();

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(String nombre, String apellido, String email, String password, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getNombre());

        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
