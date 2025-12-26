package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {

    Facility addFacility(Facility facility);   // ⭐ required by tests
    List<Facility> getAllFacilities();         // ⭐ required by tests
}
