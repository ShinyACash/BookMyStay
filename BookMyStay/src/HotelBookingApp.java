import java.util.HashMap;
import java.util.Map;

public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.3.0 ---\n");

        // 1. Initialize State (Inventory)
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 0); // Sold out for testing
        inventory.addRoomType("Luxury Suite", 2);

        // 2. Initialize Domain Objects (Room Specs)
        Map<String, Room> roomCatalog = new HashMap<>();
        roomCatalog.put("Single Room", new SingleRoom());
        roomCatalog.put("Double Room", new DoubleRoom());
        roomCatalog.put("Luxury Suite", new SuiteRoom());

        // 3. Initialize Search Service
        SearchService searchService = new SearchService();

        // 4. Guest Action: Initiate Search
        System.out.println("Action: Guest is searching for available rooms...");
        searchService.displayAvailableRooms(inventory, roomCatalog);

        System.out.println("\nSearch completed. System state remains unchanged.");
    }
}