import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    @Test
    public void testPatientCreation() {
        Patient p = new Patient("P1", "Ahmet", "Yılmaz", "Grip", 3);
        assertEquals("Ahmet", p.getName());
        assertEquals(3, p.getPriorityLevel());
    }

    @Test
    public void testDoctorCreation() {
        Doctor d = new Doctor("D1", "Mehmet", "Kaya", "Kardiyoloji");
        assertEquals("Kardiyoloji", d.getBranch());
    }

    @Test
    public void testFactoryPatternPatient() {
        AbstractPerson p = PersonFactory.createPerson("PATIENT", "P2", "Ayşe", "Demir", "Kırık", 1);
        assertTrue(p instanceof Patient);
        assertEquals("Kırık", ((Patient) p).getIllness());
    }

    @Test
    public void testFactoryPatternDoctor() {
        AbstractPerson d = PersonFactory.createPerson("DOCTOR", "D2", "Fatma", "Şahin", "Nöroloji", 0);
        assertTrue(d instanceof Doctor);
        assertEquals("Nöroloji", ((Doctor) d).getBranch());
    }

    @Test
    public void testOperatingRoomInitialState() {
        OperatingRoom room = new OperatingRoom(1);
        assertEquals(1, room.getRoomNumber());
        assertFalse(room.isOccupied());
    }

    @Test
    public void testOperatingRoomSchedule() {
        OperatingRoom room = new OperatingRoom(1);
        room.scheduleSurgery("Kalp Ameliyatı");
        assertTrue(room.isOccupied());
    }

    @Test
    public void testOperatingRoomFree() {
        OperatingRoom room = new OperatingRoom(1);
        room.scheduleSurgery("Apandisit");
        room.freeRoom();
        assertFalse(room.isOccupied());
    }

    @Test
    public void testSingletonFileHandler() {
        FileHandler fh1 = FileHandler.getInstance();
        FileHandler fh2 = FileHandler.getInstance();
        assertSame(fh1, fh2, "Singleton nesneler aynı referansa sahip olmalıdır.");
    }
}