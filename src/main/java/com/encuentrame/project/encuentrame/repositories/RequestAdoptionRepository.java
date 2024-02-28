package com.encuentrame.project.encuentrame.repositories;

import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestAdoptionRepository extends JpaRepository<RequestAdoption, String> {
}
