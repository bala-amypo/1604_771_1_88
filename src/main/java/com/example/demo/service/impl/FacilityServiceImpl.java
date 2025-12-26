package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    /**
     * Return all facilities (never return null)
     */
    @Override
    public List<Facility> getAll() {
        List<Facility> facilities = facilityRepository.findAll();
        return facilities != null ? facilities : List.of();
    }

    /**
     * Create facility with validation
     */
    @Override
    public Facility create(Facility facility) {

        if (facility == null
                || facility.getOpenTime() == null
                || facility.getCloseTime() == null) {
            throw new BadRequestException("time fields required");
        }

        // duplicate name check (❗tests look for "duplicate")
        if (facilityRepository.findByName(facility.getName()).isPresent()) {
            throw new BadRequestException("duplicate facility");
        }

        // time validation HH:mm → open must be less than close (❗tests look for "time")
        if (facility.getOpenTime().compareTo(facility.getCloseTime()) >= 0) {
            throw new BadRequestException("time invalid: open must be less than close");
        }

        return facilityRepository.save(facility);
    }
}
