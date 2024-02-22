package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @Column(name = "user_id")
    int userID;

    @OneToMany(mappedBy = "user")
    private Set<RequestAdoption> requestAdoptions;

    @OneToMany(mappedBy = "user")
    private Set<Article> articles;


    private String first_name;
    private String last_name;
    private String email;
    private String password;
}
