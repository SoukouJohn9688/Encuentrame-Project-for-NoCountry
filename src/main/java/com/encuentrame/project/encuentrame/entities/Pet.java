package com.encuentrame.project.encuentrame.entities;
import com.encuentrame.project.encuentrame.enumerations.Size;
import com.encuentrame.project.encuentrame.enumerations.Species;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Pet {




    @Id
    @UuidGenerator
    @Column(name = "pet_id")
    private UUID pet_id;



    @OneToMany(mappedBy = "pet")
    private Set<RequestAdoption> requestAdoptionSet;

    @ManyToOne()
    @JoinColumn(name = "care_giver_id")
    private CareGiver care_giver;

    @Enumerated(EnumType.STRING)
    private Species specie;

    @NotBlank(message = "The breed cannot be blank.")
    private String breed;

    @NotBlank(message = "The name cannot be blank.")
    private String pet_name;
    @NotBlank(message = "The age cannot be blank.")
    private  Integer age_months;
    private String color;
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotBlank(message = "The description cannot be blank.")
    private String description;
//    @NotBlank(message = "The care-giver Id cannot be blank.")
//    private Integer id_care_giver;
    @NotBlank(message = "The adoption state cannot be blank.")
    private boolean adopted;

}