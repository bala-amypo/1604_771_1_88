package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<@Nullable Object> assignUnit(
            @PathVariable Long userId,
            @RequestBody ApartmentUnit unit) {

        return ResponseEntity.ok(
                apartmentUnitService.assignUnitToUser(userId, unit)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<@Nullable Object> getUnitByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(
                apartmentUnitService.getUnitByUser(userId)
        );
    }
}
