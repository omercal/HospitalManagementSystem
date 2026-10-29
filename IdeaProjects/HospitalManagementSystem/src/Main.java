import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== AKILLI HASTANE PLANLAMA SİSTEMİ ===");
            System.out.println("1. Hasta Ekle");
            System.out.println("2. Doktor Ekle");
            System.out.println("3. Randevu Oluştur");
            System.out.println("4. Sistem Durumunu Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    System.out.print("ID: "); String pId = scanner.nextLine();
                    System.out.print("Ad: "); String pName = scanner.nextLine();
                    System.out.print("Soyad: "); String pSurname = scanner.nextLine();
                    System.out.print("Rahatsızlık: "); String illness = scanner.nextLine();
                    System.out.print("Öncelik Seviyesi (1-Acil, 5-Normal): "); int priority = scanner.nextInt();
                    Patient p = (Patient) PersonFactory.createPerson("PATIENT", pId, pName, pSurname, illness, priority);
                    manager.addPatient(p);
                    break;
                case 2:
                    System.out.print("ID: "); String dId = scanner.nextLine();
                    System.out.print("Ad: "); String dName = scanner.nextLine();
                    System.out.print("Soyad: "); String dSurname = scanner.nextLine();
                    System.out.print("Uzmanlık Alanı: "); String branch = scanner.nextLine();
                    Doctor d = (Doctor) PersonFactory.createPerson("DOCTOR", dId, dName, dSurname, branch, 0);
                    manager.addDoctor(d);
                    break;
                case 3:
                    System.out.print("Hasta ID: "); String rpId = scanner.nextLine();
                    System.out.print("Doktor ID: "); String rdId = scanner.nextLine();
                    System.out.print("Tarih (GG/AA/YYYY): "); String date = scanner.nextLine();
                    manager.createAppointment(rpId, rdId, date);
                    break;
                case 4:
                    manager.listAll();
                    break;
                case 0:
                    System.out.println("Sistemden çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (choice != 0);
        scanner.close();
    }
}