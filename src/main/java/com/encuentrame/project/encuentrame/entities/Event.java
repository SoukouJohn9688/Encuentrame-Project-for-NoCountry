package com.encuentrame.project.encuentrame.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @UuidGenerator
    @Column(name = "event_id")
    private UUID event_id;
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
    private MyUser myUser;
    
}