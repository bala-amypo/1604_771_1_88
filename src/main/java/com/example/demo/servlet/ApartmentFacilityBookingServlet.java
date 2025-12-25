package com.example.demo.servlet;

import org.springframework.stereotype.Component;

@Component
public class ApartmentFacilityBookingServlet {

    public String bookFacility(String facilityName, String userName) {
        return "Booking confirmed for " + userName + " at " + facilityName;
    }

    public String cancelBooking(String facilityName, String userName) {
        return "Booking cancelled for " + userName + " at " + facilityName;
    }
}
