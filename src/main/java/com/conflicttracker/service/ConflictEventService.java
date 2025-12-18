package com.conflicttracker.service;

import com.conflicttracker.dto.ConflictEventCreateDTO;
import com.conflicttracker.dto.ConflictEventDTO;
import com.conflicttracker.model.Conflict;
import com.conflicttracker.model.ConflictEvent;
import com.conflicttracker.repository.ConflictEventRepository;
import com.conflicttracker.repository.ConflictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConflictEventService {

    @Autowired
    private ConflictEventRepository conflictEventRepository;

    @Autowired
    private ConflictRepository conflictRepository;

    public List<ConflictEventDTO> getAllEvents() {
        return conflictEventRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConflictEventDTO getEventById(Long id) {
        ConflictEvent event = conflictEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        return convertToDTO(event);
    }

    public List<ConflictEventDTO> getEventsByConflictId(Long conflictId) {
        Conflict conflict = conflictRepository.findById(conflictId)
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + conflictId));

        return conflictEventRepository.findByConflict(conflict)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConflictEventDTO createEvent(ConflictEventCreateDTO eventCreateDTO) {
        Conflict conflict = conflictRepository.findById(eventCreateDTO.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + eventCreateDTO.getConflictId()));

        ConflictEvent event = new ConflictEvent();
        event.setEventDate(eventCreateDTO.getEventDate());
        event.setLocation(eventCreateDTO.getLocation());
        event.setDescription(eventCreateDTO.getDescription());
        event.setConflict(conflict);

        ConflictEvent savedEvent = conflictEventRepository.save(event);
        return convertToDTO(savedEvent);
    }

    public ConflictEventDTO updateEvent(Long id, ConflictEventCreateDTO eventCreateDTO) {
        ConflictEvent event = conflictEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        Conflict conflict = conflictRepository.findById(eventCreateDTO.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + eventCreateDTO.getConflictId()));

        event.setEventDate(eventCreateDTO.getEventDate());
        event.setLocation(eventCreateDTO.getLocation());
        event.setDescription(eventCreateDTO.getDescription());
        event.setConflict(conflict);

        ConflictEvent updatedEvent = conflictEventRepository.save(event);
        return convertToDTO(updatedEvent);
    }

    public void deleteEvent(Long id) {
        if (!conflictEventRepository.existsById(id)) {
            throw new RuntimeException("Event not found with id: " + id);
        }
        conflictEventRepository.deleteById(id);
    }

    private ConflictEventDTO convertToDTO(ConflictEvent event) {
        return new ConflictEventDTO(
            event.getId(),
            event.getEventDate(),
            event.getLocation(),
            event.getDescription(),
            event.getConflict().getId(),
            event.getConflict().getName()
        );
    }
}