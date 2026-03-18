public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.5.0 ---\n");

        // 1. Setup Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Luxury Suite", 1);

        // 2. Setup Queue & Fill it
        BookingRequestQueue intake = new BookingRequestQueue();
        intake.submitRequest(new Reservation("Akash", "Luxury Suite"));
        intake.submitRequest(new Reservation("Shiny", "Luxury Suite")); // Should fail (sold out)
        intake.submitRequest(new Reservation("Bob", "Single Room"));

        // 3. Initialize Allocation Engine
        AllocationService engine = new AllocationService();

        // 4. Process all requests in FIFO order
        System.out.println("\n--- Starting Allocation Engine ---");
        engine.processRequest(intake, inventory); // Akash gets the Suite
        engine.processRequest(intake, inventory); // Shiny gets "Failed" (Sold out)
        engine.processRequest(intake, inventory); // Bob gets the Single Room

        // 5. Final Report
        engine.displayAllocations();
        inventory.displayInventory();
    }
}