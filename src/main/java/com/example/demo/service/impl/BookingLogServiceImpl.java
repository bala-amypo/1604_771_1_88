@Service
public class BookingLogServiceImpl implements BookingLogService {
    private final BookingLogRepository logRepo;
    private final BookingRepository bookingRepo;

    public BookingLogServiceImpl(BookingLogRepository l, BookingRepository b){
        this.logRepo=l; this.bookingRepo=b;
    }

    @Override
    public BookingLog addLog(Long bookingId, String msg){
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        return logRepo.save(new BookingLog(null,b,msg,LocalDateTime.now()));
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long id){
        Booking b = bookingRepo.findById(id).orElseThrow();
        return logRepo.findByBookingOrderByLoggedAtAsc(b);
    }
}
