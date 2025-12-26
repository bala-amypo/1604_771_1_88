package com.example.demo.service.impl;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public String getFacilityTimings(Long id) {
        Facility facility = facilityRepository.findById(id).orElse(null);

        if (facility == null) {
            return "Facility not found";
        }

        String open = facility.getOpenTime().toString();
        String close = facility.getCloseTime().toString();

        return "Open: " + open + " | Close: " + close;
    }
}
