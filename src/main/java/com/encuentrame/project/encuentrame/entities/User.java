package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
<<<<<<< HEAD

import org.hibernate.annotations.UuidGenerator;

import com.encuentrame.project.encuentrame.enumerations.UserRole;
=======
>>>>>>> 153d658f9e23e02a985dc0bdb9b65b875992b78a

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
<<<<<<< HEAD
    @UuidGenerator
    private UUID id;
=======
    @Column(name = "user_id")
    private UUID user_id;
>>>>>>> 153d658f9e23e02a985dc0bdb9b65b875992b78a

    @OneToMany(mappedBy = "user")
    private Set<RequestAdoption> requestAdoptions;

    @OneToMany(mappedBy = "user")
    private Set<Article> articles;

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