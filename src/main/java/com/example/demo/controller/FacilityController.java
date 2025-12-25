package com.example.demo.controller;


import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/facilities")
public class FacilityController {


private final FacilityService service;


public FacilityController(FacilityService s){ service=s; }


@PostMapping
public ResponseEntity<?> add(@RequestBody Facility f){
return ResponseEntity.ok(service.addFacility(f));
}


@GetMapping
public ResponseEntity<?> all(){ return ResponseEntity.ok(service.getAllFacilities()); }
}