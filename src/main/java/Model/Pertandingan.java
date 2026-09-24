package Model;

public class Pertandingan {
    private int id;
    private Peserta peserta1;
    private Peserta peserta2; // bisa null untuk kategori Seni (tampil sendiri, tanpa lawan)
    private String kategori;
    private String hasil;

    public Pertandingan(int id, Peserta peserta1, Peserta peserta2, String kategori, String hasil) {
        this.id = id;
        this.peserta1 = peserta1;
        this.peserta2 = peserta2;
        this.kategori = kategori;
        this.hasil = hasil;
    }

    public int getId() {
        return id;
    }

    public Peserta getPeserta1() {
        return peserta1;
    }

    public void setPeserta1(Peserta peserta1) {
        this.peserta1 = peserta1;
    }

    public Peserta getPeserta2() {
        return peserta2;
    }

    public void setPeserta2(Peserta peserta2) {
        this.peserta2 = peserta2;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String tampilkanInfo() {
        String namaPeserta1 = peserta1.getNama();
        String namaPeserta2 = (peserta2 != null) ? peserta2.getNama() : "-";
        return "ID: " + id + " | Peserta 1: " + namaPeserta1 + " | Peserta 2: " + namaPeserta2
                + " | Kategori: " + kategori + " | Hasil: " + hasil;
    }
}
