package com.encuentrame.project.encuentrame.entities;

import com.encuentrame.project.encuentrame.enumerations.EventResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "event_response")
public class RequestEvent {

    @Id
    @UuidGenerator
    @Column(name = "request_event_id")
    private UUID request_event_id;

    @ManyToOne
    @JoinColumn(name = "event_id" , referencedColumnName = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "user_id")
    private MyUser myUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "response")
    private EventResponse response;

}