package com.encuentrame.project.encuentrame.services;

import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.enumerations.AdoptionStatus;
import com.encuentrame.project.encuentrame.repositories.RequestAdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class RequestAdoptionService {

    @Autowired
    private RequestAdoptionRepository requestAdoptionRepository;

    @Autowired
    private MyUserService myUserService;

    @Autowired
    private PetService petService;

    @Transactional
    public RequestAdoption createRequestAdoption(UUID userId, UUID petId) {

        //obtengo usuario y contraseña, se debe especificar el método en service de MyUser y PetService
        //MyUser user = myUserService.getMyUserById(userId);
        //Pet pet = petService.getPetById(petId);

        // Crear la solicitud de adopción

        RequestAdoption requestAdoption = new RequestAdoption();
        requestAdoption.setAdoptionStatus(AdoptionStatus.WAITING);
        requestAdoption.setCreationDate(new Date());

        //requestAdoption.setMyUser(myUser);
        //requestAdoption.setPet(pet);
        //Atributos de aprobación. --> requestAdoption.setSalary(salary);

        return requestAdoptionRepository.save(requestAdoption);
    }

    @Transactional(readOnly = true)
    public List<RequestAdoption> listRequestAdoption(){
        List<RequestAdoption> requestAdoptions = new ArrayList<>();
        requestAdoptions = requestAdoptionRepository.findAll();
        return requestAdoptions;
    }

    //Método de updateAdoptionStatus considero debe estar en reemplazo de actualizar solito.

    //@Transactional(readOnly = true)
    //public boolean updateAdoptionStatus(UUID requestId) {
      //  Optional<RequestAdoption> requestAdoption = requestAdoptionRepository.findById(requestId);

       // if (requestAdoption != null && requestAdoption.getAdoptionStatus() == AdoptionStatus.WAITING) {

        // Ejemplo:Ingresos
            //boolean salaryCriteria = requestAdoption.getSalary() > 5000000;
            //boolean housingTypeCriteria = "House".equalsIgnoreCase(requestAdoption.getHousingType());

            //if (salaryCriteria && housingTypeCriteria) {
                // Si se cumplen los criterios, aprueba la solicitud
                //requestAdoption.setAdoptionStatus(AdoptionStatus.APPROVED);
                //requestAdoptionRepository.save(requestAdoption);
                //return true;
            //} else {
                // Si no se cumplen los criterios.
                //requestAdoption.setAdoptionStatus(AdoptionStatus.DENIED);
                //requestAdoptionRepository.save(requestAdoption);
              //  return false;
            }
       // }
        //return false;
    //}

