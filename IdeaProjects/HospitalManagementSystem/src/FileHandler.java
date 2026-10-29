import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// FileHandler.java - Singleton Pattern
public class FileHandler {
    private static FileHandler instance;
    private final String fileName = "hospital_records.txt";

    private FileHandler() {}

    public static synchronized FileHandler getInstance() {
        if (instance == null) {
            instance = new FileHandler();
        }
        return instance;
    }

    public void saveRecord(String data) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName, true))) {
            out.println(data);
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }
}