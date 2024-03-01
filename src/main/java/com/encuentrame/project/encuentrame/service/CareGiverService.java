package com.encuentrame.project.encuentrame.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.encuentrame.project.encuentrame.entities.CareGiver;

public interface CareGiverService {
    List<CareGiver> getAllCareGivers(); 
  
    Optional<CareGiver> getCareGiverById(UUID id); 

    CareGiver createCareGiver(CareGiver careGiver);
  
    Optional<CareGiver> updateCareGiver(UUID id, CareGiver updatedCareGiver); 
  
    boolean deleteCareGiver(UUID id); 
} 