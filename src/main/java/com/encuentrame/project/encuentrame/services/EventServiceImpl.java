package com.encuentrame.project.encuentrame.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.encuentrame.project.encuentrame.entities.Event;
import com.encuentrame.project.encuentrame.entities.MyUser;
import com.encuentrame.project.encuentrame.repositories.EventRepository;
import com.encuentrame.project.encuentrame.repositories.MyUserRepository;
import com.encuentrame.project.encuentrame.service.EventService;

public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final MyUserRepository myUserRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) { 
        this.eventRepository = eventRepository;
        this.myUserRepository = null; 
    }
    
    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll(); 
    }

    @Override
    public Optional<Event> getEventById(UUID id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event createEvent(String title, String content,LocalDateTime date_time, String city, String address, UUID user_id) {
        MyUser myUser = myUserRepository.findById(user_id).orElseThrow();

        Event event = new Event();
        event.setTitle(title);
        event.setContent(content);
        event.setDate_time(date_time);
        event.setCity(city);
        event.setAddress(address);
        event.setMyUser(myUser);

        return eventRepository.save(event);

    }

    @Override
    public Optional<Event> updateEvent(UUID id, Event updatedEvent) {
        return eventRepository.findById(id) 
                .map(event -> { 
                    event.setTitle(updatedEvent.getTitle()); 
                    event.setContent(updatedEvent.getContent()); 
                    return eventRepository.save(event); 
                });
    }

    @Override
    public boolean deleteEvent(UUID id) {
        return eventRepository.findById(id) 
                .map(event -> { 
                    eventRepository.delete(event); 
                    return true; 
                }) 
                .orElse(false); 
    }
    
}
