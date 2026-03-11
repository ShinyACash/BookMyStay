/**
 * Application entry point for the Hotel Booking System.
 * Manages static availability and object initialization.
 */
public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("--- Hotel Reservation Pro v1.1.0 ---\n");

        // Polymorphism in action
        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability (Limitation: these are scattered variables)
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 1;

        System.out.println("Current Inventory & Availability:");
        System.out.println("----------------------------------");

        single.displayDetails();
        System.out.println("Stock: " + singleAvailable + " rooms left.\n");

        dbl.displayDetails();
        System.out.println("Stock: " + doubleAvailable + " rooms left.\n");

        suite.displayDetails();
        System.out.println("Stock: " + suiteAvailable + " rooms left.\n");

        System.out.println("----------------------------------");
        System.out.println("System initialized with static state management.");
    }
}