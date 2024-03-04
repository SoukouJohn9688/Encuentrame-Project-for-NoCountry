package com.encuentrame.project.encuentrame.controllers;


import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.services.MyUserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class HomeController {

    private final MyUserServiceImpl myUserService;

    @Autowired
    public HomeController(MyUserServiceImpl myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }


    @GetMapping("/mascotas")
    public String getMascotas() {
        return "adopciones";
    }


    @GetMapping("/registrar")
    public String registrar() {
        return "registrarse.html";
    }



    @PostMapping("/registro")
    public String register(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String password2,
                           @RequestParam LocalDate birthdate, ModelMap model) {

        try {
            myUserService.createUser(name,surname,email, birthdate,password,password2);

            model.put("exito", "Usuario registrado correctamente!");
            model.put("name", name);
            model.put("surname", surname);
            model.put("email", email);
            model.put("birthdate", birthdate);
            model.put("password", password);
            model.put("password2", password2);
            return "index.html";
        } catch (Exception ex) {

            model.put("error", ex.getMessage());
            model.put("name", name);
            model.put("email", email);

            return "registrarse.html";
        }

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap model ) {
        System.out.println("AAAAAA");


        if (error != null) {
            model.put("error", "Usuario o Contraseña invalidos! Intente de nuevo.");
        }

        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/iniciologged")
    public String initSession(HttpSession session) {

        MyUser logued = (MyUser) session.getAttribute("usuariosession");

        if (logued.getRole().toString().equals("ADMIN")) {
            return "redirect:/admin/";
        }

        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MODERATOR')")
    @GetMapping("/perfil")
    public String perfil(ModelMap modelo,HttpSession session){
        MyUser usuario = (MyUser) session.getAttribute("usersession");
        modelo.put("usuario", usuario);
        return "usuario_modificar.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_MODERATOR')")
    @PostMapping("/perfil/{id}")
    public String update(@PathVariable UUID id, @PathVariable MyUser updatedUser,ModelMap model) {

        try {
            myUserService.updateMyUser(id, updatedUser);

            model.put("exito", "Usuario actualizado correctamente!");

            return "inicio.html";
        } catch (Exception ex) {

            model.put("error", ex.getMessage());
            model.put("nombre", updatedUser.getName());
            model.put("email", updatedUser.getEmail());

            return "usuario_modificar.html";
        }
    }
}
