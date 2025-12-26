package com.example.demo.service.impl;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Facility addFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public String getFacilityTimings(Long id) {
        Facility facility = facilityRepository.findById(id).orElse(null);

        if (facility == null) {
            return "Facility not found";
        }

        return "Open: " + facility.getOpenTime().toString() +
               " | Close: " + facility.getCloseTime().toString();
    }
}
