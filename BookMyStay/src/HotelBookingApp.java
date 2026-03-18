public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v2.1.0 [Durable Edition] ---\n");

        PersistenceService persistence = new PersistenceService();

        // 1. RECOVERY: Try to load old state
        RoomInventory inventory = persistence.loadState();

        if (inventory == null) {
            // No previous state? Initialize fresh
            inventory = new RoomInventory();
            inventory.addRoomType("Luxury Suite", 5);
            System.out.println("Action: New inventory created.");
        } else {
            System.out.println("Action: System state recovered from previous session.");
        }

        // 2. OPERATION: Show current state and make a change
        inventory.displayInventory();
        System.out.println("\nAction: Booking 1 Suite...");
        inventory.updateAvailability("Luxury Suite", -1);
        inventory.displayInventory();

        // 3. PERSISTENCE: Save before exit
        System.out.println("\nShutting down...");
        persistence.saveState(inventory);
    }
}