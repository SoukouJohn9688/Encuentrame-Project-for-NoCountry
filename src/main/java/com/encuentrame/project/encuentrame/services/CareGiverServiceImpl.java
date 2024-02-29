package com.encuentrame.project.encuentrame.services;

import com.encuentrame.project.encuentrame.entities.CareGiver;
import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.repositories.CareGiverRepository;
import com.encuentrame.project.encuentrame.service.CareGiverService;
import com.encuentrame.project.encuentrame.service.PetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional

public class CareGiverServiceImpl implements CareGiverService {

    @Autowired
    private CareGiverRepository careGiverRepository;

    @Autowired
    private PetService petService;

    public CareGiver createCareGiver(CareGiver careGiver) {

        CareGiver careGiverRegister = new CareGiver();
        careGiverRegister.setName(careGiver.getName());
        careGiverRegister.setSurname(careGiver.getSurname());
        careGiverRegister.setEmail(careGiver.getEmail());
        careGiverRegister.setPhone(careGiver.getPhone());
        careGiverRegister.setCity(careGiver.getCity());
        careGiverRegister.setAddress(careGiver.getAddress());

        return careGiverRepository.save(careGiverRegister);
    }
    public List<CareGiver> getAllCareGivers() {
        return careGiverRepository.findAll();
    }
    public Optional<CareGiver> getCareGiverById(UUID id) {
        return careGiverRepository.findById(id);
    }
    public Optional<CareGiver> updateCareGiver(UUID id, CareGiver updatedCareGiver) {

        Optional<CareGiver> existingCareGiver = careGiverRepository.findById(id);

        if (existingCareGiver.isPresent()) {
            CareGiver careGiver = existingCareGiver.get();

            careGiver.setName(updatedCareGiver.getName());
            careGiver.setSurname(updatedCareGiver.getSurname());
            careGiver.setEmail(updatedCareGiver.getEmail());
            careGiver.setPhone(updatedCareGiver.getPhone());
            careGiver.setCity(updatedCareGiver.getCity());
            careGiver.setAddress(updatedCareGiver.getAddress());

            CareGiver careGiverUpdate = careGiverRepository.save(careGiver);

            return Optional.of(careGiverUpdate);
        } else {
            return Optional.empty();
        }
    }

    public Optional<CareGiver> getCareGiverByName(String name) {
        return Optional.ofNullable(careGiverRepository.findByName(name));
    }

    public boolean deleteCareGiver(UUID id) {
        return careGiverRepository.findById(id)
                .map(careGiver -> {
                    careGiverRepository.delete(careGiver);
                    return true;
                })
                .orElse(false);
    }

}
