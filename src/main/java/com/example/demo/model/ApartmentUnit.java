package com.example.demo.model;

import lombok.Data;

@Data
public class ApartmentUnit {
    private Long id;
    private String unitNumber;
    private User owner;  // 🔥 required

}
