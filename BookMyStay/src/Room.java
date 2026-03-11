/**
 * Abstract class representing a generalized Hotel Room.
 * Enforces a structure for all specialized room types.
 */
public abstract class Room {
    protected String roomType;
    protected double price;
    protected int capacity;

    public Room(String roomType, double price, int capacity) {
        this.roomType = roomType;
        this.price = price;
        this.capacity = capacity;
    }

    // Encapsulated behavior to show room info
    public void displayDetails() {
        System.out.printf("Type: %-15s | Price: $%-6.2f | Capacity: %d guests%n",
                roomType, price, capacity);
    }
}