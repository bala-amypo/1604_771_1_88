package com.example.demo.model;
import lombok.Data;
import java.time.LocalTime;

@Data
public class Facility {
    private Long id;
    private String name;
    private LocalTime openTime;
    private LocalTime closeTime;
}
