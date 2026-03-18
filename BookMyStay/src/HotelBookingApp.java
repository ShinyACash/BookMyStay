public class HotelBookingApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.6.0 ---\n");

        // 1. Core Allocation (From UC6)
        String bookingId = "S101";

        // 2. Initialize Add-On Manager
        AddOnManager serviceManager = new AddOnManager();

        // 3. Define Available Services
        Service breakfast = new Service("Buffet Breakfast", 25.0);
        Service wifi = new Service("Premium WiFi", 10.0);
        Service spa = new Service("Spa Treatment", 120.0);

        // 4. Guest selects multiple services
        System.out.println("Action: Guest " + bookingId + " is selecting add-ons...");
        serviceManager.addService(bookingId, breakfast);
        serviceManager.addService(bookingId, spa);

        // 5. Calculate and Display
        serviceManager.displayGuestServices(bookingId);

        System.out.println("\nNote: Core inventory and room pricing remain untouched.");
    }
}