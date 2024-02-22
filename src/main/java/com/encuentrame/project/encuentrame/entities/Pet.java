package com.encuentrame.project.encuentrame.entities;
import com.encuentrame.project.encuentrame.enumerations.Size;
import com.encuentrame.project.encuentrame.enumerations.Species;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer petID;

    @OneToMany(mappedBy = "pet")
    private Set<RequestAdoption> requestAdoptionSet;

    @Enumerated(EnumType.STRING)
    private Species specie;

    @NotBlank(message = "The breed cannot be blank.")
    private String breed;
    @NotBlank(message = "The age cannot be blank.")
    private  Integer age_months;
    private String color;
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotBlank(message = "The description cannot be blank.")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "care_giver_id")
    @NotBlank(message = "The care-giver Id cannot be blank.")
    private CareGiver care_giver;
    @NotBlank(message = "The adoption state cannot be blank.")
    private boolean adopted;



}