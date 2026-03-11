import java.util.HashMap;
import java.util.Map;

/**
 * Manages the centralized inventory of rooms using a HashMap.
 * Provides O(1) lookup and update capabilities.
 */
public class RoomInventory {
    // Key: Room Type (String), Value: Count (Integer)
    private Map<String, Integer> inventory;

    public RoomInventory() {
        this.inventory = new HashMap<>();
    }

    /**
     * Registers a room type with an initial stock.
     */
    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    /**
     * Retrieves current availability for a specific type.
     */
    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    /**
     * Updates availability (e.g., after a booking or cancellation).
     */
    public void updateAvailability(String type, int change) {
        if (inventory.containsKey(type)) {
            int current = inventory.get(type);
            inventory.put(type, current + change);
        }
    }

    /**
     * Displays the entire state of the inventory.
     */
    public void displayInventory() {
        System.out.println("--- Current Room Inventory Status ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Room Type: " + entry.getKey() + " | Available: " + entry.getValue());
        }
        System.out.println("-------------------------------------");
    }
}
