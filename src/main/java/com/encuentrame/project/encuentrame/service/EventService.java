package com.encuentrame.project.encuentrame.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.encuentrame.project.encuentrame.entities.Event;

public interface EventService {
    List<Event> getAllEvents(); 
  
    Optional<Event> getEventById(UUID id); 
    Event createEvent(String title, String content,LocalDateTime date_time, String city, String address, UUID user_id); 
  
    Optional<Event> updateEvent(UUID id, Event updatedEvent); 
  
    boolean deleteEvent(UUID id); 
    
}

