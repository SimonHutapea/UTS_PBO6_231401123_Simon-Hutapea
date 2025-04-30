package Soal1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan();
        int pilihan;

        // Menampilkan pilihan
        do {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Cari Karyawan berdasarkan ID");
            System.out.println("7. Filter Karyawan berdasarkan Posisi");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Menghilangkan atau Membuang NewLine

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();

                    System.out.println("Pilih Posisi:");
                    System.out.println("1. CEO");
                    System.out.println("2. Direktur");
                    System.out.println("3. Manajer");
                    System.out.println("4. Supervisor");
                    System.out.println("5. Karyawan");
                    System.out.print("Pilihan Anda: ");
                    int pilihPosisi = scanner.nextInt();
                    scanner.nextLine(); // Buang NewLine

                    String posisi = switch (pilihPosisi) {
                        case 1 -> "CEO";
                        case 2 -> "Direktur";
                        case 3 -> "Manajer";
                        case 4 -> "Supervisor";
                        case 5 -> "Karyawan";
                        default -> {
                            System.out.println("Pilihan tidak valid.");
                            yield null;
                        }
                    };

                    if (posisi == null) break;

                    System.out.print("Masukkan Gaji: ");
                    int gaji = scanner.nextInt();

                    if (gaji < 0) {
                        System.out.println("Gaji tidak boleh negatif.");
                        break;
                    }

                    Karyawan karyawanBaru = new Karyawan(id, nama, posisi, gaji);
                    if (perusahaan.tambahKaryawan(karyawanBaru)) {
                        System.out.println("Karyawan berhasil ditambahkan.");
                    } else {
                        System.out.println("Gagal: ID karyawan sudah digunakan.");
                    }
                break;
                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    id = scanner.nextLine();
                    if (perusahaan.hapusKaryawan(id)) {
                        System.out.println("Karyawan berhasil dihapus.");
                    } else {
                        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
                    }
                break;
                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    id = scanner.nextLine();
                    System.out.println("Pilih posisi baru: (1. CEO, 2. Direktur, 3. Manajer, 4. Supervisor, 5. Karyawan)");
                    System.out.print("Masukkan pilihan: ");
                    String posisiBaru = scanner.nextLine();
                    posisiBaru = switch (posisiBaru) {
                        case "1" -> "CEO";
                        case "2" -> "Direktur";
                        case "3" -> "Manajer";
                        case "4" -> "Supervisor";
                        case "5" -> "Karyawan";
                        default -> {
                            System.out.println("Pilihan tidak valid.");
                            yield null;
                        }
                    };
                    if (perusahaan.ubahPosisi(id, posisiBaru)) {
                        System.out.println("Posisi berhasil diubah.");
                    } else {
                        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
                    }
                break;
                case 4:
                    System.out.print("Masukkan ID karyawan: ");
                    id = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    int gajiBaru = scanner.nextInt();
                    if (perusahaan.ubahGaji(id, gajiBaru)) {
                        System.out.println("Gaji berhasil diubah.");
                    } else {
                        System.out.println("Gagal mengubah gaji. ID tidak ditemukan atau gaji tidak valid.");
                    }
                break;
                case 5:
                    perusahaan.tampilkanSemuaKaryawan();
                break;
                case 6:
                    System.out.print("Masukkan ID karyawan yang ingin dicari: ");
                    id = scanner.nextLine();
                    perusahaan.cariKaryawanById(id);
                break;
                case 7:
                    System.out.println("Filter posisi: (1. CEO, 2. Direktur, 3. Manajer, 4. Supervisor, 5. Karyawan)");
                    System.out.print("Masukkan pilihan: ");
                    int opsi = scanner.nextInt();
                    scanner.nextLine(); // Buang NewLine
                    posisi = switch (opsi) {
                        case 1 -> "CEO";
                        case 2 -> "Direktur";
                        case 3 -> "Manajer";
                        case 4 -> "Supervisor";
                        case 5 -> "Karyawan";
                        default -> {
                            System.out.println("Pilihan tidak valid.");
                            yield null;
                        }
                    };
                    if (posisi != null) {
                        perusahaan.filterKaryawanByPosisi(posisi);
                    }
                break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                break;
                default:
                    System.out.println("Pilihan tidak valid.");
                return;
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
