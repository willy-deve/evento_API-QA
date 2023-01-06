package eventos_testes.service;

import eventos_testes.dto.EventDTO;
import eventos_testes.entities.City;
import eventos_testes.entities.Event;
import eventos_testes.exception.ResourceNotFoundException;
import eventos_testes.repository.CityRepository;
import eventos_testes.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    public EventDTO update (Long id, EventDTO dto){

            Optional<Event> entity = eventRepository.findById(id);
            Event event = entity.orElseThrow(() -> new ResourceNotFoundException("ID não encontrado" + id));
            City city = cityRepository.findById(dto.getCityId()).get();
            event.setName(dto.getName());
            event.setDate(dto.getDate());
            event.setUrl(dto.getUrl());
            event.setCity(city);
            event = eventRepository.save(event);
            return new EventDTO(event);
    }
}
