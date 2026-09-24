package Model;

import java.util.ArrayList;

public class Pendaftaran {
    private ArrayList<Peserta> daftarPeserta;
    private ArrayList<Pertandingan> daftarPertandingan;
    private int idPesertaCounter;
    private int idPertandinganCounter;

    public Pendaftaran() {
        daftarPeserta = new ArrayList<>();
        daftarPertandingan = new ArrayList<>();
        idPesertaCounter = 1;
        idPertandinganCounter = 1;
        isiDataAwal();
    }

    // Dummy data awal supaya fitur "Lihat Semua Data" langsung ada isinya
    // tanpa harus input dari awal.
    private void isiDataAwal() {
        Peserta p1 = new PesertaTanding(idPesertaCounter++, "Budi Santoso", "Perguruan Merpati Putih", "Kelas A (45-50 kg)");
        Peserta p2 = new PesertaTanding(idPesertaCounter++, "Andi Wijaya", "Perguruan Tapak Suci", "Kelas A (45-50 kg)");
        Peserta p3 = new PesertaSeni(idPesertaCounter++, "Siti Aminah", "Perguruan Cimande", "Tunggal");

        daftarPeserta.add(p1);
        daftarPeserta.add(p2);
        daftarPeserta.add(p3);

        Pertandingan pt1 = new Pertandingan(idPertandinganCounter++, p1, p2, "Tanding", "Belum Bertanding");
        daftarPertandingan.add(pt1);
    }

    // Dipakai Main untuk validasi ID Peserta sebelum data dipakai/diubah
    public Peserta cariPesertaById(int id) {
        for (Peserta peserta : daftarPeserta) {
            if (peserta.getId() == id) {
                return peserta;
            }
        }
        return null;
    }

    private Pertandingan cariPertandinganById(int id) {
        for (Pertandingan pertandingan : daftarPertandingan) {
            if (pertandingan.getId() == id) {
                return pertandingan;
            }
        }
        return null;
    }

    // ===== CRUD PESERTA =====

    public void tambahPesertaTanding(String nama, String asalPerguruan, String kelasBerat) {
        Peserta peserta = new PesertaTanding(idPesertaCounter, nama, asalPerguruan, kelasBerat);
        daftarPeserta.add(peserta);
        idPesertaCounter++;
        System.out.println("Peserta Tanding berhasil ditambahkan.");
    }

    public void tambahPesertaSeni(String nama, String asalPerguruan, String jenisSeni) {
        Peserta peserta = new PesertaSeni(idPesertaCounter, nama, asalPerguruan, jenisSeni);
        daftarPeserta.add(peserta);
        idPesertaCounter++;
        System.out.println("Peserta Seni berhasil ditambahkan.");
    }

    public void lihatSemuaPeserta() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada data peserta.");
            return;
        }
        System.out.println("=== DAFTAR PESERTA ===");
        // Perulangan ini bersifat polymorphic: tampilkanInfo() otomatis
        // memanggil versi PesertaTanding atau PesertaSeni sesuai tipe objek aslinya.
        for (Peserta peserta : daftarPeserta) {
            System.out.println(peserta.tampilkanInfo());
        }
    }

    public boolean ubahPeserta(int id, String namaBaru, String asalPerguruanBaru) {
        Peserta peserta = cariPesertaById(id);
        if (peserta == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
            return false;
        }
        peserta.setNama(namaBaru);
        peserta.setAsalPerguruan(asalPerguruanBaru);
        System.out.println("Data peserta berhasil diubah.");
        return true;
    }

    public boolean hapusPeserta(int id) {
        Peserta peserta = cariPesertaById(id);
        if (peserta == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
            return false;
        }
        daftarPeserta.remove(peserta);
        System.out.println("Data peserta berhasil dihapus.");
        return true;
    }

    // ===== CRUD PERTANDINGAN =====
    // idPeserta2 diisi -1 kalau kategori Seni (tampil sendiri, tanpa lawan)

    public boolean tambahPertandingan(int idPeserta1, int idPeserta2, String kategori, String hasil) {
        Peserta peserta1 = cariPesertaById(idPeserta1);
        if (peserta1 == null) {
            System.out.println("Peserta 1 dengan ID tersebut tidak ditemukan.");
            return false;
        }
        Peserta peserta2 = null;
        if (idPeserta2 != -1) {
            peserta2 = cariPesertaById(idPeserta2);
            if (peserta2 == null) {
                System.out.println("Peserta 2 dengan ID tersebut tidak ditemukan.");
                return false;
            }
        }
        Pertandingan pertandingan = new Pertandingan(idPertandinganCounter, peserta1, peserta2, kategori, hasil);
        daftarPertandingan.add(pertandingan);
        idPertandinganCounter++;
        System.out.println("Data pertandingan berhasil ditambahkan.");
        return true;
    }

    public void lihatSemuaPertandingan() {
        if (daftarPertandingan.isEmpty()) {
            System.out.println("Belum ada data pertandingan.");
            return;
        }
        System.out.println("=== DAFTAR PERTANDINGAN ===");
        for (Pertandingan pertandingan : daftarPertandingan) {
            System.out.println(pertandingan.tampilkanInfo());
        }
    }

    public boolean ubahPertandingan(int id, int idPeserta1, int idPeserta2, String kategori, String hasil) {
        Pertandingan pertandingan = cariPertandinganById(id);
        if (pertandingan == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
            return false;
        }
        Peserta peserta1 = cariPesertaById(idPeserta1);
        if (peserta1 == null) {
            System.out.println("Peserta 1 dengan ID tersebut tidak ditemukan.");
            return false;
        }
        Peserta peserta2 = null;
        if (idPeserta2 != -1) {
            peserta2 = cariPesertaById(idPeserta2);
            if (peserta2 == null) {
                System.out.println("Peserta 2 dengan ID tersebut tidak ditemukan.");
                return false;
            }
        }
        pertandingan.setPeserta1(peserta1);
        pertandingan.setPeserta2(peserta2);
        pertandingan.setKategori(kategori);
        pertandingan.setHasil(hasil);
        System.out.println("Data pertandingan berhasil diubah.");
        return true;
    }

    public boolean hapusPertandingan(int id) {
        Pertandingan pertandingan = cariPertandinganById(id);
        if (pertandingan == null) {
            System.out.println("Data dengan ID tersebut tidak ditemukan.");
            return false;
        }
        daftarPertandingan.remove(pertandingan);
        System.out.println("Data pertandingan berhasil dihapus.");
        return true;
    }
}
