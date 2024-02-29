package com.encuentrame.project.encuentrame.controllers;


import com.encuentrame.project.encuentrame.services.MyUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
                           @RequestParam LocalDate birthdate, ModelMap modelo) {

        try {
            myUserService.createUser(name,surname,email, birthdate,password,password2);

            modelo.put("exito", "Usuario registrado correctamente!");

            return "index.html";
        } catch (Exception ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", name);
            modelo.put("email", email);

            return "registrarse.html";
        }

    }

}
