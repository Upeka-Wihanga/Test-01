public class Vehicle extends AbstractEntity {
    private String licensePlate;
    private String size;
    private int passengers;

    public Vehicle(int id, String licensePlate, String size, int passengers) {
        super(id);
        this.licensePlate = licensePlate;
        this.size = size;
        this.passengers = passengers;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getSize() {
        return size;
    }

    public int getPassengers() {
        return passengers;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle ID: " + getId() + ", License Plate: " + licensePlate +
                ", Size: " + size + ", Passengers: " + passengers);
    }
}
