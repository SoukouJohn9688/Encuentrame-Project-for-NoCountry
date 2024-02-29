package com.encuentrame.project.encuentrame.repositories;
import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestAdoptionRepository extends JpaRepository<RequestAdoption, UUID> {

    public RequestAdoption findByPet(Pet pet);
}
