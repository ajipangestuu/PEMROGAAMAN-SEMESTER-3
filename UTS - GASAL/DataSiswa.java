import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataSiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input digit terakhir NPM Anda: ");
        int npm = input.nextInt();

        int digit = npm;
        int jumlah;

        if (digit % 2 == 0) {
            jumlah = 6;
        } else {
            jumlah = 5;
        }
        String[] nis = new String[jumlah];
        String[] nama = new String[jumlah];
        String[] nilai = new String[jumlah];

        input.nextLine(); // clear buffer

        for (int i = 0; i < jumlah; i++) {
            System.out.print("\nInput NIS : ");
            nis[i] = input.nextLine();

            System.out.print("Input Nama Siswa : ");
            nama[i] = input.nextLine();

            System.out.print("Input Nilai : ");
            nilai[i] = input.nextLine();
        }

        try {
            FileOutputStream fos = new FileOutputStream("output.txt");

            for (int i = 0; i < jumlah; i++) {
                String line = nis[i] + "_" + nilai[i] + "_" + nama[i] + "\n";
                fos.write(line.getBytes());
            }

            fos.close();
            System.out.println("\nSelesai menulis ke File (output.txt)");

        } catch (IOException e) {
            System.out.println("Error menulis file.");
        }
    }
}
