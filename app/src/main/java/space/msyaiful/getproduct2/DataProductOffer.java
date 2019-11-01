package space.msyaiful.getproduct2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataProductOffer {

    @SerializedName("nama_produk")
    @Expose
    private String nama_produk;

    @SerializedName("gambar")
    @Expose
    private String gambar;

    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    @SerializedName("harga")
    @Expose
    private String harga;

//    @SerializedName("dollar")
//    @Expose
//    private String dollar;

    @SerializedName("nama_negara")
    @Expose
    private String nama_negara;

    public String getNama_produk() {return nama_produk;}
    public void setNama_produk(String nama_produk) {this.nama_produk = nama_produk;}

    public  String getGambar() {return gambar;}
    public void setGambar(String gambar) {this.gambar = gambar;}

    public String getDeskripsi() {return deskripsi;}
    public void setDeskripsi(String deskripsi) {this.deskripsi = deskripsi;}

    public String getHarga() {return harga;}
    public void setHarga(String harga) {this.harga = harga;}

//    public String getDollar() {return dollar;}
//    public void setDollar(String dollar) {this.dollar = dollar;}

    public String getNama_negara() {return  nama_negara;}
    public void setNama_negara(String nama_negara) {this.nama_negara = nama_negara;}
}
