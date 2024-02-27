package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.UserRole;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class MyUser {
    @Id
    @UuidGenerator
    @Column(name = "user_id")
    private UUID user_id;

    @OneToMany(mappedBy = "myUser")
    private Set<RequestAdoption> requestAdoptions;

    @OneToMany(mappedBy = "myUser")
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