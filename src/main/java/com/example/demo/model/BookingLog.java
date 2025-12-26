@Entity
public class BookingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add these annotations:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id") 
    private Booking booking;

    private String logMessage;
    private LocalDateTime loggedAt;

    // Standard JPA requires a no-args constructor
    public BookingLog() {}

    public BookingLog(Long id, Booking booking, String message, LocalDateTime loggedAt){
        this.id = id;
        this.booking = booking;
        this.logMessage = message;
        this.loggedAt = loggedAt;
    }
    
    // ... rest of your code
}