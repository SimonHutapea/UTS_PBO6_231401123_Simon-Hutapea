package Soal1;

public class Karyawan {
    int gaji;
    String id, nama, posisi;

    // Constructor
    Karyawan (String id, String nama, String posisi, int gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    // Untuk mengambil ID
    public String getId() {
        return id;
    }

    // Untuk mengubah nilai posisi
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    // Mengubah nilai gaji
    public void setGaji(int gaji) {
        if (gaji >= 0) {
            this.gaji = gaji;
        }
    }

    // Menampung data karyawan
    public String dataKaryawan() {
        return "ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi + ", Gaji: Rp" + gaji;
    }
}
