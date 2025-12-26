@Override
public List<Booking> getAllBookings() {
    return bookingRepo.findAll();
}

@Override
public Booking saveBooking(Booking booking) {
    return bookingRepo.save(booking);
}

@Override
public Booking getBookingById(Long id) {
    return bookingRepo.findById(id).orElse(null);
}

// Already required by test
@Override
public void deleteBooking(Long id) {
    bookingRepo.deleteById(id);
}
