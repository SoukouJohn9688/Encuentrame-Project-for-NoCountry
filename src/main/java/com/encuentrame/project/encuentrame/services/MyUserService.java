package com.encuentrame.project.encuentrame.services;


import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.enumerations.UserRole;
import com.encuentrame.project.encuentrame.repositories.MyUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService implements UserDetailsService {


    @Autowired
    private MyUserRepository myUserRepository;

    @Transactional
    public void register(String name, String email, String password, String password2) throws Exception{
        validar(name, email, password, password2);

        //Instaciamos
        MyUser myUser = new MyUser();

        myUser.setName(name);
        myUser.setEmail(email);

        //Antes de usar el encoder: user.setPassword(password);
        //Usando el encoder.
        myUser.setPassword(new BCryptPasswordEncoder().encode(password)); //Eso se ve en el workbench.SELECT * FROM biblioteca.user;

        myUser.setRole(UserRole.USER);

        myUserRepository.save(myUser);

    }

    private void validar(String name, String email, String password, String password2) throws Exception {

        if (name.isEmpty() ||  name == null) {
            throw new Exception("el name no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new Exception("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new Exception("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new Exception("Las contraseñas ingresadas deben ser iguales");
        }

    }
    //Autenticar a cada user que se logea. Se implementa la Interfaz UserDetailsService
    //Lo vamos a autenticar con el email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //1. Buscar un user de nuestro dominio y transformarlo en un user del dominio de Spring Security
        //Hacemos uso del método del repo


        MyUser myUser = myUserRepository.findByEmail(email);

        //Empezamos a trabajar con Spring Security

        if (myUser != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();

            //Creamos algunos permisos para un user
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + myUser.getRole().toString()); //ROLE_USER

            // Ese p lo vamos a agregar a la lista creada previamente

            permisos.add(p);

            //Usamos la clase de Spring User, así vacío nos pide varios parámetros: User user = new User();
            //User user = new User(user.getEmail(), user.getPassword(), permisos);

            return new User(myUser.getEmail(), myUser.getPassword(), permisos);
        } else {

            return null;
}
    }

}
