package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CareGiver {

    @Id
    @UuidGenerator
    @Column(name = "care_giver_id")
    private UUID care_giver_id;

    @OneToMany(mappedBy = "care_giver",fetch = FetchType.EAGER)
    private Set<Pet> pets;

    @NotBlank(message = "The name must not be blank")
    private String name;
    @NotBlank(message = "The surname must not be blank")
    private String surname;
    @NotBlank(message = "The email must not be blank")
    private String email;
    @NotNull(message = "The phone must not be blank")
    private Long phone;

    private String city;
    private String address;
}