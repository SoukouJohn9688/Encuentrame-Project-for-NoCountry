package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.AdoptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request_adoptions")
@IdClass(RequestAdoptionId.class)
public class RequestAdoption implements Serializable {

    
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Enumerated(EnumType.STRING)
    private AdoptionStatus adoptionStatus;

    private LocalDateTime creationDate;

}
