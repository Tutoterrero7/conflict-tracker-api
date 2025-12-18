package com.conflicttracker.service;

import com.conflicttracker.dto.FactionCreateDTO;
import com.conflicttracker.dto.FactionDTO;
import com.conflicttracker.model.Conflict;
import com.conflicttracker.model.Faction;
import com.conflicttracker.repository.ConflictRepository;
import com.conflicttracker.repository.FactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FactionService {

    @Autowired
    private FactionRepository factionRepository;

    @Autowired
    private ConflictRepository conflictRepository;

    public List<FactionDTO> getAllFactions() {
        return factionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FactionDTO getFactionById(Long id) {
        Faction faction = factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found with id: " + id));
        return convertToDTO(faction);
    }

    public List<FactionDTO> getFactionsByConflictId(Long conflictId) {
        Conflict conflict = conflictRepository.findById(conflictId)
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + conflictId));

        return factionRepository.findByConflict(conflict)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FactionDTO createFaction(FactionCreateDTO factionCreateDTO) {
        Conflict conflict = conflictRepository.findById(factionCreateDTO.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + factionCreateDTO.getConflictId()));

        Faction faction = new Faction();
        faction.setName(factionCreateDTO.getName());
        faction.setConflict(conflict);

        Faction savedFaction = factionRepository.save(faction);
        return convertToDTO(savedFaction);
    }

    public FactionDTO updateFaction(Long id, FactionCreateDTO factionCreateDTO) {
        Faction faction = factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found with id: " + id));

        Conflict conflict = conflictRepository.findById(factionCreateDTO.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + factionCreateDTO.getConflictId()));

        faction.setName(factionCreateDTO.getName());
        faction.setConflict(conflict);

        Faction updatedFaction = factionRepository.save(faction);
        return convertToDTO(updatedFaction);
    }

    public void deleteFaction(Long id) {
        if (!factionRepository.existsById(id)) {
            throw new RuntimeException("Faction not found with id: " + id);
        }
        factionRepository.deleteById(id);
    }

    private FactionDTO convertToDTO(Faction faction) {
        return new FactionDTO(
                faction.getId(),
                faction.getName(),
                faction.getConflict().getId(),
                faction.getConflict().getName()
        );
    }
}