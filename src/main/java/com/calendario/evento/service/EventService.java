package com.calendario.evento.service;

import com.calendario.evento.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Event create(Event event);

    Event find(Integer id);

    Event update(Event event);

    void delete(Integer id);
}
