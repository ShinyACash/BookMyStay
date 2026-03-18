import java.util.HashMap;
import java.util.Map;

public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.8.0 [Secure Mode] ---\n");

        // Setup
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 1); // Only 1 left!

        Map<String, Room> catalog = new HashMap<>();
        catalog.put("Single Room", new SingleRoom());

        ValidationService validator = new ValidationService();
        BookingRequestQueue queue = new BookingRequestQueue();
        AllocationService engine = new AllocationService();

        // Simulate a mix of valid and invalid requests
        queue.submitRequest(new Reservation("Akash", "Single Room"));   // Valid
        queue.submitRequest(new Reservation("Shiny", "Penthouse"));     // Invalid Room
        queue.submitRequest(new Reservation("Bob", "Single Room"));     // Out of Stock

        System.out.println("\n--- Processing with Error Handling ---");

        while (queue.nextInLine() != null) {
            Reservation current = queue.nextInLine(); // Peek to validate
            try {
                validator.validateRequest(current, inventory, catalog);
                engine.processRequest(queue, inventory); // Only runs if validation passes
            } catch (BookingException e) {
                System.err.println("BLOCKING FAILED: " + e.getMessage());
                queue.processNext(); // Remove the "bad" request from queue to move on
            }
        }

        System.out.println("\nSystem remains stable. Inventory is protected.");
    }
}