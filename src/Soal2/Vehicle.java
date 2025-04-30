package Soal2;

public class Vehicle {
    String jenis;
    int lama, biaya;

    Vehicle (String jenis) {
        this.jenis = jenis;
    }

    // Overloading: durasi manual
    public void hitungBiayaParkir(int durasi) {
        this.lama = durasi;
        this.biaya = hitungTarif() * durasi;
        if (durasi > 5) {
            this.biaya *= 0.9; // diskon 10%
        }
    }

    // Overloading: berdasarkan jam masuk dan keluar
    public void hitungBiayaParkir(int jamMasuk, int jamKeluar) {
        int durasi = jamKeluar - jamMasuk;
        if (durasi < 0) { // jika hasil minus, artinya telah parkir sampai hari berikutnya
            durasi += 24;
        }
        hitungBiayaParkir(durasi);
    }

    // Menetapkan harga berdasarkan jenis kendaraan
    private int hitungTarif() {
        switch (jenis.toLowerCase()) {
            case "motor": return 1000;
            case "mobil": return 5000;
            case "truk": return 9000;
            default: return 0;
        }
    }

    public void tampilkanHasil() {
        System.out.println("---- PARKING SUMMARY ----");
        System.out.println("Vehicle Type    : " + jenis);
        System.out.println("Parking Time    : " + lama + " hour(s)");
        System.out.println("Total Fee       : Rp" + biaya);
    }

    public double getBiayaParkir() {
        return biaya;
    }
}
