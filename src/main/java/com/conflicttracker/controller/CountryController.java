package com.conflicttracker.controller;

import com.conflicttracker.dto.CountryCreateDTO;
import com.conflicttracker.dto.CountryDTO;
import com.conflicttracker.dto.ConflictDTO; // Importación añadida
import com.conflicttracker.service.CountryService;
import com.conflicttracker.service.ConflictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private ConflictService conflictService;

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CountryDTO> getCountryByCode(@PathVariable String code) {
        return ResponseEntity.ok(countryService.getCountryByCode(code));
    }

    @GetMapping("/{code}/conflicts")
    public ResponseEntity<List<ConflictDTO>> getConflictsByCountryCode(@PathVariable String code) {
        return ResponseEntity.ok(conflictService.getConflictsByCountryCode(code));
    }

    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryCreateDTO countryCreateDTO) {
        CountryDTO createdCountry = countryService.createCountry(countryCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(
            @PathVariable Long id,
            @RequestBody CountryCreateDTO countryCreateDTO) {

        return ResponseEntity.ok(countryService.updateCountry(id, countryCreateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}