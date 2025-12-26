package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    List<Facility> getAll();
    Facility create(Facility facility);
}
