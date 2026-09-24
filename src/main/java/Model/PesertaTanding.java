package Model;

public class PesertaTanding extends Peserta {
    private String kelasBerat;

    public PesertaTanding(int id, String nama, String asalPerguruan, String kelasBerat) {
        super(id, nama, asalPerguruan);
        this.kelasBerat = kelasBerat;
    }

    public String getKelasBerat() {
        return kelasBerat;
    }

    public void setKelasBerat(String kelasBerat) {
        this.kelasBerat = kelasBerat;
    }

    @Override
    public String tampilkanInfo() {
        return "ID: " + getId() + " | Nama: " + getNama() + " | Asal Perguruan: " + getAsalPerguruan()
                + " | Kategori: Tanding | Kelas Berat: " + kelasBerat;
    }
}
