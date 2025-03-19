package com.calendario.evento.service.impl;

import com.calendario.evento.model.Event;
import com.calendario.evento.repository.EventRepository;
import com.calendario.evento.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repo;

    @Override
    public List<Event> findAll() {
        return repo.findAll();
    }

    @Override
    public Event create(Event event) {
        return repo.save(event);
    }

    @Override
    public Optional<Event> find(Integer id) {
        Optional<Event> eventoOptional = repo.findById(id);

        eventoOptional.ifPresent(evento -> {
            // Hacer algo con el evento encontrado
            System.out.println("Evento encontrado: " + evento.getTitle());
        });

        if (eventoOptional.isEmpty()) {
            // Manejar el caso en que el evento no se encuentre
            System.out.println("Evento no encontrado");
        }

        return eventoOptional;
    }

    @Override
    public Event update(Event event) {
        return repo.findById(event.getId())
                .map(existingEvent -> repo.save(event))
                .orElseThrow(() -> new RuntimeException("Evento con ID " + event.getId() + " no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento con ID " + id + " no encontrado"));
        repo.deleteById(id);
    }
}
