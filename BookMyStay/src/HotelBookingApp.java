public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.7.0 ---\n");

        // 1. Setup Infrastructure
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 10);

        BookingRequestQueue queue = new BookingRequestQueue();
        AllocationService engine = new AllocationService();

        // NEW: Setup Persistence & Reporting
        BookingHistory history = new BookingHistory();
        ReportingService adminService = new ReportingService();

        // 2. Simulate Bookings
        Reservation r1 = new Reservation("Akash", "Single Room");
        Reservation r2 = new Reservation("Shiny", "Single Room");

        queue.submitRequest(r1);
        queue.submitRequest(r2);

        // 3. Process & Record (Manual trigger for this UC)
        System.out.println("\nAction: Processing and Archiving Bookings...");

        // In a real flow, engine.processRequest would return the confirmed reservation
        engine.processRequest(queue, inventory);
        history.recordBooking(r1); // Archiving the success

        engine.processRequest(queue, inventory);
        history.recordBooking(r2); // Archiving the success

        // 4. Admin Action: Generate Report
        adminService.generateFullReport(history);
    }
}