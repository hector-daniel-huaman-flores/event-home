package com.calendario.evento.controller;

import com.calendario.evento.model.Event;
import com.calendario.evento.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public Map<String, Object> listar(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", eventService.findAll());
        return result;
    }
    @GetMapping("/event/{id}")
    public Event show(@PathVariable Integer id) {
        return 	eventService.find(id);
    }
    @PostMapping("/event")
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody Event event) {
        return eventService.create(event);
    }
    @PutMapping("/event/{id}")
    public Event update(@RequestBody Event event,@PathVariable Integer id){

        Event updatedEvent = Event.builder()
                .id(id) // Mantener el mismo ID
                .title(event.getTitle())
                .description(event.getDescription())
                .date(event.getDate())
                .time(event.getTime())
                .tag(event.getTag())
                .status(event.getStatus())
                .build();

        return eventService.update(updatedEvent);
    }
    @DeleteMapping("/event/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        eventService.delete(id);
    }

}
