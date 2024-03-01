package com.encuentrame.project.encuentrame.entities;

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

    @Id
    @UuidGenerator
    private UUID article_id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private MyUser myUser;

    @NotBlank(message = "The title cannot be blank.")
    private String title;
    @NotBlank(message = "The content cannot be blank.")
    private String content;

}