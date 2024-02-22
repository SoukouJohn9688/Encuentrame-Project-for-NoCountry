package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class User {
    @Id
    @Column(name = "user_id")
    private UUID user_id;

    @OneToMany(mappedBy = "user")
    private Set<RequestAdoption> requestAdoptions;

    @OneToMany(mappedBy = "user")
    private Set<Article> articles;


    private String first_name;
    private String last_name;
    private String email;
    private String password;
}
