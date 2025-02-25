public class Ticket {
    private int id;
    private int row;
    private int col;
    private double pricePerPassenger;
    private int passengerCount;
    private double totalPrice;

    public Ticket(int id, int row, int col, double pricePerPassenger, int passengerCount, double totalPrice) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.pricePerPassenger = pricePerPassenger;
        this.passengerCount = passengerCount;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id +
                ", Row: " + (row + 1) +
                ", Column: " + (col + 1) +
                ", Price Per Passenger: Rs : " + pricePerPassenger +
                ", Passenger Count: " + passengerCount +
                ", Total Price: Rs : " + totalPrice;
    }
}
