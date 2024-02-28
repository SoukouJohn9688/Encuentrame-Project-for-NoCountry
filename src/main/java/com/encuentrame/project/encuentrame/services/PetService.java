package com.encuentrame.project.encuentrame.services;

import com.encuentrame.project.encuentrame.entities.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetService {

    List<Pet> getAllPets();

    Optional<Pet> getPetById(UUID id);
    Pet createPet(Pet pet);
    Optional<Pet> updatePet(UUID id, Pet updatedPet);

    boolean deletePet(UUID id);


}