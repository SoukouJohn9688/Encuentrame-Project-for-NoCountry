package com.encuentrame.project.encuentrame.controllers;

import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.repositories.CareGiverRepository;
import com.encuentrame.project.encuentrame.repositories.PetRepository;
import com.encuentrame.project.encuentrame.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetService petService;

    @Autowired
    private CareGiverRepository careGiverRepository;

    //Formulario de creación de mascota
    @GetMapping()
    public String createPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return null; //Pendiente de crear Thymeleaf
    }

    @PostMapping()
    public String createPet(@ModelAttribute @Valid Pet pet){
        petService.createPet(pet);
        return null;
    }

    @GetMapping()
    public String getAllPets (ModelMap model){

        //Usando ModelMap podemos establecer el listado de mascotas.
        List<Pet> pets = petService.getAllPets();
        //Se debe anclar para ser enviado a la interfaz del usuario
        model.addAttribute("Mascotas", pets);
        return null; //Pendiente de crear Thymeleaf
    }

    @GetMapping("/{id}")
    public String getPetById(@PathVariable UUID id, Model model) {
        Optional<Pet> pet = petService.getPetById(id);
        pet.ifPresent(value -> model.addAttribute("Pet", value));
        return null; //Pendiente de crear Thymeleaf
    }

    @GetMapping("/update/{id}")
    public String updatePetForm(@PathVariable UUID id, Model model) {
        Optional<Pet> pet = petService.getPetById(id);
        pet.ifPresent(value -> model.addAttribute("pet", value));
        return null; // Pendiente Thymeleaf
    }

    @PostMapping("/update/{id}")
    public String updatePet(@PathVariable UUID id, @ModelAttribute Pet updatedPet) {
        petService.updatePet(id, updatedPet);
        return null; // Pendiente Thymeleaf
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable UUID id) {
        petService.deletePet(id);
        return null; // Pendiente Thymeleaf
    }



}
