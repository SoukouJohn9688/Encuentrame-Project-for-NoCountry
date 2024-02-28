package com.encuentrame.project.encuentrame.repositories;

import com.encuentrame.project.encuentrame.entities.CareGiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CareGiverRepository extends JpaRepository<CareGiver, UUID> {

    public CareGiver findByName(String name);
}
