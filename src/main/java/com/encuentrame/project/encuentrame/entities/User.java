package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

import com.encuentrame.project.encuentrame.enumerations.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany(mappedBy = "user")
    private Set<RequestAdoption> requestAdoptions;

    @OneToMany(mappedBy = "user")
    private Set<Article> articles;

    @OneToMany(mappedBy = "user")
    private Set<Event> events;

    @NotBlank(message = "The name cannot be blank.")
    private String name;
    @NotBlank(message = "The surname cannot be blank.")
    private String surname;
    @NotBlank(message = "The email cannot be blank.")
    private String email;
    @NotBlank(message = "The password cannot be blank.")
    private String password;
    @NotBlank(message = "The birthdate cannot be blank.")
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}