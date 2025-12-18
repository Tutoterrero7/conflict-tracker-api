package com.conflicttracker.service;

import com.conflicttracker.dto.CountryCreateDTO;
import com.conflicttracker.dto.CountryDTO;
import com.conflicttracker.model.Country;
import com.conflicttracker.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CountryDTO getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        return convertToDTO(country);
    }

    public CountryDTO getCountryByCode(String code) {
        Country country = countryRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Country not found with code: " + code));
        return convertToDTO(country);
    }

    public CountryDTO createCountry(CountryCreateDTO countryCreateDTO) {
        Country country = new Country();
        country.setName(countryCreateDTO.getName());
        country.setCode(countryCreateDTO.getCode());

        Country savedCountry = countryRepository.save(country);
        return convertToDTO(savedCountry);
    }

    public CountryDTO updateCountry(Long id, CountryCreateDTO countryCreateDTO) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));

        country.setName(countryCreateDTO.getName());
        country.setCode(countryCreateDTO.getCode());

        Country updatedCountry = countryRepository.save(country);
        return convertToDTO(updatedCountry);
    }

    public void deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new RuntimeException("Country not found with id: " + id);
        }
        countryRepository.deleteById(id);
    }

    private CountryDTO convertToDTO(Country country) {
        return new CountryDTO(
                country.getId(),
                country.getName(),
                country.getCode()
        );
    }
}