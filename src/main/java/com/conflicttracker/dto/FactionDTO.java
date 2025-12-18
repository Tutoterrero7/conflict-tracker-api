package com.conflicttracker.dto;

public class FactionDTO {
    private Long id;
    private String name;
    private Long conflictId;
    private String conflictName;

    // Constructors
    public FactionDTO() {}

    public FactionDTO(Long id, String name, Long conflictId, String conflictName) {
        this.id = id;
        this.name = name;
        this.conflictId = conflictId;
        this.conflictName = conflictName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getConflictId() { return conflictId; }
    public void setConflictId(Long conflictId) { this.conflictId = conflictId; }

    public String getConflictName() { return conflictName; }
    public void setConflictName(String conflictName) { this.conflictName = conflictName; }
}