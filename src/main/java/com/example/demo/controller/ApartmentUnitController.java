package com.example.demo.controller;


import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/units")
public class ApartmentUnitController {


private final ApartmentUnitService service;


public ApartmentUnitController(ApartmentUnitService s){ service=s; }


@PostMapping("/assign/{userId}")
public ResponseEntity<?> assign(@PathVariable Long userId,
@RequestBody ApartmentUnit u){
return ResponseEntity.ok(service.assignUnitToUser(userId,u));
}


@GetMapping("/user/{userId}")
public ResponseEntity<?> get(@PathVariable Long userId){
return ResponseEntity.ok(service.getUnitByUser(userId));
}
}