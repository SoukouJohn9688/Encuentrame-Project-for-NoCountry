package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.AdoptionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;


@Entity
public class RequestAdoption {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    private String id;

    @ManyToOne
    //@JoinColumn(name = id_usuario)
    private User user;

    @ManyToOne
    //@JoinColumn(name = id_mascota)
    private Pet pet;

    @Enumerated(EnumType.STRING)
    private AdoptionStatus adoptionStatus;

    private LocalDateTime creationDate;

    public RequestAdoption() {
    }

    public RequestAdoption(String id, User user, Pet pet, AdoptionStatus adoptionStatus, LocalDateTime creationDate) {
        this.id = id;
        this.user = user;
        this.pet = pet;
        this.adoptionStatus = adoptionStatus;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public AdoptionStatus getStatusAdoption() {
        return adoptionStatus;
    }

    public void setStatusAdoption(AdoptionStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
