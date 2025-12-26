package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    List<Facility> getAll();          // for listing
    Facility create(Facility facility); // for creating (tests expect this)
}
