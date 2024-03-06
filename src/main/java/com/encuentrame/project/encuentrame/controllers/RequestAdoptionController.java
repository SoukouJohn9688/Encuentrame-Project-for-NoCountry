package com.encuentrame.project.encuentrame.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

import com.encuentrame.project.encuentrame.entities.Article;
import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.entities.Pet;
import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.repositories.RequestAdoptionRepository;
import com.encuentrame.project.encuentrame.service.PetService;
import com.encuentrame.project.encuentrame.services.RequestAdoptionImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RequestAdoptionController {
    @Autowired
     private UserDetailsService userDetailsService;

     @Autowired
     private PetService petService;
       @Autowired

    private RequestAdoptionImpl requestAdoptionServiceImpl;


    private RequestAdoptionRepository requestAdoptionRepository;

    @Autowired
    public RequestAdoptionController(RequestAdoptionRepository requestAdoptionRepository) {
        this.requestAdoptionRepository = requestAdoptionRepository;
    }

  
    //GetAll
    @GetMapping("/api/requestAdoptions")
    public ResponseEntity<List<RequestAdoption>> getAllRequestAdoption() {
        List<RequestAdoption> requestAdoptions = requestAdoptionRepository.findAll(); 
        return new ResponseEntity<>(requestAdoptions, HttpStatus.OK); 
    }
    
    //GetById
    @GetMapping("/api/requestAdoptions/{id}") 
    public ResponseEntity<RequestAdoption> getRequestAdoptionById(@PathVariable UUID id) { 
        return requestAdoptionRepository.findById(id).map(requestAdoption -> new ResponseEntity<>(requestAdoption, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    @PostMapping("/api/requestAdoptions")
    public ResponseEntity<RequestAdoption> createRequestAdoption(@RequestBody RequestAdoption requestAdoption) { 
        RequestAdoption savedRequestAdoption = requestAdoptionServiceImpl.createRequestAdoption(
            requestAdoption.getMyUser().getUser_id(),
            requestAdoption.getPet().getPet_id(),
            requestAdoption.getSalary(),
            requestAdoption.getHousingType(),
            requestAdoption.isSterilizationCommitment()
        );
        return new ResponseEntity<>(savedRequestAdoption, HttpStatus.CREATED);
    }
//     @PostMapping("/api/requestAdoptions")
//     public ResponseEntity<RequestAdoption> createRequestAdoption(@RequestBody RequestAdoption request) {

//     MyUser myUser = request.getMyUser();
//     Pet pet = request.getPet();

//     RequestAdoption createdRequest = requestAdoptionServiceImpl.createRequestAdoption(myUser, pet);

//     if (createdRequest != null) {
//         return ResponseEntity.ok(createdRequest);
//     } else {
//         return ResponseEntity.badRequest().build();
//     }
// }
}

// @Service
// @Transactional
// public class RequestAdoptionImpl implements RequestAdoptionService {

//     @Autowired
//     private RequestAdoptionRepository requestAdoptionRepository;

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Autowired
//     private PetService petService;


//     public RequestAdoption createRequestAdoption(UUID userId, UUID petId) {
//         UserDetails user = userDetailsService.loadUserByUsername("username");
//         Optional<Pet> pet = petService.getPetById(petId);

//         // Crear la solicitud de adopción
//         RequestAdoption requestAdoption = new RequestAdoption();
//         requestAdoption.setAdoptionStatus(AdoptionStatus.WAITING);
//         requestAdoption.setCreationDate(LocalDateTime.now());
//         requestAdoption.setMyUser((MyUser) user); //Casteo
//         pet.ifPresent(requestAdoption::setPet);

//         return requestAdoptionRepository.save(requestAdoption);
//     }

//     public List<RequestAdoption> getAllRequestAdoption() {
//         return requestAdoptionRepository.findAll();
//     }

//     public Optional<RequestAdoption> getRequestAdoptionById(UUID id) {
//         return requestAdoptionRepository.findById(id);
//     }


//     public Optional<RequestAdoption> updateAdoptionStatus(UUID requestId) {
//         Optional<RequestAdoption> maybeRequestAdoption = requestAdoptionRepository.findById(requestId);

//         return maybeRequestAdoption.
//                 filter(adoption -> adoption.getAdoptionStatus() == AdoptionStatus.WAITING).
//                 map(requestAdoption -> {

//                     // Criterios de aprobación: Salario, tipo de vivienda y compromiso de esterilización

//                     boolean SalaryCriteria = requestAdoption.getSalary() >= 2000;
//                     boolean housingTypeCriteria = HousingType.CASA.equals(requestAdoption.getHousingType())
//                             || HousingType.APARTAMENTO.equals(requestAdoption.getHousingType());
//                     boolean sterilizationCommitment = requestAdoption.isSterilizationCommitment();

//                     if (SalaryCriteria && housingTypeCriteria && sterilizationCommitment) {
//                         requestAdoption.setAdoptionStatus(AdoptionStatus.APPROVED);
//                         requestAdoptionRepository.save(requestAdoption);

//                     } else {
//                         requestAdoption.setAdoptionStatus(AdoptionStatus.DENIED);
//                         requestAdoptionRepository.save(requestAdoption);
//                     }
//                     return requestAdoption;
//                 });
//     }

//     public Optional<RequestAdoption> getRequestAdoptionByPet(Pet pet) {
//         return Optional.ofNullable(requestAdoptionRepository.findByPet(pet));
//     }


//     public boolean deleteRequestAdoption(UUID id) {
//         return requestAdoptionRepository.findById(id)
//                 .map(requestAdoption -> {
//                     requestAdoptionRepository.delete(requestAdoption);
//                     return true;
//                 })
//                 .orElse(false);
//     }
// }