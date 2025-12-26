package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    Facility addFacility(Facility facility);
    Facility getById(Long id);
    Facility findByName(String name);
    List<Facility> getAllFacilities();
    Facility save(Facility facility);
    void delete(Long id);
}
