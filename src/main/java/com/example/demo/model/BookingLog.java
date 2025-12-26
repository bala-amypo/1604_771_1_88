package com.example.demo.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingLog {
    private Long id;
    private Booking booking;
    private String message;
    private String createdBy;
}
