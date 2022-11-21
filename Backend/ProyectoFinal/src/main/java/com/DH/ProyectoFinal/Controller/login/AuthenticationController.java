package com.DH.ProyectoFinal.Controller.login;

import com.DH.ProyectoFinal.Dto.login.UsuarioDto;
import com.DH.ProyectoFinal.Service.login.UsuarioService;
import com.DH.ProyectoFinal.persistence.entities.login.AuthenticationRequest;
import com.DH.ProyectoFinal.persistence.entities.login.AuthenticationResponse;
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

@RestController
public class AuthenticationController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private static final Logger logger = Logger.getLogger(Service.class);

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrecto username o password", e);
        }

        final UserDetails userDetails = usuarioService
                .loadUserByUsername(authenticationRequest.getUsername());
        final UsuarioDto usuario = usuarioService.loadUser(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        List<Object> h= new ArrayList<>();
        h.add(usuario);
        h.add(new AuthenticationResponse(jwt));
        return ResponseEntity.status(200).body(h);
       // return ResponseEntity.status(200).body((new AuthenticationResponse(jwt)));
        //return new ResponseEntity<>(+ new AuthenticationResponse(jwt), usuario, HttpStatus.OK);

    }
}
