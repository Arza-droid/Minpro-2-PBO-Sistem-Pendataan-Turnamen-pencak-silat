# Sistem Pendataan Pendaftaran Turnamen Bela Diri Pencak Silat

- **Nama**: Muhammad Arza Dwiarto Anugerah
- **NIM**: 2509116007

## Deskripsi Singkat

Program ini merupakan aplikasi manajemen data **CRUD** (*Create, Read, Update, Delete*) sederhana untuk pendaftaran dan pelaksanaan turnamen Pencak Silat.
Program ini memiliki 2 data utama yaitu:

1. **Data Peserta** yang terbagi menjadi dua kategori:
   - **Peserta Tanding**: bertarung melawan lawan, dikelompokkan berdasarkan kelas berat
   - **Peserta Seni**: menampilkan jurus, dikelompokkan berdasarkan jenis seni (Tunggal/Ganda/Regu)
2. **Data Pertandingan**: mencatat dua peserta untuk kategori pertandingan atau satu peserta untuk kategori Seni, dan hasilnya


## 1. Penerapan Validasi Input

berikut untuk contoh dari salah satu validasi input dalam pemrograman saya

```java
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
```

validasi input ini akan memberikan pemberitahuan ketika kita menginput selain angka pada pilihan menu



## 2. Penerapan Encapsulation

berikut adalah salah satu penerapan encapsulation pada pemrograman saya

```java
public class Peserta {
    private int id;
    private String nama;
    private String asalPerguruan;

    public int getId() { return id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAsalPerguruan() { return asalPerguruan; }
    public void setAsalPerguruan(String asalPerguruan) { this.asalPerguruan = asalPerguruan; }
}
```
Atribut dibuat private, lalu diakses lewat getter dan setter

## 3. Penerapan Inheritance

dalam pemrograman saya ada **1 superclass yaitu `Peserta`** dan **2 subclass yaitu `PesertaTanding` dan `PesertaSeni`**.

```java
public class PesertaTanding extends Peserta {
    private String kelasBerat;

    public PesertaTanding(int id, String nama, String asalPerguruan, String kelasBerat) {
        super(id, nama, asalPerguruan); 
        this.kelasBerat = kelasBerat;
    }

    @Override
    public String tampilkanInfo() {
        return "ID: " + getId() + " | Nama: " + getNama() + " | Asal Perguruan: " + getAsalPerguruan()
                + " | Kategori: Tanding | Kelas Berat: " + kelasBerat;
    }
}
```


## 4. Alur Program
Pada menu awal kita dapat memilih menu peserta dan pertandingan  
Berikut adalah alur program untuk proses CRUD pada menu peserta dan juga pertandingan
### Peserta

| Fitur | Alur |
|---|---|
| **Create** | Input nama, asal perguruan, kelas berat / jenis seni → `tambahPesertaTanding()` / `tambahPesertaSeni()` → objek dibuat dengan ID dari `idPesertaCounter` → masuk `daftarPeserta` → counter naik |
| **Read** | `lihatSemuaPeserta()` → jika kosong tampil pesan, jika tidak tiap objek memanggil `tampilkanInfo()` |
| **Update** | Tampil daftar → input ID (harus valid) → input nama dan asal perguruan baru → `ubahPeserta()` → cari by ID → `setNama()` dan `setAsalPerguruan()` |
| **Delete** | Tampil daftar → input ID (harus valid) → `hapusPeserta()` → cari by ID → `remove()` dari `daftarPeserta` |

### Pertandingan

| Fitur | Alur |
|---|---|
| **Create** | Tampil peserta → input ID Peserta 1 → pilih kategori → jika Tanding input ID Peserta 2, jika Seni otomatis `-1` → input hasil (opsional) → `tambahPertandingan()` → cari peserta → objek dibuat → masuk `daftarPertandingan` → counter naik |
| **Read** | `lihatSemuaPertandingan()` → jika kosong tampil pesan, jika tidak tampilkan tiap data (Peserta 2 tampil "-" jika kosong) |
| **Update** | Tampil pertandingan → input ID Pertandingan → input ulang peserta, kategori, hasil → `ubahPertandingan()` → cari data dan peserta → setter memperbarui data |
| **Delete** | Tampil pertandingan → input ID → `hapusPertandingan()` → cari by ID → `remove()` dari `daftarPertandingan` |  
  
Untuk mengakhiri atau keluar dari program kita perlu kembali ke menu utama dan memilih pilihan keluar
