package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class FacilityServiceimpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityServiceimpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility addFacility(Facility facility) {

        if (facilityRepository.findByName(facility.getName()).isPresent()) {
            throw new BadRequestException("Facility already exists");
        }

        LocalTime open = LocalTime.parse(facility.getOpenTime());
        LocalTime close = LocalTime.parse(facility.getCloseTime());

        if (!open.isBefore(close)) {
            throw new BadRequestException("Invalid facility time range");
        }

        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}
