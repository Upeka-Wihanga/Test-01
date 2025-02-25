import java.util.Scanner;
import java.util.InputMismatchException;

public class DriveInTheatreParkingSystem {
    private ParkingLot parkingLot;

    public DriveInTheatreParkingSystem(int rows, int cols) {
        parkingLot = new ParkingLot(rows, cols);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--------Welcome to the DriveInTheatreParkingSystem----------");
            System.out.println("01). Buy or Cancel Ticket");
            System.out.println("02). View Seat System (Including Prices)");
            System.out.println("03). Exit");
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric choice.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> buyOrCancelMenu(scanner);
                case 2 -> parkingLot.displaySeatsWithPrices();
                case 3 -> {
                    System.out.println("Thank you for using the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");

            }
        }
    }

    private void buyOrCancelMenu(Scanner scanner) {
        System.out.println("1. Buy a Ticket");
        System.out.println("2. Cancel a Ticket");
        System.out.print("Enter your choice: ");
        int choice;

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric choice.");
            scanner.nextLine();
            return;
        }

        if (choice == 1) {
            boolean moreBooking = true;
            while (moreBooking) {
                System.out.println("""
                    Row Categorization:
                    - Rows 1-2: Small vehicles (Ex :- Car)
                    - Rows 3-4: Medium vehicles (Ex :- Van)
                    - Row 5: Large vehicles (Ex :- Truck)
                """);
                parkingLot.displaySeatsWithPrices();

                int row = -1, col = -1;
                while (true) {
                    try {
                        System.out.print("Enter row number: ");
                        row = scanner.nextInt();
                        System.out.print("Enter column number: ");
                        col = scanner.nextInt();
                        if (row < 1 || row > 5 || col < 1 || col > 5) {
                            System.out.println("Invalid row or column. Please enter valid values (row: 1-5, col: 1-5).");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter numeric values for row and column.");
                        scanner.nextLine();
                    }
                }

                String vehicleSize;
                while (true) {
                    System.out.print("Enter vehicle size (Small, Medium, Large): ");
                    vehicleSize = scanner.next();
                    if (vehicleSize.equalsIgnoreCase("Small") ||
                            vehicleSize.equalsIgnoreCase("Medium") ||
                            vehicleSize.equalsIgnoreCase("Large")) {
                        break;
                    } else {
                        System.out.println("Invalid vehicle size. Please enter Small, Medium, or Large.");
                    }
                }

                int passengerCount;
                while (true) {
                    try {
                        System.out.print("Enter number of passengers: ");
                        passengerCount = scanner.nextInt();
                        if (passengerCount > 0) {
                            break;
                        } else {
                            System.out.println("Passenger count must be a positive number.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a numeric value for passengers.");
                        scanner.nextLine();
                    }
                }

                if (parkingLot.book(row - 1, col - 1, vehicleSize, passengerCount)) {
                    System.out.println("Booking successful!");
                }

                while (true) {
                    System.out.print("Do you want to book more tickets? (yes to book more, no to checkout): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        moreBooking = true;
                        break;
                    } else if (response.equalsIgnoreCase("no")) {
                        moreBooking = false;
                        break;
                    } else {
                        System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                    }
                }
            }
            parkingLot.checkout();
        } else if (choice == 2) {
            System.out.print("Enter ticket ID to cancel: ");
            int ticketId;

            try {
                ticketId = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric ticket ID.");
                scanner.nextLine();
                return;
            }

            parkingLot.cancel(ticketId);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        DriveInTheatreParkingSystem system = new DriveInTheatreParkingSystem(5, 5);
        system.menu();
        //is this working properly ???
    }
}
