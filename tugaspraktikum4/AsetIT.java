/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum4;

/**
 *
 * @author admin
 */
public class AsetIT {
    String idAset;
    String namaPerangkat;
    String lokasi;
    String statusKondisi;
    
    // Tambahkan constructor ini jika belum ada:
    public AsetIT(String idAset, String namaPerangkat, String lokasi, String statusKondisi) {
        this.idAset = idAset;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.statusKondisi = statusKondisi;
    }

    public String getIdAset() {
        return idAset;
    }

    public void tampilkanInfoAset() {
        System.out.println("ID: " + idAset + " | Nama: " + namaPerangkat + 
                           " | Lokasi: " + lokasi + " | Kondisi: " + statusKondisi);
    }
}
