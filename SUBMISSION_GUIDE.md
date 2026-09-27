# Panduan Lengkap Submission Praktikum ASD
**Repository:** `dsa-5026251161`  
**Remote GitHub:** `https://github.com/henntristan/dsa-5026251161`  
**Tautan Pengumpulan:** `intip.in/GithubASD2026`

---

## 1. Struktur Folder Standar Praktikum
Semua tugas praktikum (Pre-Lab dan Unguided) semester ini dikerjakan di dalam folder **`dsa-5026251161`** dengan struktur pohon sebagai berikut:

```text
dsa-5026251161/
│
├── .vscode/
│   ├── launch.json
│   └── settings.json
│
├── src/
│   ├── App.java
│   │
│   ├── lw01/
│   │   ├── prelab/       <-- Pre-Lab 01 (Campus Printing)
│   │   │   ├── Main.java
│   │   │   ├── jobs.txt
│   │   │   └── ...
│   │   └── unguided/     <-- Unguided 01 (Car Wash)
│   │       ├── Main.java
│   │       ├── washes.txt
│   │       └── ...
│   │
│   ├── lw02/
│   │   ├── prelab/       <-- Pre-Lab 02 (Bank Transactions)
│   │   │   ├── Main.java
│   │   │   └── transactions.txt
│   │   └── unguided/     <-- Unguided 02 (Saat praktikum nanti)
│   │
│   └── lw03/             <-- Modul berikutnya
│
├── jobs.txt
├── washes.txt
├── transactions.txt
└── .gitignore
```

> **Aturan Penting Package Java:**
> Setiap file `.java` di dalam subfolder `src/` harus menyertakan deklarasi package di baris pertama:
> - Di dalam `src/lw02/prelab/` $\rightarrow$ `package lw02.prelab;`
> - Di dalam `src/lw01/unguided/` $\rightarrow$ `package lw01.unguided;`

---

## 2. Cara Menjalankan & Menguji Program

### Opsi A: Lewat VS Code (Run / Debug)
1. Buka folder `dsa-5026251161` di Visual Studio Code (`File > Open Folder...`).
2. Buka file `src/lw02/prelab/Main.java`.
3. Klik tombol **Run** di atas method `public static void main(String[] args)` atau tekan `F5` / pilih konfigurasi **"Run Main (Pre-Lab 2)"** di tab *Run & Debug*.

### Opsi B: Lewat Terminal / PowerShell
Buka terminal di root repository `dsa-5026251161`:
```powershell
# 1. Masuk ke direktori repository
cd "c:\Kuliah Henry\Semester 3\ASD B\dsa-5026251161"

# 2. Kompilasi program Java
javac -d bin src/lw02/prelab/*.java

# 3. Jalankan program dengan classpath ke bin dan folder prelab
java -cp "bin;src/lw02/prelab" lw02.prelab.Main
```

---

## 3. Langkah Submission ke GitHub (Commit & Push)

### Opsi 1: Lewat Terminal (Paling Cepat & Presisi)

Jalankan perintah berikut di root folder `dsa-5026251161`:

1. **Cek status perubahan file:**
   ```bash
   git status
   ```

2. **Tambahkan file yang telah dikerjakan ke staging:**
   ```bash
   git add src/lw02/prelab/ transactions.txt .vscode/launch.json
   ```
   *(Atau `git add .` jika ingin menyertakan seluruh perubahan baru)*

3. **Commit dengan format pesan sesuai instruksi modul:**
   Untuk Pre-Lab 02:
   ```bash
   git commit -m "Labwork 02 - Prelab"
   ```
   *(Untuk tugas berikutnya sesuaikan, misalnya: `"Labwork 02 - Unguided"`, `"Labwork 03 - Prelab"`, dst.)*

4. **Kirim perubahan ke remote GitHub:**
   ```bash
   git push origin main
   ```

5. **Pastikan working tree sudah bersih:**
   ```bash
   git status
   ```
   Output harus menampilkan: `nothing to commit, working tree clean`.

---

### Opsi 2: Lewat GUI VS Code (Source Control)

1. Klik ikon **Source Control** di Activity Bar sebelah kiri (atau tekan `Ctrl + Shift + G`).
2. Pada bagian **Changes**, klik tanda `+` (*Stage All Changes*).
3. Masukkan commit message pada kotak teks di bagian atas:
   ```text
   Labwork 02 - Prelab
   ```
4. Klik tombol **Commit** (tanda centang).
5. Klik tombol **Sync Changes** atau menu `... > Push` untuk mengirim ke GitHub.

---

## 4. Verifikasi dan Pengumpulan Link

1. Buka browser dan kunjungi repository Anda:
   **`https://github.com/henntristan/dsa-5026251161`**
2. Pastikan folder `src/lw02/prelab/` sudah muncul dengan file `Main.java` dan `transactions.txt`.
3. Cek riwayat commit terbaru menunjukkan: `"Labwork 02 - Prelab"`.
4. Jika diminta pengumpulan link repo ke form asisten praktikum, salin link URL:
   `https://github.com/henntristan/dsa-5026251161`
   dan kirimkan ke:
   `intip.in/GithubASD2026`
