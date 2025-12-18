package com.conflicttracker.dto;

import com.conflicttracker.model.Conflict.ConflictStatus;
import java.time.LocalDate;
import com.conflicttracker.dto.ConflictDTO; // Importación necesaria

public class ConflictDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private ConflictStatus status;
    private String description;

    // Constructors
    public ConflictDTO() {}

    public ConflictDTO(Long id, String name, LocalDate startDate, ConflictStatus status, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.status = status;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public ConflictStatus getStatus() { return status; }
    public void setStatus(ConflictStatus status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}