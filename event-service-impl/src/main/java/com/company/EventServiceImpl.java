package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event getEvent(int eventId) {
        return eventRepository.findById(Long.parseLong(String.valueOf(eventId))).orElse(null);
    }

    @Override
    public void deleteEvent(int eventId) {
        eventRepository.deleteById((Long.parseLong(String.valueOf(eventId))));
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventRepository.findByTitle(title);
    }
}

