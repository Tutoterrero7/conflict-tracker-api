package com.conflicttracker.dto;

public class CountryCreateDTO {
    private String name;
    private String code;

    // Constructors
    public CountryCreateDTO() {}

    public CountryCreateDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}