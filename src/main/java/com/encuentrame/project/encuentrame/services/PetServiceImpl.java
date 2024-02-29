package com.encuentrame.project.encuentrame.services;


import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.repositories.PetRepository;
import com.encuentrame.project.encuentrame.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    


    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> getPetById(UUID id) {
        return petRepository.findById(id);
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Optional<Pet> updatePet(UUID id, Pet updatedPet) {
        return petRepository.findById(id)
                .map(pet -> {
                    pet.setPet_name(updatedPet.getPet_name());
                    pet.setColor(updatedPet.getColor());
                    pet.setBreed(updatedPet.getBreed());
                    pet.setSize(updatedPet.getSize());
                    pet.setSpecie(updatedPet.getSpecie());
                    pet.setDescription(updatedPet.getDescription());
                    pet.setAge_months(updatedPet.getAge_months());
                    return petRepository.save(pet);
                });
    }

    @Override
    public boolean deletePet(UUID id) {
        return petRepository.findById(id)
                .map(pet -> {
                    petRepository.delete(pet);
                    return true;
                })
                .orElse(false);
    }
}
