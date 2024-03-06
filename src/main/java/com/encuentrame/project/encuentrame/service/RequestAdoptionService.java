package com.encuentrame.project.encuentrame.service;

import com.encuentrame.project.encuentrame.entities.RequestAdoption;
import com.encuentrame.project.encuentrame.enumerations.HousingType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RequestAdoptionService {

    List<RequestAdoption> getAllRequestAdoption();
    Optional<RequestAdoption> getRequestAdoptionById(UUID id);
    RequestAdoption createRequestAdoption(UUID userId, UUID petId, double Salary, HousingType housingType, boolean sterializationCommitment);
    Optional<RequestAdoption> updateAdoptionStatus(UUID requestId);

    boolean deleteRequestAdoption(UUID id);
}
