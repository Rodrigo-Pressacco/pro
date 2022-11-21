package com.DH.ProyectoFinal.Controller.login;

import com.DH.ProyectoFinal.Dto.login.UsuarioDto;
import com.DH.ProyectoFinal.Service.login.UsuarioService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.login.AuthenticationRequest;
import com.DH.ProyectoFinal.persistence.entities.login.AuthenticationResponse;
import com.DH.ProyectoFinal.persistence.entities.login.Usuario;
import com.DH.ProyectoFinal.util.JwtUtil;
import org.apache.log4j.Logger;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private static final Logger logger = Logger.getLogger(Service.class);



    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody Usuario u) throws ResourceBadRequestException {

        Usuario respuesta = usuarioService.guardar(u);
        logger.debug("Operación exitosa de creado de un usuario");
        return ResponseEntity.status(201).body(respuesta);
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        UsuarioDto respuesta = usuarioService.buscarPorId(id);
        logger.debug("Buscando al usuario con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/porEmail/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException {
        Usuario respuesta = usuarioService.buscarPorEmail(email);
        logger.debug("Buscando al usuario con email: " + email);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> buscarTodos(){
        List<UsuarioDto> usuarios = new ArrayList<>();
        try{
            usuarios = this.usuarioService.buscarTodos();
            logger.debug("Listando usuarios: " + usuarios);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Usuario u) throws ResourceNotFoundException {
        Usuario respuesta = usuarioService.actualizar(u);
        logger.debug("Se ha actualizado correctamente el usuario");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        usuarioService.borrar(id);
        logger.debug("Se eliminó el usuario");
        return ResponseEntity.ok("El usuario con id: " + id + " fue eliminado.");
    }


}
