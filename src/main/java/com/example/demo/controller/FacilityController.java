            package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public ResponseEntity<Facility> addFacility(@RequestBody Facility facility) {
        return new ResponseEntity<>(
                facilityService.addFacility(facility),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        return ResponseEntity.ok(facilityService.getAllFacilities());
    }
}