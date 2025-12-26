package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Booking {
    private Long id;
    private Facility facility;
    private User user;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
