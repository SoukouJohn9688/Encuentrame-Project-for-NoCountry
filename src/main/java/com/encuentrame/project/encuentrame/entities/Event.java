package com.encuentrame.project.encuentrame.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @UuidGenerator
    private UUID id;
    @NotBlank(message = "The title cannot be blank.")
    private String title;
    @NotBlank(message = "The content cannot be blank.")
    private String content;
    @NotBlank(message = "The date time cannot be blank.")
    private LocalDateTime date_time;
    @NotBlank(message = "The city cannot be blank.")
    private String city;
    @NotBlank(message = "The address cannot be blank.")
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotBlank(message = "The user_id cannot be blank.")
    private User user;
    
}
