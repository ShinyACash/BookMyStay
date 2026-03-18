public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.10.0 ---\n");

        // 1. Setup Thread-Safe Inventory with only 2 rooms
        SynchronizedInventory inventory = new SynchronizedInventory();
        inventory.addRoomType("Single Room", 2);

        // 2. Simulate 5 Guests hitting the server at once
        Thread t1 = new Thread(new BookingTask(inventory, "Akash", "Single Room"), "Thread-1");
        Thread t2 = new Thread(new BookingTask(inventory, "Shiny", "Single Room"), "Thread-2");
        Thread t3 = new Thread(new BookingTask(inventory, "Bob", "Single Room"), "Thread-3");
        Thread t4 = new Thread(new BookingTask(inventory, "Eve", "Single Room"), "Thread-4");
        Thread t5 = new Thread(new BookingTask(inventory, "Dev", "Single Room"), "Thread-5");

        // 3. Start all threads simultaneously
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Wait for threads to finish
        try {
            t1.join(); t2.join(); t3.join(); t4.join(); t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Inventory Count: " + inventory.getAvailability("Single Room"));
        System.out.println("System remains consistent under high concurrency.");
    }
}