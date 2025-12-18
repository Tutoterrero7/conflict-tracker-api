package com.conflicttracker.dto;

import com.conflicttracker.model.Conflict.ConflictStatus;
import java.time.LocalDate;

public class ConflictCreateDTO {
    private String name;
    private LocalDate startDate;
    private ConflictStatus status;
    private String description;

    // Constructors
    public ConflictCreateDTO() {}

    public ConflictCreateDTO(String name, LocalDate startDate, ConflictStatus status, String description) {
        this.name = name;
        this.startDate = startDate;
        this.status = status;
        this.description = description;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public ConflictStatus getStatus() { return status; }
    public void setStatus(ConflictStatus status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}