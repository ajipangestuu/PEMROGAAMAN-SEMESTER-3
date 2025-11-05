import java.io.*;
import java.util.*;

public class BacaDataSiswa {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String[] nis = new String[50];
        String[] nama = new String[50];
        int[] nilai = new int[50];
        int n = 0;

        BufferedReader br = new BufferedReader(new FileReader("output.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("_");
            nis[n] = p[0];
            nilai[n] = Integer.parseInt(p[1]);
            nama[n] = p[2];
            n++;
        }
        br.close();

        System.out.println("~DATA SISWA~");
        System.out.println("--------------------------------------------");
        System.out.println("NIS\t\tNama\t\tNilai\tGrade");
        System.out.println("--------------------------------------------");

        int total = 0, max = -1, min = 999;

        for (int i = 0; i < n; i++) {
            total += nilai[i];
            if (nilai[i] > max) max = nilai[i];
            if (nilai[i] < min) min = nilai[i];

            System.out.println(nis[i] + "\t" + nama[i] + "\t" + nilai[i] + "\t" + grade(nilai[i]));
        }

        System.out.println("\nNilai Rata-rata = " + (total / (double)n));
        System.out.println("Nilai Tertinggi = " + max);
        System.out.println("Nilai Terendah  = " + min);

        System.out.print("\nCari Data? (Ya/Tidak): ");
        String jawab = in.nextLine();

        if (jawab.equalsIgnoreCase("Ya")) {
            System.out.print("Input NIS: ");
            String cari = in.nextLine();

            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (nis[i].equals(cari)) idx = i;
            }

            if (idx != -1) {
                System.out.println("\nNama       : " + nama[idx]);
                System.out.println("Nilai      : " + nilai[idx]);
                System.out.println("Keterangan : " + (nilai[idx] > 60 ? "Lulus" : "Tidak Lulus"));
                System.out.println("Peringkat  : " + rank(nilai[idx], nilai, n));
            } else {
                System.out.println("Data tidak ditemukan.");
            }
        }
    }

    static String grade(int x) {
        if (x >= 85) return "A";
        else if (x >= 75) return "B";
        else if (x >= 60) return "C";
        else if (x >= 45) return "D";
        else return "E";
    }

    static int rank(int target, int[] arr, int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > target) count++;
        }
        return count;
    }
}
