package Soal1;
import java.util.ArrayList;

public class Perusahaan {
    ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    public boolean tambahKaryawan(Karyawan karyawan) {
        for (Karyawan k : daftarKaryawan) { // For each, melakukan looping sesuai dengan banyak data di dalam 'daftarKaryawan'
            if (k.getId().equals(karyawan.getId())) { // Memeriksa apakah String pada 'k.getId()' sama dengan 'karyawan.getId()'
                return false; // ID duplikat
            }
        }
        daftarKaryawan.add(karyawan);
        return true;
    }

    public boolean hapusKaryawan(String id) {
        return daftarKaryawan.removeIf(k -> k.getId().equals(id)); // Menghapus karyawan dengan ID yang sama dengan parameter
    }

    public boolean ubahPosisi(String id, String posisiBaru) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                k.setPosisi(posisiBaru); // Mengubah posisi
                return true;
            }
        }
        return false;
    }

    public boolean ubahGaji(String id, int gajiBaru) {
        if (gajiBaru < 0) return false;
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                k.setGaji(gajiBaru); // Mengubah gaji
                return true;
            }
        }
        return false;
    }

    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada karyawan.");
        } else {
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k.dataKaryawan());
            }
        }
    }

    public void cariKaryawanById(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                System.out.println(k.dataKaryawan());
                return;
            }
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
    }

    public void filterKaryawanByPosisi(String posisi) {
        boolean ditemukan = false;
        // Memeriksa seluruh karyawan dan akan menampilkan dataKaryawan jika posisi karyawan pada 'daftarKaryawan' sama dengan parameter
        for (Karyawan k : daftarKaryawan) {
            if (k.posisi.equalsIgnoreCase(posisi)) {
                System.out.println(k.dataKaryawan());
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada karyawan dengan posisi tersebut.");
        }
    }

}
