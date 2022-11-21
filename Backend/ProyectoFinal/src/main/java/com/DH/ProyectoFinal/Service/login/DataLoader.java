package com.DH.ProyectoFinal.Service.login;

import com.DH.ProyectoFinal.persistence.entities.login.Rol;
import com.DH.ProyectoFinal.persistence.entities.login.Usuario;
import com.DH.ProyectoFinal.persistence.repository.login.RolRepository;
import com.DH.ProyectoFinal.persistence.repository.login.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository,RolRepository rolRepository ) {

        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        Rol admin = rolRepository.save(new Rol("Administrador"));
        Rol user = rolRepository.save(new Rol("Usuario"));
        usuarioRepository.save(new Usuario("Deborah", "Gonzalez", "debigonz19@gmail.com", hashedPassword, admin));
        usuarioRepository.save(new Usuario("Rodrigo", "Pressacco", "pressacco.rodrigo95@gmail.com", hashedPassword2, user));
    }
}
