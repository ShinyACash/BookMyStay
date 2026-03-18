import java.util.HashMap;
import java.util.Map;

/**
 * Thread-safe version of RoomInventory.
 * Uses synchronized methods to prevent race conditions during updates.
 */
public class SynchronizedInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public synchronized void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public synchronized int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    /**
     * Critical Section: The check and the update must happen atomically.
     */
    public synchronized boolean tryBookRoom(String type) {
        int current = getAvailability(type);
        if (current > 0) {
            // Simulate some processing delay to provoke race conditions if not synchronized
            try { Thread.sleep(10); } catch (InterruptedException e) {}

            inventory.put(type, current - 1);
            return true;
        }
        return false;
    }
}