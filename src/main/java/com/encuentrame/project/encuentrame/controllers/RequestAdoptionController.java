package com.encuentrame.project.encuentrame.controllers;

import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.repositories.RequestAdoptionRepository;
import com.encuentrame.project.encuentrame.service.RequestAdoptionService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;


@Controller
@RequestMapping("/")
public class RequestAdoptionController {

    private static final Logger logger = LoggerFactory.getLogger(RequestAdoptionController.class);

    @Autowired
    private RequestAdoptionRepository requestAdoptionRepository;

    @Autowired
    private RequestAdoptionService requestAdoptionService;

    // Endpoint para crear una nueva solicitud de adopción
    @PostMapping("/createRequestAdoption")
    public String createRequestAdoption(@RequestParam UUID userId, @RequestParam UUID petId, Model model) {

        logger.debug("The request PET ID is " + petId);
        logger.debug("The request User ID is" + userId);

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
