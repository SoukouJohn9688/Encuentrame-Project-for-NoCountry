package com.encuentrame.project.encuentrame.entities;
import com.encuentrame.project.encuentrame.enumerations.Size;
import com.encuentrame.project.encuentrame.enumerations.Species;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pet {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "pet_id", columnDefinition = "BINARY(16)")
    private UUID pet_id;

    @JsonIgnore
    @OneToMany(mappedBy = "pet")
    private Set<RequestAdoption> requestAdoptionSet;

    @ManyToOne()
    @JoinColumn(name = "care_giver_id")
    private CareGiver care_giver;




    @Enumerated(EnumType.STRING)
    @Column (name ="specie")
    private Species specie;

    @NotBlank(message = "The breed cannot be blank.")
    private String breed;

    @NotBlank(message = "The name cannot be blank.")
    private String pet_name;

    @NotNull(message = "The age cannot be blank.")
    private  Integer age_months;

    private String color;
    private String image_url;
    private String image_name;

    @Enumerated(EnumType.STRING)
    private Size size;

    @NotBlank(message = "The description cannot be blank.")
    private String description;

//    @NotBlank(message = "The care-giver Id cannot be blank.")
//    private Integer id_care_giver;

    private boolean adopted;

}