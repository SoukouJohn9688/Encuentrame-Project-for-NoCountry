package com.encuentrame.project.encuentrame.services;

import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.enumerations.AdoptionStatus;
import com.encuentrame.project.encuentrame.enumerations.HousingType;
import com.encuentrame.project.encuentrame.repositories.RequestAdoptionRepository;
import com.encuentrame.project.encuentrame.service.PetService;
import com.encuentrame.project.encuentrame.service.RequestAdoptionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class RequestAdoptionImpl implements RequestAdoptionService {

    @Autowired
    private RequestAdoptionRepository requestAdoptionRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PetService petService;


    public RequestAdoption createRequestAdoption(UUID userId, UUID petId) {
        UserDetails user = userDetailsService.loadUserByUsername("username");
        Optional<Pet> pet = petService.getPetById(petId);

        // Crear la solicitud de adopción
        RequestAdoption requestAdoption = new RequestAdoption();
        requestAdoption.setAdoptionStatus(AdoptionStatus.WAITING);
        requestAdoption.setCreationDate(LocalDateTime.now());
        requestAdoption.setMyUser((MyUser) user); //Casteo
        pet.ifPresent(requestAdoption::setPet);

        return requestAdoptionRepository.save(requestAdoption);
    }

    public List<RequestAdoption> getAllRequestAdoption() {
        return requestAdoptionRepository.findAll();
    }

    public Optional<RequestAdoption> getRequestAdoptionById(UUID id) {
        return requestAdoptionRepository.findById(id);
    }


    public Optional<RequestAdoption> updateAdoptionStatus(UUID requestId) {
        Optional<RequestAdoption> maybeRequestAdoption = requestAdoptionRepository.findById(requestId);

        return maybeRequestAdoption.
                filter(adoption -> adoption.getAdoptionStatus() == AdoptionStatus.WAITING).
                map(requestAdoption -> {

                    // Criterios de aprobación: Salario, tipo de vivienda y compromiso de esterilización

                    boolean SalaryCriteria = requestAdoption.getSalary() >= 2000;
                    boolean housingTypeCriteria = HousingType.CASA.equals(requestAdoption.getHousingType())
                            || HousingType.APARTAMENTO.equals(requestAdoption.getHousingType());
                    boolean sterilizationCommitment = requestAdoption.isSterilizationCommitment();

                    if (SalaryCriteria && housingTypeCriteria && sterilizationCommitment) {
                        requestAdoption.setAdoptionStatus(AdoptionStatus.APPROVED);
                        requestAdoptionRepository.save(requestAdoption);

                    } else {
                        requestAdoption.setAdoptionStatus(AdoptionStatus.DENIED);
                        requestAdoptionRepository.save(requestAdoption);
                    }
                    return requestAdoption;
                });
    }

    public Optional<RequestAdoption> getRequestAdoptionByPet(Pet pet) {
        return Optional.ofNullable(requestAdoptionRepository.findByPet(pet));
    }


    public boolean deleteRequestAdoption(UUID id) {
        return requestAdoptionRepository.findById(id)
                .map(requestAdoption -> {
                    requestAdoptionRepository.delete(requestAdoption);
                    return true;
                })
                .orElse(false);
    }
}