public class Doctor extends AbstractPerson {
    private String branch;

    public Doctor(String id, String name, String surname, String branch) {
        super(id, name, surname);
        this.branch = branch;
    }

    public String getBranch() { return branch; }

    @Override
    public String getDetails() {
        return "Doktor [ID: " + getId() + ", Ad Soyad: " + getName() + " " + getSurname() +
                ", Uzmanlık: " + branch + "]";
    }
}