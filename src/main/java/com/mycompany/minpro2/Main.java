package com.mycompany.minpro2;

import Model.Pendaftaran;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pendaftaran pendaftaran = new Pendaftaran();
        boolean running = true;

        while (running) {
            System.out.println("\n=== SISTEM PENDATAAN PERTANDINGAN PENCAK SILAT ===");
            System.out.println("1. Peserta");
            System.out.println("2. Pertandingan");
            System.out.println("3. Keluar");
            int pilihan = bacaAngka(scanner, "Pilih menu: ");

            switch (pilihan) {
                case 1:
                    menuPeserta(scanner, pendaftaran);
                    break;
                case 2:
                    menuPertandingan(scanner, pendaftaran);
                    break;
                case 3:
                    running = false;
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        scanner.close();
    }

    // ===== SUBMENU PESERTA =====
    private static void menuPeserta(Scanner scanner, Pendaftaran pendaftaran) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- MENU PESERTA ---");
            System.out.println("1. Tambah Peserta Tanding");
            System.out.println("2. Tambah Peserta Seni");
            System.out.println("3. Lihat Semua Peserta");
            System.out.println("4. Ubah Data Peserta");
            System.out.println("5. Hapus Data Peserta");
            System.out.println("6. Kembali ke Menu Utama");
            int pilihan = bacaAngka(scanner, "Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    String nama = bacaTeksTidakKosong(scanner, "Nama: ");
                    String asalPerguruan = bacaTeksTidakKosong(scanner, "Asal Perguruan: ");
                    String kelasBerat = bacaTeksTidakKosong(scanner, "Kelas Berat: ");
                    pendaftaran.tambahPesertaTanding(nama, asalPerguruan, kelasBerat);
                    break;
                }

                case 2: {
                    String nama = bacaTeksTidakKosong(scanner, "Nama: ");
                    String asalPerguruan = bacaTeksTidakKosong(scanner, "Asal Perguruan: ");
                    String jenisSeni = bacaTeksTidakKosong(scanner, "Jenis Seni (Tunggal/Ganda/Regu): ");
                    pendaftaran.tambahPesertaSeni(nama, asalPerguruan, jenisSeni);
                    break;
                }

                case 3:
                    pendaftaran.lihatSemuaPeserta();
                    break;

                case 4: {
                    pendaftaran.lihatSemuaPeserta();
                    int id = bacaIdPesertaValid(scanner, pendaftaran, "Masukkan ID Peserta yang akan diubah: ");
                    String namaBaru = bacaTeksTidakKosong(scanner, "Nama baru: ");
                    String asalPerguruanBaru = bacaTeksTidakKosong(scanner, "Asal Perguruan baru: ");
                    pendaftaran.ubahPeserta(id, namaBaru, asalPerguruanBaru);
                    break;
                }

                case 5: {
                    pendaftaran.lihatSemuaPeserta();
                    int id = bacaIdPesertaValid(scanner, pendaftaran, "Masukkan ID Peserta yang akan dihapus: ");
                    pendaftaran.hapusPeserta(id);
                    break;
                }

                case 6:
                    back = true;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private static void menuPertandingan(Scanner scanner, Pendaftaran pendaftaran) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- MENU PERTANDINGAN ---");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Semua Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Kembali ke Menu Utama");
            int pilihan = bacaAngka(scanner, "Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    pendaftaran.lihatSemuaPeserta();
                    int idPeserta1 = bacaIdPesertaValid(scanner, pendaftaran, "Masukkan ID Peserta 1: ");
                    String kategori = pilihKategoriPertandingan(scanner);
                    int idPeserta2 = bacaIdPeserta2JikaTanding(scanner, pendaftaran, kategori, idPeserta1);
                    String hasil = bacaHasilOpsional(scanner);
                    pendaftaran.tambahPertandingan(idPeserta1, idPeserta2, kategori, hasil);
                    break;
                }

                case 2:
                    pendaftaran.lihatSemuaPertandingan();
                    break;

                case 3: {
                    pendaftaran.lihatSemuaPertandingan();
                    int id = bacaAngka(scanner, "Masukkan ID Pertandingan yang akan diubah: ");
                    pendaftaran.lihatSemuaPeserta();
                    int idPeserta1 = bacaIdPesertaValid(scanner, pendaftaran, "Masukkan ID Peserta 1 baru: ");
                    String kategori = pilihKategoriPertandingan(scanner);
                    int idPeserta2 = bacaIdPeserta2JikaTanding(scanner, pendaftaran, kategori, idPeserta1);
                    String hasil = bacaHasilOpsional(scanner);
                    pendaftaran.ubahPertandingan(id, idPeserta1, idPeserta2, kategori, hasil);
                    break;
                }

                case 4: {
                    pendaftaran.lihatSemuaPertandingan();
                    int id = bacaAngka(scanner, "Masukkan ID Pertandingan yang akan dihapus: ");
                    pendaftaran.hapusPertandingan(id);
                    break;
                }

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private static String pilihKategoriPertandingan(Scanner scanner) {
        while (true) {
            System.out.println("Pilih kategori pertandingan:");
            System.out.println("1. Tanding");
            System.out.println("2. Seni Tunggal");
            System.out.println("3. Seni Ganda");
            int pilihan = bacaAngka(scanner, "Pilih kategori (1-3): ");
            switch (pilihan) {
                case 1: return "Tanding";
                case 2: return "Seni Tunggal";
                case 3: return "Seni Ganda";
                default: System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private static int bacaIdPeserta2JikaTanding(Scanner scanner, Pendaftaran pendaftaran, String kategori, int idPeserta1) {
        if (!kategori.equals("Tanding")) {
            return -1;
        }
        while (true) {
            int idPeserta2 = bacaIdPesertaValid(scanner, pendaftaran, "Masukkan ID Peserta 2 (lawan): ");
            if (idPeserta2 == idPeserta1) {
                System.out.println("Peserta 2 tidak boleh sama dengan Peserta 1, silakan coba lagi.");
                continue;
            }
            return idPeserta2;
        }
    }

    private static String bacaHasilOpsional(Scanner scanner) {
        System.out.print("Hasil (kosongkan jika belum bertanding): ");
        String hasil = scanner.nextLine().trim();
        return hasil.isEmpty() ? "Belum Bertanding" : hasil;
    }

    private static String bacaTeksTidakKosong(Scanner scanner, String label) {
        String input;
        do {
            System.out.print(label);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong, silakan coba lagi.");
            }
        } while (input.isEmpty());
        return input;
    }

    // Validasi: input harus berupa angka, akan terus meminta input sampai valid
    private static int bacaAngka(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka, silakan coba lagi.");
            }
        }
    }

    // Validasi: ID Peserta harus berupa angka DAN harus terdaftar di daftar peserta
    private static int bacaIdPesertaValid(Scanner scanner, Pendaftaran pendaftaran, String label) {
        while (true) {
            int id = bacaAngka(scanner, label);
            if (pendaftaran.cariPesertaById(id) != null) {
                return id;
            }
            System.out.println("ID Peserta tidak ditemukan, silakan coba lagi.");
        }
    }
}
