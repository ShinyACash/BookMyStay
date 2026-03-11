public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.4.0 ---\n");

        // Initialize the Intake Mechanism
        BookingRequestQueue intake = new BookingRequestQueue();

        // Guest Actions: Multiple requests arrive in sequence
        System.out.println("Action: Intake starting for peak hours...");

        intake.submitRequest(new Reservation("Akash", "Luxury Suite"));
        intake.submitRequest(new Reservation("Shiny", "Single Room"));
        intake.submitRequest(new Reservation("Bob", "Double Room"));

        // Display the order (FIFO preservation)
        intake.displayQueue();

        System.out.println("\nSystem Note: Requests are queued. No inventory has been modified yet.");
    }
}