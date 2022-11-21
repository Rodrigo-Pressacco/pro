package com.DH.ProyectoFinal.Service.login;

import com.DH.ProyectoFinal.Dto.ProductoDto;
import com.DH.ProyectoFinal.Dto.ReservaDto;
import com.DH.ProyectoFinal.Dto.login.UsuarioDto;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Producto;
import com.DH.ProyectoFinal.persistence.entities.Reserva;
import com.DH.ProyectoFinal.persistence.entities.login.Rol;
import com.DH.ProyectoFinal.persistence.entities.login.Usuario;
import com.DH.ProyectoFinal.persistence.repository.ReservaRepository;
import com.DH.ProyectoFinal.persistence.repository.login.RolRepository;
import com.DH.ProyectoFinal.persistence.repository.login.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final ReservaRepository reservaRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ReservaRepository reservaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username).orElse(null);
        return new User(usuario.getUsername(),usuario.getPassword(), new ArrayList<>());
        //return new User("foo", "foo", new ArrayList<>());
    }

    public UsuarioDto loadUser(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username).orElse(null);

        return new UsuarioDto(usuario);
    }

    public Usuario guardar(Usuario usuario) throws ResourceBadRequestException {
        Usuario response;
        if(usuario != null){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(hashedPassword);
            usuario.setRol(new Rol(2,"user"));
            response = usuarioRepository.save(usuario);
        } else {
            throw new ResourceBadRequestException("No se puede guardar un usuario en null");
        }

        return response;
    }

    public UsuarioDto buscarPorId(Integer id) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario == null)
            throw new ResourceNotFoundException("No existe el usuario con id: " + id);

        UsuarioDto response = new UsuarioDto(usuario);
        response.setReservas(buscarReservasPorUsuarioId(response.getId()));

        return response;
    }

    public Usuario buscarPorEmail(String email) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
        if(usuario == null)
            throw new ResourceNotFoundException("No existe el usuario con email: " + email);

        return usuario;
    }

    public List<UsuarioDto> buscarTodos() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        for (Usuario u: usuarioRepository.findAll()){
            UsuarioDto response = new UsuarioDto(u);
            response.setReservas(buscarReservasPorUsuarioId(response.getId()));
            usuarioDtos.add(response);
        }

        return usuarioDtos;
    }

    public Usuario actualizar(Usuario u) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findAll().stream().filter(usuario1 -> usuario1.getId().equals(u.getId())).findFirst().get();
        if(buscarPorId(u.getId()) == null)
            throw new ResourceNotFoundException("No existe el usuario con id: " + u.getId());
        else {
            usuario.setNombre(u.getNombre());
            usuario.setApellido(u.getApellido());
            usuario.setEmail(u.getEmail());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(u.getPassword());
            usuario.setPassword(hashedPassword);
            usuarioRepository.save(usuario);
        }

        return usuario;
    }

    public void borrar(Integer id) throws ResourceNotFoundException {
        if(usuarioRepository.findById(id).orElse(null) == null)
            throw new ResourceNotFoundException("No existe el usuario con id: " + id);
        else {
            usuarioRepository.deleteById(id);
        }
    }


    public Set<ReservaDto> buscarReservasPorUsuarioId(Integer id) {
        Set<ReservaDto> reservas = new HashSet<>();

        for (Reserva r: reservaRepository.findAll()){
            if (r.getUsuario().getId().equals(id)) {
                reservas.add(new ReservaDto(r));
            }
        }
        return reservas;
    }


}
