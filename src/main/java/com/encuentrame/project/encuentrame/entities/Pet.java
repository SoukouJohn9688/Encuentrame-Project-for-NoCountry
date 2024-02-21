package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.Size;
import com.encuentrame.project.encuentrame.enumerations.Species;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Enumerated(EnumType.STRING)
    private Species specie;


    private enum especie{
        perro,
        gato}


    @NotBlank(message = "The breed cannot be blank.")
    private String breed;
    @NotBlank(message = "The age cannot be blank.")
    private  Integer age_months;
    private String color;
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotBlank(message = "The description cannot be blank.")
    private String description;
    @NotBlank(message = "The care-giver Id cannot be blank.")
    private Integer id_care_giver;
    @NotBlank(message = "The adoption state cannot be blank.")
    private boolean adopted;

    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_careGiver", nullable = false)
    private CareGiver careGiver;
        private boolean adoptado;




}
