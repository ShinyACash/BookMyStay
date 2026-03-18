/**
 * Custom Exception for Hotel Booking Domain errors.
 * Improves readability and error tracing.
 */
public class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}