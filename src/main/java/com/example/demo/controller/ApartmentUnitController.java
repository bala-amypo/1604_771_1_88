package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @PostMapping("/{userId}")
    public ApartmentUnit assignUnit(@PathVariable Long userId,
                                    @RequestBody ApartmentUnit unit) {
        return apartmentUnitService.assignUnitToUser(userId, unit);
    }

    @GetMapping("/{userId}")
    public ApartmentUnit getUnit(@PathVariable Long userId) {
        return apartmentUnitService.getUnitByUser(userId);
    }
}
