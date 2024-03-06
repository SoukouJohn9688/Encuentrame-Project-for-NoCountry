package com.encuentrame.project.encuentrame.controllers;

import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.repositories.PetRepository;
import com.encuentrame.project.encuentrame.repositories.RequestAdoptionRepository;
import com.encuentrame.project.encuentrame.service.PetService;
import com.encuentrame.project.encuentrame.service.RequestAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class RequestAdoptionController {

    @Autowired
    private RequestAdoptionRepository requestAdoptionRepository;

    @Autowired
    private RequestAdoptionService requestAdoptionService;

    // Endpoint para crear una nueva solicitud de adopción
    @PostMapping("/createRequestAdoption")
    public String createRequestAdoption(@RequestParam UUID userId, @RequestParam UUID petId, Model model) {
        RequestAdoption requestAdoption = requestAdoptionService.createRequestAdoption(userId, petId);
        model.addAttribute("requestAdoption", requestAdoption);
        return "index.html";
    }



    @GetMapping("/getAll")
    public String getAllRequestAdoption() {
        List<RequestAdoption> requestAdoptions = requestAdoptionService.getAllRequestAdoption();
        return null; //Pendiente de thymeleaf de todas las solicitudes
    }




}
