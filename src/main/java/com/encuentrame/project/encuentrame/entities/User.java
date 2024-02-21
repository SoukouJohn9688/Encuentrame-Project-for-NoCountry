package com.encuentrame.project.encuentrame.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDTENITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private LocalDate birthdate;
    private enum role{
        USER,
        MODERATOR,
        ADMIN
    }
}
