package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment")
public class ApartmentUnitController {

    private final ApartmentUnitService service;

    public ApartmentUnitController(ApartmentUnitService service) {
        this.service = service;
    }

    @GetMapping
    public List<ApartmentUnit> getAll() {
        return service.getAllUnits();
    }

    @GetMapping("/{id}")
    public ApartmentUnit getById(@PathVariable Long id) {
        return service.getUnitById(id);
    }

    @PostMapping
    public ApartmentUnit create(@RequestBody ApartmentUnit unit) {
        return service.saveUnit(unit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUnit(id);
    }
}
