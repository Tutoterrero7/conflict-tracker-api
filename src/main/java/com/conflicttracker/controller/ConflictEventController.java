package com.conflicttracker.controller;

import com.conflicttracker.dto.ConflictEventCreateDTO;
import com.conflicttracker.dto.ConflictEventDTO;
import com.conflicttracker.service.ConflictEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class ConflictEventController {

    @Autowired
    private ConflictEventService conflictEventService;

    @GetMapping
    public ResponseEntity<List<ConflictEventDTO>> getAllEvents() {
        return ResponseEntity.ok(conflictEventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictEventDTO> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(conflictEventService.getEventById(id));
    }

    @GetMapping("/conflict/{conflictId}")
    public ResponseEntity<List<ConflictEventDTO>> getEventsByConflictId(@PathVariable Long conflictId) {
        return ResponseEntity.ok(conflictEventService.getEventsByConflictId(conflictId));
    }

    @PostMapping
    public ResponseEntity<ConflictEventDTO> createEvent(@RequestBody ConflictEventCreateDTO eventCreateDTO) {
        ConflictEventDTO createdEvent = conflictEventService.createEvent(eventCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictEventDTO> updateEvent(
            @PathVariable Long id,
            @RequestBody ConflictEventCreateDTO eventCreateDTO) {

        return ResponseEntity.ok(conflictEventService.updateEvent(id, eventCreateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        conflictEventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}