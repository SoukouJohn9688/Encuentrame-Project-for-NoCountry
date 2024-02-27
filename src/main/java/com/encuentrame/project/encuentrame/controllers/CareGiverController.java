package com.encuentrame.project.encuentrame.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encuentrame.project.encuentrame.entities.CareGiver;
import com.encuentrame.project.encuentrame.repositories.CareGiverRepository;


@RestController
public class CareGiverController {

    private final CareGiverRepository careGiverRepository; 
  
    @Autowired
    public CareGiverController(CareGiverRepository careGiverRepository) { 
        this.careGiverRepository = careGiverRepository; 
    } 
  
    // Endpoint to retrieve all CareGivers 
    @GetMapping("/api/caregivers")
    public ResponseEntity<List<CareGiver>> getAllCareGivers() { 
        List<CareGiver> careGivers = careGiverRepository.findAll(); 
        return new ResponseEntity<>(careGivers, HttpStatus.OK); 
    } 
  
    // Endpoint to retrieve a CareGiver by ID 
    @GetMapping("/api/caregivers/{id}") 
    public ResponseEntity<CareGiver> getCareGiverById(@PathVariable UUID id) { 
        return careGiverRepository.findById(id).map(careGiver -> new ResponseEntity<>(careGiver, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to create a new CareGiver 
    @PostMapping("/api/caregivers")
    public ResponseEntity<CareGiver> createCareGiver(@RequestBody CareGiver careGiver) { 
        CareGiver savedCareGiver = careGiverRepository.save(careGiver); 
        return new ResponseEntity<>(savedCareGiver, HttpStatus.CREATED); 
    } 
  
    // Endpoint to update an existing CareGiver 
    @PutMapping("/api/caregivers/{id}") 
    public ResponseEntity<CareGiver> updateCareGiver(@PathVariable UUID id, @RequestBody CareGiver updatedCareGiver) { 
        return careGiverRepository.findById(id).map(careGiver -> { 
            careGiver.setName(updatedCareGiver.getName()); 
            careGiver.setSurname(updatedCareGiver.getSurname()); 
            careGiver.setEmail(updatedCareGiver.getEmail()); 
            careGiver.setPhone(updatedCareGiver.getPhone()); 
            careGiver.setCity(updatedCareGiver.getCity()); 
            careGiver.setAddress(updatedCareGiver.getAddress());
            CareGiver savedCareGiver = careGiverRepository.save(careGiver); 
            return new ResponseEntity<>(savedCareGiver, HttpStatus.OK); 
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to delete a CareGiver by ID 
    @DeleteMapping("/api/caregivers/{id}") 
    public ResponseEntity<Void> deleteCareGiver(@PathVariable UUID id) { 
        return careGiverRepository.findById(id).map(careGiver -> { 
            careGiverRepository.delete(careGiver); 
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
} 

