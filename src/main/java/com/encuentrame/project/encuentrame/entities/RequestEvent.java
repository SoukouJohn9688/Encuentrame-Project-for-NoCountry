package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.EventResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class RequestEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_evento" , referencedColumnName = "id" , foreignKey = @ForeignKey(name = "FK_respuesta_evento_evento"))
    private Event evento;

    @ManyToOne
    @JoinColumn(name = "id_usuario" , referencedColumnName = "id" , foreignKey = @ForeignKey(name = "FK_respuesta_evento_usuario"))
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "respuesta")
    private EventResponse respuesta;

}

