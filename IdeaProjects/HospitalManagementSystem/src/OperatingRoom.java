public class OperatingRoom {
    private int roomNumber;
    private boolean isOccupied;
    private String currentSurgery;

    public OperatingRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.currentSurgery = "Boş";
    }

    public int getRoomNumber() { return roomNumber; }
    public boolean isOccupied() { return isOccupied; }

    public void scheduleSurgery(String surgeryDetails) {
        this.isOccupied = true;
        this.currentSurgery = surgeryDetails;
    }

    public void freeRoom() {
        this.isOccupied = false;
        this.currentSurgery = "Boş";
    }

    @Override
    public String toString() {
        return "Ameliyathane No: " + roomNumber + " | Durum: " + (isOccupied ? "Dolu (" + currentSurgery + ")" : "Müsait");
    }
}