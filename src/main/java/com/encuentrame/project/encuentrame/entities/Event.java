package com.encuentrame.project.encuentrame.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDTENITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date_time;
    private String city;
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private User user;
    
}
