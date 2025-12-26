package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartment-units")
@RequiredArgsConstructor
public class ApartmentUnitController {

    private final ApartmentUnitService service;

    /**
     * Assign unit to user
     * POST /apartment-units/assign/1
     */
    @PostMapping("/assign/{userId}")
    public ApartmentUnit assignToUser(@PathVariable Long userId,
                                      @RequestBody ApartmentUnit unit) {
        return service.assignUnitToUser(userId, unit);
    }

    /**
     * Get unit by user
     * GET /apartment-units/user/1
     */
    @GetMapping("/user/{userId}")
    public ApartmentUnit getUnitByUser(@PathVariable Long userId) {
        return service.getUnitByUser(userId);
    }
}
