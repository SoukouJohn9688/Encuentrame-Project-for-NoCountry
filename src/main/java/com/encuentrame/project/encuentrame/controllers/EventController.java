package com.encuentrame.project.encuentrame.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encuentrame.project.encuentrame.entities.Event;
import com.encuentrame.project.encuentrame.repositories.EventRepository;

@RestController
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) { 
        this.eventRepository = eventRepository; 
    } 
  
    // Endpoint to retrieve all Events 
    @GetMapping("/api/events")
    public ResponseEntity<List<Event>> getAllEvents() { 
        List<Event> events = eventRepository.findAll(); 
        return new ResponseEntity<>(events, HttpStatus.OK); 
    } 
  
    // Endpoint to retrieve a event by ID 
    @GetMapping("/api/events/{id}") 
    public ResponseEntity<Event> getEventById(@PathVariable UUID id) { 
        return eventRepository.findById(id).map(event -> new ResponseEntity<>(event, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to create a new event 
    @PostMapping("/api/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) { 
        Event savedEvent = eventRepository.save(event); 
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED); 
    } 
  
    // Endpoint to update an existing event 
    @PutMapping("/api/events/{id}") 
    public ResponseEntity<Event> updateEvent(@PathVariable UUID id, @RequestBody Event updatedEvent) { 
        return eventRepository.findById(id).map(event -> { 
            event.setTitle(updatedEvent.getTitle()); 
            event.setContent(updatedEvent.getContent());
            event.setDate_time(updatedEvent.getDate_time()); 
            event.setCity(updatedEvent.getCity());
            event.setAddress(updatedEvent.getAddress());
            Event savedEvent = eventRepository.save(event); 
            return new ResponseEntity<>(savedEvent, HttpStatus.OK); 
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
  
    // Endpoint to delete a event by ID 
    @DeleteMapping("/api/events/{id}") 
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID id) { 
        return eventRepository.findById(id).map(event -> { 
            eventRepository.delete(event); 
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    } 
} 