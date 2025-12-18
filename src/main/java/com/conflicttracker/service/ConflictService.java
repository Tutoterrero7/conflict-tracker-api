package com.conflicttracker.service;

import com.conflicttracker.dto.ConflictCreateDTO;
import com.conflicttracker.dto.ConflictDTO;
import com.conflicttracker.model.Conflict;
import com.conflicttracker.model.Conflict.ConflictStatus;
import com.conflicttracker.repository.ConflictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConflictService {

    @Autowired
    private ConflictRepository conflictRepository;

    public List<ConflictDTO> getAllConflicts() {
        return conflictRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ConflictDTO> getConflictsByStatus(ConflictStatus status) {
        return conflictRepository.findByStatus(status)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ConflictDTO getConflictById(Long id) {
        Conflict conflict = conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + id));
        return convertToDTO(conflict);
    }

    public ConflictDTO createConflict(ConflictCreateDTO conflictCreateDTO) {
        Conflict conflict = new Conflict();
        conflict.setName(conflictCreateDTO.getName());
        conflict.setStartDate(conflictCreateDTO.getStartDate());
        conflict.setStatus(conflictCreateDTO.getStatus());
        conflict.setDescription(conflictCreateDTO.getDescription());

        Conflict savedConflict = conflictRepository.save(conflict);
        return convertToDTO(savedConflict);
    }

    public ConflictDTO updateConflict(Long id, ConflictCreateDTO conflictCreateDTO) {
        Conflict conflict = conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found with id: " + id));

        conflict.setName(conflictCreateDTO.getName());
        conflict.setStartDate(conflictCreateDTO.getStartDate());
        conflict.setStatus(conflictCreateDTO.getStatus());
        conflict.setDescription(conflictCreateDTO.getDescription());

        Conflict updatedConflict = conflictRepository.save(conflict);
        return convertToDTO(updatedConflict);
    }

    public void deleteConflict(Long id) {
        if (!conflictRepository.existsById(id)) {
            throw new RuntimeException("Conflict not found with id: " + id);
        }
        conflictRepository.deleteById(id);
    }

    // NUEVO MÉTODO: Obtener conflictos por código de país
    public List<ConflictDTO> getConflictsByCountryCode(String countryCode) {
        return conflictRepository.findByCountryCode(countryCode)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ConflictDTO convertToDTO(Conflict conflict) {
        return new ConflictDTO(
                conflict.getId(),
                conflict.getName(),
                conflict.getStartDate(),
                conflict.getStatus(),
                conflict.getDescription()
        );
    }
}