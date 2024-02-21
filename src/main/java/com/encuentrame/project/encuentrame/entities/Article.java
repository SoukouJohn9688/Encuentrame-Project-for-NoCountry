package com.encuentrame.project.encuentrame.entities;
<<<<<<< HEAD

=======
>>>>>>> origin/dev-mc
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.validation.constraints.NotBlank;
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> origin/dev-mc
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
<<<<<<< HEAD
    @NotBlank(message = "The title cannot be blank.")
    private String title;
    @NotBlank(message = "The content cannot be blank.")
    private String content;
    @NotBlank(message = "The admin Id cannot be blank.")
    private Integer id_admin;

=======
    private String titulo;
    private String contenido;
    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private User user;
>>>>>>> origin/dev-mc
}
