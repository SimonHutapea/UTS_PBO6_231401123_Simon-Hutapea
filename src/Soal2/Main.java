package Soal2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> daftarKendaraan = new ArrayList<>();
        String lanjut;

        System.out.println("======= Welcome to ParkingChan =======");

        do {
            System.out.print("Enter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = scanner.nextLine();
            Vehicle kendaraan = new Vehicle(jenis);

            boolean metodeValid = false;
            while (!metodeValid) {
                System.out.print("Enter Duration (Manual/Time): ");
                String metode = scanner.nextLine();

                if (metode.equalsIgnoreCase("Manual")) {
                    System.out.print("Enter Duration (in hour): ");
                    int durasi = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    kendaraan.hitungBiayaParkir(durasi);
                    metodeValid = true;
                } else if (metode.equalsIgnoreCase("Time")) {
                    System.out.print("Enter entry time: ");
                    int masuk = scanner.nextInt();
                    System.out.print("Enter exit time: ");
                    int keluar = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    kendaraan.hitungBiayaParkir(masuk, keluar);
                    metodeValid = true;
                } else {
                    System.out.println("Please choose one of the available methods (Manual or Time)!");
                }
            }

            kendaraan.tampilkanHasil();
            daftarKendaraan.add(kendaraan);

            System.out.print("\nAdd another vehicle? (y/n): ");
            lanjut = scanner.nextLine();
        } while (lanjut.equalsIgnoreCase("y"));

        // Ringkasan Akhir
        double totalBiaya = 0;
        for (Vehicle k : daftarKendaraan) {
            totalBiaya += k.getBiayaParkir();
        }

        System.out.println("\n======= FINAL REPORT =======");
        System.out.println("Total Vehicles Final      : " + daftarKendaraan.size());
        System.out.println("Total Parking Fees Final  : Rp" + totalBiaya);
        System.out.println("Thank You.....");

        scanner.close();
    }
}
