import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Maintains a chronological record of all confirmed reservations.
 * Acts as an in-memory persistence layer for auditing.
 */
public class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    /**
     * Records a confirmed booking into the history.
     */
    public void recordBooking(Reservation reservation) {
        history.add(reservation);
    }

    /**
     * Returns a read-only view of the history to prevent accidental modification.
     */
    public List<Reservation> getAllBookings() {
        return Collections.unmodifiableList(history);
    }
}