package com.encuentrame.project.encuentrame.controllers;


import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.repositories.ArticleRepository;
import com.encuentrame.project.encuentrame.repositories.MyUserRepository;
import com.encuentrame.project.encuentrame.services.MyUserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/ingreso")
public class MyUserController {

private final MyUserRepository myUserRepository;

    // Clase Usuario que corresponde tambien con Admin: Super-usuario.

    private final MyUserServiceImpl myUserService;

    @Autowired
    public MyUserController(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
        this.myUserService = new MyUserServiceImpl();
    }

//    @GetMapping("/myusers")
//    public String getMyusers(Model model){
//        List<MyUser> listaUsers=myUserService.getAllMyUsers();
//        model.addAttribute("users", listaUsers);
//        return "<p th:text></p>";
//    }

    @PostMapping("/myusers")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        System.out.println("AAAAAAAA");

        return null;
   }

   @RestController
   public class MyUserApiController{

    @GetMapping("/myUsers")
    public ResponseEntity<List<MyUser>> getAllMyUsers() {
        List<MyUser> myUsers = myUserRepository.findAll();
        if (!myUsers.isEmpty()) {
            return new ResponseEntity<>(myUsers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   }
}
