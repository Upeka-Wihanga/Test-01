public interface Bookable {

    boolean book(int row, int col, String vehicleSize, int passengerCount);

    boolean cancel(int ticketId);
}
