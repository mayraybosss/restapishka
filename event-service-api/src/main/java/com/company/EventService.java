package com.company;

import java.util.List;

public interface EventService {
    void createEvent(Event event);

    void updateEvent(Event event);

    Event getEvent(int eventId);

    void deleteEvent(int eventId);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}

