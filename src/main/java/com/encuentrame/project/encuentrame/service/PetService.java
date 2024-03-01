package com.encuentrame.project.encuentrame.service;

import com.encuentrame.project.encuentrame.entities.CareGiver;
import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.repositories.CareGiverRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
