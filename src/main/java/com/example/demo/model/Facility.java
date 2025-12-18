package com.example.demo.service;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    public void addFacility(Facility f) {
        if (facilityRepository.findByName(f.getName()).isPresent()) {
            throw new BadRequestException("Facility with name '" + f.getName() + "' already exists.");
        }

        validateOpenAndCloseTime(f.getOpenTime(), f.getCloseTime());

        facilityRepository.save(f);
    }

    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    private void validateOpenAndCloseTime(String openTime, String closeTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime open = LocalTime.parse(openTime, formatter);
        LocalTime close = LocalTime.parse(closeTime, formatter);

        if (open.isAfter(close)) {
            throw new BadRequestException("Open time must be earlier than close time.");
        }
    }
}
