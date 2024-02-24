package com.encuentrame.project.encuentrame.repositories;


import com.encuentrame.project.encuentrame.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {


    public List<Pet> findByBreed(String breed);
    public List<Pet> findBySpecie(String specie);


}
