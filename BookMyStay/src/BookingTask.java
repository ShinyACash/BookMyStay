/**
 * A Runnable task that represents a single booking attempt in a multi-threaded environment.
 */
public class BookingTask implements Runnable {
    private SynchronizedInventory inventory;
    private String guestName;
    private String roomType;

    public BookingTask(SynchronizedInventory inventory, String guestName, String roomType) {
        this.inventory = inventory;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " attempting booking for " + guestName);

        if (inventory.tryBookRoom(roomType)) {
            System.out.println(">>> SUCCESS: " + guestName + " secured a " + roomType);
        } else {
            System.err.println(">>> FAILED: No rooms left for " + guestName);
        }
    }
}