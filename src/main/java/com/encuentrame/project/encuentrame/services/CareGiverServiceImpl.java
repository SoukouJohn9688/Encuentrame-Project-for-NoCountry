package com.encuentrame.project.encuentrame.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.encuentrame.project.encuentrame.entities.CareGiver;
import com.encuentrame.project.encuentrame.repositories.CareGiverRepository;
import com.encuentrame.project.encuentrame.service.CareGiverService;
import org.springframework.stereotype.Service;


@Service

public class CareGiverServiceImpl implements CareGiverService {
    private final CareGiverRepository careGiverRepository; 
  
    @Autowired
    public CareGiverServiceImpl(CareGiverRepository careGiverRepository) { 
        this.careGiverRepository = careGiverRepository; 
    } 
  
    @Override
    public Optional<CareGiver> getCareGiverById(UUID id) { 
        return careGiverRepository.findById(id); 
    } 
  
    @Override
    public List<CareGiver> getAllCareGivers() {
        return careGiverRepository.findAll(); 
    }

    @Override
    public CareGiver createCareGiver(CareGiver careGiver) {
        return careGiverRepository.save(careGiver); 
    }

    @Override
    public Optional<CareGiver> updateCareGiver(UUID id, CareGiver updatedCareGiver) {
        return careGiverRepository.findById(id) 
                .map(careGiver -> { 
                    careGiver.setName(updatedCareGiver.getName()); 
                    careGiver.setSurname(updatedCareGiver.getSurname()); 
                    careGiver.setEmail(updatedCareGiver.getEmail()); 
                    careGiver.setPhone(updatedCareGiver.getPhone()); 
                    careGiver.setCity(updatedCareGiver.getCity()); 
                    careGiver.setAddress(updatedCareGiver.getAddress()); 
                    return careGiverRepository.save(careGiver); 
                }); 
    }

    @Override
    public boolean deleteCareGiver(UUID id) {
        return careGiverRepository.findById(id) 
                .map(careGiver -> { 
                    careGiverRepository.delete(careGiver); 
                    return true; 
                }) 
                .orElse(false); 
    } 
}
