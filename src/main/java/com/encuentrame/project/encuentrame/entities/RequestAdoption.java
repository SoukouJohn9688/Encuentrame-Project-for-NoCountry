package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.AdoptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestAdoption {

    @Id
    @UuidGenerator
<<<<<<< HEAD
    private UUID id;
=======
    @Column(name = "adoption_id")
    private UUID adoption_id;
>>>>>>> 153d658f9e23e02a985dc0bdb9b65b875992b78a

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Enumerated(EnumType.STRING)
    private AdoptionStatus adoptionStatus;

    private LocalDateTime creationDate;
}