package Model;

public class PesertaSeni extends Peserta {
    private String jenisSeni;

    public PesertaSeni(int id, String nama, String asalPerguruan, String jenisSeni) {
        super(id, nama, asalPerguruan);
        this.jenisSeni = jenisSeni;
    }

    public String getJenisSeni() {
        return jenisSeni;
    }

    public void setJenisSeni(String jenisSeni) {
        this.jenisSeni = jenisSeni;
    }

    @Override
    public String tampilkanInfo() {
        return "ID: " + getId() + " | Nama: " + getNama() + " | Asal Perguruan: " + getAsalPerguruan()
                + " | Kategori: Seni | Jenis Seni: " + jenisSeni;
    }
}
