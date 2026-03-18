import java.util.*;

/**
 * Processes queued requests and performs safe room allocation.
 * Uses Sets to ensure Room ID uniqueness and prevent double-booking.
 */
public class AllocationService {
    // Maps Room Type -> Set of unique assigned Room IDs
    private Map<String, Set<String>> allocatedRooms;
    private int idCounter = 101; // Starting ID for rooms

    public AllocationService() {
        this.allocatedRooms = new HashMap<>();
    }

    /**
     * Processes the next request from the queue.
     */
    public void processRequest(BookingRequestQueue queue, RoomInventory inventory) {
        Reservation request = queue.processNext();
        if (request == null) {
            System.out.println("No requests to process.");
            return;
        }

        String type = request.getRoomType();
        System.out.println("\nProcessing: " + request.getGuestName() + " for " + type);

        // 1. Check Inventory (Synchronization)
        if (inventory.getAvailability(type) > 0) {
            // 2. Generate Unique Room ID
            String roomId = type.substring(0, 1).toUpperCase() + idCounter++;

            // 3. Uniqueness Enforcement using a Set
            allocatedRooms.putIfAbsent(type, new HashSet<>());
            Set<String> assignedIds = allocatedRooms.get(type);

            if (assignedIds.add(roomId)) { // .add() returns false if ID already exists
                // 4. Successful Allocation: Update Inventory immediately
                inventory.updateAvailability(type, -1);
                System.out.println("SUCCESS: Room " + roomId + " assigned to " + request.getGuestName());
            } else {
                System.out.println("ERROR: Collision detected for ID " + roomId);
            }
        } else {
            System.out.println("FAILED: No availability for " + type);
        }
    }

    public void displayAllocations() {
        System.out.println("\n--- Current Room Allocations ---");
        allocatedRooms.forEach((type, ids) ->
                System.out.println(type + " IDs: " + ids));
        System.out.println("--------------------------------");
    }
}