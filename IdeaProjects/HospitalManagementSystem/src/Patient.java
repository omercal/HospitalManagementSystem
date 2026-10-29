public class Patient extends AbstractPerson {
    private String illness;
    private int priorityLevel; // 1 (Acil) ile 5 (Normal) arası

    public Patient(String id, String name, String surname, String illness, int priorityLevel) {
        super(id, name, surname);
        this.illness = illness;
        this.priorityLevel = priorityLevel;
    }

    public String getIllness() { return illness; }
    public int getPriorityLevel() { return priorityLevel; }

    @Override
    public String getDetails() {
        return "Hasta [ID: " + getId() + ", Ad Soyad: " + getName() + " " + getSurname() +
                ", Rahatsızlık: " + illness + ", Öncelik Seviyesi: " + priorityLevel + "]";
    }
}