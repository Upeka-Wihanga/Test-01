public class ParkingSlot extends AbstractEntity {
    private boolean isOccupied;
    private String vehicleType;
    private String slotSize;

    public ParkingSlot(int id, String slotSize) {
        super(id);
        this.isOccupied = false;
        this.slotSize = slotSize;
        this.vehicleType = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public String getSlotSize() {
        return slotSize;
    }

    public void assignVehicle(String vehicleType) {
        this.vehicleType = vehicleType;
        this.isOccupied = true;
    }

    public void releaseVehicle() {
        this.vehicleType = null;
        this.isOccupied = false;
    }

    @Override
    public void displayDetails() {
        System.out.println("Slot ID: " + getId() + ", Size: " + slotSize + ", Occupied: " + isOccupied);
    }
}
