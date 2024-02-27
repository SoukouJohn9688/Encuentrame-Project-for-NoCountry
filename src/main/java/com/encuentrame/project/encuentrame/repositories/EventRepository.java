package com.encuentrame.project.encuentrame.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuentrame.project.encuentrame.entities.Event;

public interface EventRepository extends JpaRepository <Event, UUID> {
    
}
