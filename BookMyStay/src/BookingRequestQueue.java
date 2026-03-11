import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages incoming booking requests using a FIFO queue.
 * Ensures fairness by preserving arrival order.
 */
public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        // LinkedList is the standard choice for a basic FIFO Queue in Java
        this.requestQueue = new LinkedList<>();
    }

    /**
     * Intake: Adds a new request to the end of the line.
     */
    public void submitRequest(Reservation request) {
        requestQueue.add(request);
        System.out.println("Enqueued: " + request);
    }

    /**
     * Provides the next request in line without removing it (Peek).
     */
    public Reservation nextInLine() {
        return requestQueue.peek();
    }

    /**
     * Displays the current waiting line status.
     */
    public void displayQueue() {
        System.out.println("\n--- Current Booking Request Queue ---");
        if (requestQueue.isEmpty()) {
            System.out.println("The queue is currently empty.");
        } else {
            for (Reservation r : requestQueue) {
                System.out.println(">> " + r);
            }
        }
        System.out.println("-------------------------------------");
    }

    // This will be used in the next UC to actually process bookings
    public Reservation processNext() {
        return requestQueue.poll();
    }
}
