import java.util.Map;

/**
 * Validates inputs and system constraints before processing.
 * Implements "Fail-Fast" design to protect system state.
 */
public class ValidationService {

    /**
     * Validates if a booking request is actually possible.
     * @throws BookingException if any business rule is violated.
     */
    public void validateRequest(Reservation request, RoomInventory inventory, Map<String, Room> catalog)
            throws BookingException {

        String type = request.getRoomType();

        // 1. Validate Input: Does the room type even exist?
        if (!catalog.containsKey(type)) {
            throw new BookingException("INVALID ROOM TYPE: '" + type + "' does not exist in our catalog.");
        }

        // 2. Validate State: Is there actually stock?
        if (inventory.getAvailability(type) <= 0) {
            throw new BookingException("OUT OF STOCK: No availability for " + type + ".");
        }

        // 3. Validate Guest Info: Simple null/empty check
        if (request.getGuestName() == null || request.getGuestName().trim().isEmpty()) {
            throw new BookingException("INVALID GUEST: Guest name cannot be empty.");
        }

        System.out.println("Validation Passed for: " + request.getGuestName());
    }
}