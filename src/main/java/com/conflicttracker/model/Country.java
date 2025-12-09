package com.conflicttracker.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, length = 3)
    private String code;

    @ManyToMany(mappedBy = "countries")
    private Set<Conflict> conflicts = new HashSet<>();

    @ManyToMany(mappedBy = "supportingCountries")
    private Set<Faction> factions = new HashSet<>();

    // Constructors
    public Country() {}

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Set<Conflict> getConflicts() { return conflicts; }
    public void setConflicts(Set<Conflict> conflicts) { this.conflicts = conflicts; }

    public Set<Faction> getFactions() { return factions; }
    public void setFactions(Set<Faction> factions) { this.factions = factions; }
}