package com.conflicttracker.controller;

import com.conflicttracker.dto.FactionCreateDTO;
import com.conflicttracker.dto.FactionDTO;
import com.conflicttracker.service.FactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factions")
public class FactionController {

    @Autowired
    private FactionService factionService;

    @GetMapping
    public ResponseEntity<List<FactionDTO>> getAllFactions() {
        return ResponseEntity.ok(factionService.getAllFactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactionDTO> getFactionById(@PathVariable Long id) {
        return ResponseEntity.ok(factionService.getFactionById(id));
    }

    @GetMapping("/conflict/{conflictId}")
    public ResponseEntity<List<FactionDTO>> getFactionsByConflictId(@PathVariable Long conflictId) {
        return ResponseEntity.ok(factionService.getFactionsByConflictId(conflictId));
    }

    @PostMapping
    public ResponseEntity<FactionDTO> createFaction(@RequestBody FactionCreateDTO factionCreateDTO) {
        FactionDTO createdFaction = factionService.createFaction(factionCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactionDTO> updateFaction(
            @PathVariable Long id,
            @RequestBody FactionCreateDTO factionCreateDTO) {

        return ResponseEntity.ok(factionService.updateFaction(id, factionCreateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaction(@PathVariable Long id) {
        factionService.deleteFaction(id);
        return ResponseEntity.noContent().build();
    }
}