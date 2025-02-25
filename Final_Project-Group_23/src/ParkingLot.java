import java.util.ArrayList;

public class ParkingLot implements Bookable {
    private String[][] seats;
    private double[] rowPrices;
    private ArrayList<Ticket> tickets;
    private int ticketCounter;

    public ParkingLot(int rows, int cols) {
        seats = new String[rows][cols];
        rowPrices = new double[]{1000, 1000, 750, 750, 500};
        tickets = new ArrayList<>();
        ticketCounter = 1;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "0";
            }
        }
    }

    public void displaySeatsWithPrices() {
        System.out.println("Seating Plan (0 = available, X = booked):");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + " (Rs : " + rowPrices[i] + "): ");
            for (String seat : seats[i]) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean book(int row, int col, String vehicleSize, int passengerCount) {
        if (!isValidBooking(row, col, vehicleSize)) {
            System.out.println("Booking failed. Slot might be occupied or incompatible.");
            return false;
        }

        seats[row][col] = "X";
        double totalPrice = rowPrices[row] * passengerCount;
        Ticket newTicket = new Ticket(ticketCounter++, row, col, rowPrices[row], passengerCount, totalPrice);
        tickets.add(newTicket);


        System.out.println("Booking successful. Ticket ID: " + newTicket.getId());
        System.out.println("Ticket Details: " + newTicket);

        return true;
    }

    @Override
    public boolean cancel(int ticketId) {
        Ticket ticket = getTicket(ticketId);
        if (ticket != null) {
            seats[ticket.getRow()][ticket.getCol()] = "0";
            tickets.remove(ticket);
            System.out.println("Ticket canceled successfully. Details:");
            System.out.println(ticket);
            return true;
        } else {
            System.out.println("Invalid ticket ID.");
            return false;
        }
    }

    public void checkout() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Checkout Details:");


        Ticket lastTicket = tickets.get(tickets.size() - 1);
        System.out.println(lastTicket);

        double grandTotal = lastTicket.getTotalPrice();
        System.out.println("Grand Total Price: Rs : " + grandTotal);
    }


    private boolean isValidBooking(int row, int col, String vehicleSize) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[row].length) {
            return false;
        }
        if (!seats[row][col].equals("0")) {
            return false;
        }

        return switch (vehicleSize.toLowerCase()) {
            case "small" -> row < 2;
            case "medium" -> row >= 2 && row < 4;
            case "large" -> row >= 4;
            default -> false;
        };
    }

    private Ticket getTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }
}
