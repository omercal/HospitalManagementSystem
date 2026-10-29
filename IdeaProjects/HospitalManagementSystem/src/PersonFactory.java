// PersonFactory.java - Factory Pattern
public class PersonFactory {
    public static AbstractPerson createPerson(String type, String id, String name, String surname, String extra1, int extra2) {
        if (type.equalsIgnoreCase("PATIENT")) {
            return new Patient(id, name, surname, extra1, extra2);
        } else if (type.equalsIgnoreCase("DOCTOR")) {
            return new Doctor(id, name, surname, extra1);
        }
        throw new IllegalArgumentException("Geçersiz kişi tipi!");
    }
}