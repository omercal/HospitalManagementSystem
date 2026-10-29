import java.util.ArrayList;
import java.util.List;

// HospitalManager.java
public class HospitalManager {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<OperatingRoom> rooms = new ArrayList<>();
    private FileHandler fileHandler = FileHandler.getInstance();

    public HospitalManager() {
        // Örnek odalar oluşturalım
        rooms.add(new OperatingRoom(1));
        rooms.add(new OperatingRoom(2));
    }

    public void addPatient(Patient p) {
        patients.add(p);
        fileHandler.saveRecord("KAYIT: " + p.getDetails());
        System.out.println("Hasta başarıyla eklendi ve dosyalandı.");
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
        fileHandler.saveRecord("KAYIT: " + d.getDetails());
        System.out.println("Doktor başarıyla eklendi ve dosyalandı.");
    }

    public void createAppointment(String patientId, String doctorId, String date) {
        Patient p = patients.stream().filter(x -> x.getId().equals(patientId)).findFirst().orElse(null);
        Doctor d = doctors.stream().filter(x -> x.getId().equals(doctorId)).findFirst().orElse(null);

        if (p != null && d != null) {
            Appointment app = new Appointment(p, d, date);
            appointments.add(app);
            fileHandler.saveRecord("RANDEVU: " + app.toString());
            System.out.println("Randevu başarıyla oluşturuldu.");
        } else {
            System.out.println("Hasta veya Doktor bulunamadı!");
        }
    }

    public void listAll() {
        System.out.println("\n--- HASTALAR ---");
        patients.forEach(p -> System.out.println(p.getDetails()));
        System.out.println("\n--- DOKTORLAR ---");
        doctors.forEach(d -> System.out.println(d.getDetails()));
        System.out.println("\n--- RANDEVULAR ---");
        appointments.forEach(System.out::println);
        System.out.println("\n--- AMELİYATHANELER ---");
        rooms.forEach(System.out::println);
    }
}