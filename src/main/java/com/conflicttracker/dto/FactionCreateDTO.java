package com.conflicttracker.dto;

public class FactionCreateDTO {
    private String name;
    private Long conflictId;

    // Constructors
    public FactionCreateDTO() {}

    public FactionCreateDTO(String name, Long conflictId) {
        this.name = name;
        this.conflictId = conflictId;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getConflictId() { return conflictId; }
    public void setConflictId(Long conflictId) { this.conflictId = conflictId; }
}