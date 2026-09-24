/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManajemenAset {
    private List<AsetIT> daftarAset;

    public ManajemenAset() {
        this.daftarAset = new ArrayList<>();
    }

    // Method menambah aset
    public void tambahAset(AsetIT asetBaru) {
        daftarAset.add(asetBaru);
        System.out.println("Aset " + asetBaru.getIdAset() + " berhasil ditambahkan.");
    }

    // Method menampilkan semua aset menggunakan For-Each
    public void tampilkanSemuaAset() {
        if (daftarAset.isEmpty()) {
            System.out.println("Daftar aset kosong.");
            return;
        }
        System.out.println("\n--- DAFTAR SELURUH ASET IT ---");
        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }

    // Method menghapus aset berdasarkan ID menggunakan Iterator
    public void hapusAset(String idAset) {
        Iterator<AsetIT> iterator = daftarAset.iterator();
        boolean ditemukan = false;

        while (iterator.hasNext()) {
            AsetIT aset = iterator.next();
            if (aset.getIdAset().equalsIgnoreCase(idAset)) {
                iterator.remove();
                ditemukan = true;
                System.out.println("\n[Sukses] Aset dengan ID '" + idAset + "' telah dihapus.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("\n[Peringatan] Aset dengan ID '" + idAset + "' tidak ditemukan!");
        }
    }
}
