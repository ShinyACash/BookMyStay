import java.io.*;
import java.util.Map;

/**
 * Handles saving and loading system state to a file.
 * Transitioning from in-memory to durable system design.
 */
public class PersistenceService {
    private static final String DATA_FILE = "hotel_state.ser";

    /**
     * Serializes the inventory and history into a file.
     */
    public void saveState(RoomInventory inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(inventory);
            System.out.println(">>> SYSTEM: State successfully persisted to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("CRITICAL ERROR: Could not save system state: " + e.getMessage());
        }
    }

    /**
     * Deserializes data from the file back into memory.
     */
    public RoomInventory loadState() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println(">>> SYSTEM: No persistence file found. Starting fresh.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (RoomInventory) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("RECOVERY FAILED: Corrupted data file. Starting fresh.");
            return null;
        }
    }
}