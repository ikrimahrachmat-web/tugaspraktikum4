/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum4;

public class MainAset {
    public static void main(String[] args) {
        // Instansiasi objek ManajemenAset
        ManajemenAset manajemen = new ManajemenAset();

        // Tambahkan minimal 4 data aset IT
        System.out.println("=== 1. MENAMBAHKAN DATA ASET IT ===");
        manajemen.tambahAset(new AsetIT("AST-01", "Server Dell PowerEdge", "Data Center", "Baik"));
        manajemen.tambahAset(new AsetIT("AST-02", "Router Cisco 2911", "Ruang Network", "Baik"));
        manajemen.tambahAset(new AsetIT("AST-03", "Switch TP-Link 24 Port", "Lab Komputer 1", "Rusak"));
        manajemen.tambahAset(new AsetIT("AST-04", "PC Desktop Master", "Ruang Dosen", "Baik"));

        
        System.out.println("\n=== 2. MENAMPILKAN SEMUA ASET ===");
        manajemen.tampilkanSemuaAset();

        
        System.out.println("\n=== 3. MENGHAPUS ASET (VALID ID) ===");
        manajemen.hapusAset("AST-03");

        
        System.out.println("\n=== 4. MENAMPILKAN KEMBALI ASET SETELAH PENGHAPUSAN ===");
        manajemen.tampilkanSemuaAset();
    }
}
