import java.util.List;

/**
 * Generates operational reports from the Booking History.
 * Demonstrates separation of data storage and reporting logic.
 */
public class ReportingService {

    /**
     * Prints a detailed log of all historical bookings.
     */
    public void generateFullReport(BookingHistory history) {
        List<Reservation> records = history.getAllBookings();

        System.out.println("\n========= ADMIN: GLOBAL BOOKING REPORT =========");
        if (records.isEmpty()) {
            System.out.println("No confirmed bookings found in history.");
        } else {
            for (int i = 0; i < records.size(); i++) {
                System.out.println((i + 1) + ". " + records.get(i));
            }
        }
        System.out.println("Total Confirmed Transactions: " + records.size());
        System.out.println("=================================================");
    }
}