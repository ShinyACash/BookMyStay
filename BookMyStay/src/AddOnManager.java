import java.util.*;

/**
 * Manages the association between Reservations and their Add-On Services.
 * Demonstrates the use of Map<String, List<Object>> for complex relationships.
 */
public class AddOnManager {
    // Key: BookingID, Value: List of Services
    private Map<String, List<Service>> guestServices;

    public AddOnManager() {
        this.guestServices = new HashMap<>();
    }

    /**
     * Attaches a service to a specific booking ID.
     */
    public void addService(String bookingId, Service service) {
        // computeIfAbsent handles the "List creation" logic automatically
        guestServices.computeIfAbsent(bookingId, k -> new ArrayList<>()).add(service);
        System.out.println("Added " + service.getName() + " to Booking: " + bookingId);
    }

    /**
     * Aggregates the total cost of all services for a specific booking.
     */
    public double calculateTotalServiceCost(String bookingId) {
        List<Service> services = guestServices.get(bookingId);
        if (services == null) return 0.0;

        return services.stream().mapToDouble(Service::getPrice).sum();
    }

    public void displayGuestServices(String bookingId) {
        List<Service> services = guestServices.get(bookingId);
        System.out.println("\n--- Services for Booking: " + bookingId + " ---");
        if (services == null || services.isEmpty()) {
            System.out.println("No extra services selected.");
        } else {
            services.forEach(System.out::println);
            System.out.printf("Total Add-On Cost: $%.2f%n", calculateTotalServiceCost(bookingId));
        }
    }
}