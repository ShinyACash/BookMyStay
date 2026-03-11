import java.util.Map;

/**
 * Handles read-only search operations for the Hotel Booking System.
 * Ensures that guests only see actionable (available) room options.
 */
public class SearchService {

    /**
     * Searches and displays available rooms by checking the inventory
     * against the domain room objects.
     * * @param inventory The centralized state manager
     * @param rooms A map of room types to their Domain Objects (Single, Double, Suite)
     */
    public void displayAvailableRooms(RoomInventory inventory, Map<String, Room> rooms) {
        System.out.println("--- Available Rooms Search Results ---");
        boolean found = false;

        for (String type : rooms.keySet()) {
            int count = inventory.getAvailability(type);

            // Validation Logic: Defensive check to filter out zero-availability
            if (count > 0) {
                Room roomDetails = rooms.get(type);
                roomDetails.displayDetails(); // Retrieve details from Domain Model
                System.out.println("Current Availability: " + count + " rooms");
                System.out.println("-------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Sorry, no rooms are currently available.");
        }
    }
}