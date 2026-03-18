/**
 * Represents a guest's intent to book a room.
 * This is a data carrier for the request queue.
 */
import java.io.Serializable;
public class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }

    @Override
    public String toString() {
        return "Request [Guest: " + guestName + " | Room: " + roomType + "]";
    }
}
