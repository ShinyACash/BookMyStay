/**
 * ============================================================
 * MAIN CLASS - HotelBookingApp.java
 * ============================================================
 * * Use Case 1: Application Entry & Welcome Message
 * * This class serves as the entry point for the Hotel Booking
 * System. It initializes the environment and provides the
 * user with versioning and system status information.
 * * Key Features:
 * - JVM Entry point via main()
 * - System branding and versioning display
 * - Linear execution flow demonstration
 * * @author shiny
 * @version 1.0.0
 */
public class HotelBookingApp {

    /**
     * The main method is the static entry point for the Java Virtual Machine.
     * It allows the program to run without instantiating the class first.
     * * @param args Command-line arguments (not utilized in UC1)
     */
    public static void main(String[] args) {
        // Console Output using String Literals
        System.out.println("******************************************");
        System.out.println("   Welcome to the Hotel Booking System    ");
        System.out.println("******************************************");

        System.out.println("Application Name : Hotel Reservation Pro");
        System.out.println("Version          : 1.0.0");
        System.out.println("Status           : System Initialized Successfully");

        System.out.println("******************************************");

    }
}