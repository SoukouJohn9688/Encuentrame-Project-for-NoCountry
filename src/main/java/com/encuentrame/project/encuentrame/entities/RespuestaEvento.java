package com.encuentrame.project.encuentrame.entities;

import jakarta.persistence.*;

@Entity
public class RespuestaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_evento" , referencedColumnName = "id" , foreignKey = @ForeignKey(name = "FK_respuesta_evento_evento"))
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_usuario" , referencedColumnName = "id" , foreignKey = @ForeignKey(name = "FK_respuesta_evento_usuario"))
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "respuesta")
    private RespuestaEnum respuesta;


}

enum RespuestaEnum {
    Interesado,
    NoInteresado,
    NoSeguro
}
