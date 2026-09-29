# Praktikum Pemrograman Berorientasi Objek
## Modul 4: Array of Objects, Java Collections Framework (List), & Iterator

* **Nama** : Ikrimah
* **NIM** : L0325028

### Tujuan Praktikum
Setelah menyelesaikan modul praktikum ini, mahasiswa diharapkan mampu:
1. Mahasiswa mampu mengelola dan memproses data sekumpulan objek menggunakan struktur Array of Objects.
2. Mahasiswa mampu memahami dan menggunakan hierarki Java Collections Framework, khususnya ArrayList dan LinkedList yang mengimplementasikan antarmuka List.
3. Mahasiswa mampu melakukan iterasi pada koleksi objek menggunakan perulangan for-each dan Iterator.
4. Mahasiswa mampu membangun operasi CRUD (Create, Read, Update, Delete) dasar pada objek di dalam memori.

#### Penjelasan Kode AsetIT

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
            System.out.println("ID: " + idAset + " | Nama: " + namaPerangkat + " | Lokasi: " + lokasi + " | Kondisi: " + statusKondisi);
        }
    }

Kelas `AsetIT` berfungsi sebagai blueprint (model data) untuk menyimpan dan mengelola informasi aset IT.

* **Atribut / Variabel:**
  * `idAset`, `namaPerangkat`, `lokasi`, `statusKondisi`: Menyimpan detail data dari setiap aset.
* **Constructor `AsetIT(...)`:** Menginisialisasi nilai awal seluruh atribut saat objek baru dibuat.
* **Getter `getIdAset()`:** Mengambil/mengembalikan nilai `idAset` untuk digunakan di kelas lain.
* **Method `tampilkanInfoAset()`:** Mencetak ringkasan data aset ke konsol dalam satu baris rapi.

#### Penjelasan Kode MainAset

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

Kelas `MainAset` berfungsi sebagai kelas utama (main program) untuk menjalankan dan menguji alur sistem manajemen aset IT.

* **Instansiasi Objek:** Membuat objek `manajemen` dari kelas `ManajemenAset` untuk mengelola data.
* **Menambahkan Aset:** Membuat 4 objek `AsetIT` baru (`AST-01` sampai `AST-04`) dan memasukkannya ke dalam sistem via `tambahAset()`.
* **Menampilkan Seluruh Aset:** Memanggil `tampilkanSemuaAset()` untuk mencetak semua daftar aset ke konsol.
* **Menghapus Aset:** Menghapus salah satu data aset berdasarkan ID yang valid (`AST-03`) menggunakan method `hapusAset()`.
* **Verifikasi Hasil:** Memanggil kembali `tampilkanSemuaAset()` untuk memastikan aset dengan ID `AST-03` berhasil terhapus dari daftar.
 
#### Penjelasan Kode ManajemenAset

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
                    System.out.println("\n[Sukses] Aset dengan ID '" + idAset + "' telah dihapus."); break;
                }
            }

            if (!ditemukan) {
                System.out.println("\n[Peringatan] Aset dengan ID '" + idAset + "' tidak ditemukan!");
            }
        }
    }

Kelas `ManajemenAset` bertindak sebagai pengelola koleksi data aset IT dengan memanfaatkan Java Collections Framework (`List` & `ArrayList`).

* **Atribut & Constructor:**
  * `daftarAset`: Koleksi berupa `ArrayList` untuk menampung sekumpulan objek `AsetIT`.
  * Constructor menginisialisasi `daftarAset` agar siap digunakan.

* **Method `tambahAset()`:**
  * Menambahkan objek `AsetIT` baru ke dalam daftar menggunakan `.add()`.

* **Method `tampilkanSemuaAset()`:**
  * Mengecek apakah daftar kosong dengan `.isEmpty()`.
  * Menggunakan perulangan **For-Each** untuk mencetak seluruh informasi aset secara berurutan.

* **Method `hapusAset()`:**
  * Menggunakan **Iterator** untuk menelusuri elemen daftar dengan aman tanpa risiko `ConcurrentModificationException`.
  * Mencocokkan `idAset` (menggunakan `.equalsIgnoreCase()` agar tidak sensitif huruf besar/kecil).
  * Jika cocok, hapus elemen dari koleksi menggunakan `iterator.remove()`.
