package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    @Autowired
    private FacilityService service;

    @PostMapping
    public Facility addFacility(@RequestBody Facility facility) {
        return service.addFacility(facility);
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return service.getAllFacilities();
    }

    @GetMapping("/{id}/timings")
    public String getTimings(@PathVariable Long id) {
        return service.getFacilityTimings(id);
    }
}
