package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CareGiver {

    @Id
    @UuidGenerator
    private UUID caregiver_id;

    @NotBlank(message = "The name must not be blank")
    private String name;
    @NotBlank(message = "The surname must not be blank")
    private String surname;
    @NotBlank(message = "The email must not be blank")
    private String email;
    @NotBlank(message = "The phone must not be blank")
    private Long phone;

    private String city;
    private String adress;
}