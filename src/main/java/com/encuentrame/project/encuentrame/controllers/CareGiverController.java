package com.encuentrame.project.encuentrame.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.encuentrame.project.encuentrame.services.CareGiverServiceImpl;
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
    private final CareGiverServiceImpl careGiverService;

    @Autowired
    public CareGiverController(CareGiverRepository careGiverRepository, CareGiverServiceImpl careGiverService) {
        this.careGiverRepository = careGiverRepository;
        this.careGiverService = careGiverService;
    }




  
    // Endpoint to retrieve all CareGivers 
    @GetMapping("/api/caregivers")
    public ResponseEntity<List<CareGiver>> getAllCareGivers() { 
        List<CareGiver> careGivers =  careGiverService.getAllCareGivers();
        return new ResponseEntity<>(careGivers, HttpStatus.OK); 
    } 
  
    // Endpoint to retrieve a CareGiver by ID 
    @GetMapping("/api/caregivers/{id}") 
    public ResponseEntity<CareGiver> getCareGiverById(@PathVariable UUID id) { 
        return careGiverService.getCareGiverById(id).map(careGiver -> new ResponseEntity<>(careGiver, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to create a new CareGiver 
    @PostMapping("/api/caregivers")
    public ResponseEntity<CareGiver> createCareGiver(@RequestBody CareGiver careGiver) { 
        CareGiver savedCareGiver = careGiverService.createCareGiver(careGiver);
        return new ResponseEntity<>(savedCareGiver, HttpStatus.CREATED); 
    } 
  
    // Endpoint to update an existing CareGiver 
    @PutMapping("/api/caregivers/{id}") 
    public ResponseEntity<CareGiver> updateCareGiver(@PathVariable UUID id, @RequestBody CareGiver updatedCareGiver) {


        Optional<CareGiver> optionalCareGiver = careGiverService.updateCareGiver(id, updatedCareGiver);

        if (optionalCareGiver.isPresent()) {
            CareGiver savedCareGiver = optionalCareGiver.get();
            return new ResponseEntity<>(savedCareGiver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Endpoint to delete a CareGiver by ID
    @DeleteMapping("/api/caregivers/{id}")
    public ResponseEntity<Void> deleteCareGiver(@PathVariable UUID id) {

        boolean deletionState=careGiverService.deleteCareGiver(id);
        if(deletionState){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

