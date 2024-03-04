package com.encuentrame.project.encuentrame.controllers;


import com.encuentrame.project.encuentrame.services.MyUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ingreso")
public class MyUserController {



    // Clase Usuario que corresponde tambien con Admin: Super-usuario.

    private final MyUserServiceImpl myUserService;

    @Autowired
    public MyUserController(MyUserServiceImpl myUserService) {
        this.myUserService = myUserService;
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


}
