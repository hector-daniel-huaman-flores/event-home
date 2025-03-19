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
    public Event find(Integer id) {
        Optional<Event> op = repo.findById(id);
        return op.orElseGet(Event::new);
    }

    @Override
    public Event update(Event event) {
        return repo.save(event);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
