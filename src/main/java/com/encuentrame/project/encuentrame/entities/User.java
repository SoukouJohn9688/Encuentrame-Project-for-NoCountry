package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}