package com.company;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Api(tags = "Event Service")
public class EventServiceController {

    @Autowired
    private EventService eventService;
    @ApiOperation("Create a new event")
    public ResponseEntity<Void> createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{eventId}")
    @ApiOperation("Update an existing event")
    public ResponseEntity<Void> updateEvent(@PathVariable int eventId, @RequestBody Event event) {
        Event existingEvent = eventService.getEvent(eventId);
        if (existingEvent != null) {
            eventService.updateEvent(event);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{eventId}")
    @ApiOperation("Get an event by its ID")
    public ResponseEntity<Event> getEvent(@PathVariable int eventId) {
        Event event = eventService.getEvent(eventId);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{eventId}")
    @ApiOperation("Delete an event by its ID")
    public ResponseEntity<Void> deleteEvent(@PathVariable int eventId) {
        Event event = eventService.getEvent(eventId);
        if (event != null) {
            eventService.deleteEvent(eventId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @ApiOperation("Get a list of all events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    @GetMapping("/byTitle")
    @ApiOperation("Get events by title")
    public List<Event> getEventsByTitle(@RequestParam String title) {
        return eventService.getAllEventsByTitle(title);
    }
}
