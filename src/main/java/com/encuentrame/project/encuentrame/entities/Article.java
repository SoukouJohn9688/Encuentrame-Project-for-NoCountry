package com.encuentrame.project.encuentrame.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
<<<<<<< HEAD
    @Id
    @UuidGenerator
    private UUID id;
=======
>>>>>>> 153d658f9e23e02a985dc0bdb9b65b875992b78a

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank(message = "The title cannot be blank.")
    private String title;
    @NotBlank(message = "The content cannot be blank.")
    private String content;
    @NotBlank(message = "The admin Id cannot be blank.")
    private Integer id_admin;

}
