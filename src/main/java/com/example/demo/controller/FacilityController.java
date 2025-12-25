package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public List<Facility> getAll() {
        return facilityService.getAll();
    }

    @GetMapping("/{id}")
    public Facility getById(@PathVariable Long id) {
        return facilityService.getById(id);
    }

    @PostMapping
    public Facility create(@RequestBody Facility facility) {
        return facilityService.save(facility);
    }

    @PutMapping("/{id}")
    public Facility update(@PathVariable Long id, @RequestBody Facility facility) {
        facility.setId(id);
        return facilityService.save(facility);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        facilityService.delete(id);
        return "Facility deleted with id: " + id;
    }
}
