public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.2.0 ---\n");

        // Initialize Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        // Step 1: Register Room Types (Single Source of Truth)
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Luxury Suite", 1);

        // Step 2: Display Initial State
        inventory.displayInventory();

        // Step 3: Simulate a booking (Controlled Update)
        System.out.println("\nAction: Booking 1 Double Room...");
        inventory.updateAvailability("Double Room", -1);

        // Step 4: Verify Update
        System.out.println("Updated Availability for Double Room: " +
                inventory.getAvailability("Double Room"));

        System.out.println("\nFinal System State:");
        inventory.displayInventory();
    }
}