import java.util.*;
public class UTS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Array 2 dimensii //
        String [][] event = new String[30][4]; // kolom 30 baris 4 //

        // VariabbeL //
        int n = 0;
        int menu;

        char lagi = 'y'; // hanya y jika ingin mengulang //

        char masuk;
        
        // Program Berjalan //1
        
       do { 
        System.out.println("Menu : ");
        System.out.println("[1] Input Data");
        System.out.println("[2] Transaksi");

        // Konfirmasi user //
        System.out.println("Masuk Ke Menu [y/t] ? ");
        masuk = input.next().charAt(0);
        input.nextLine();

        if (masuk != 'y') {
            break;
        }

        // Masuk Ke program
        System.out.print("Pilih Menu : ");
        menu = input.nextInt();
        input.nextLine();

        switch (menu) {
            case 1:
                do {
                System.out.println("          - Menambahkan Data -             ");
                System.out.print("Input Kode Event      : ");
                event[n][0] = input.nextLine();
                System.out.print("Input Nama Event      : ");
                event[n][1] = input.nextLine();
                System.out.print("Input Harga Tiket     : ");
                event[n][2] = input.nextLine();
                System.out.print("Input Stok Tiket      : ");
                event[n][3] = input.nextLine();
                n++;

                System.out.print("Input lagi [y/t] ? ");
                lagi = input.next().charAt(0);
                input.nextLine();
            } while(lagi == 'y'); 

                System.out.println("\n--- Data Event ---");
                System.out.println("Kode\tNama Event\tHarga\tStock");
                for (int i = 0; i < n; i++) {
                        System.out.println(event[i][0] + "\t" + event[i][1] + "\t" + event[i][2] + "\t" + event[i][3]);
                    }
                    System.out.println();
                    break;
            case 2:
                // deklarasi pentotalan //
                int total = 0;
                    do {
                        System.out.print("Input Kode Event : ");
                        String cari = input.nextLine();
                        int index = -1;

                        for (int i = 0; i < n; i++) {
                            if (event[i][0].equals(cari)) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            System.out.println("Kode tidak ditemukan.");
                        } else {
                            System.out.println("Nama Event  : " + event[index][1]);
                            System.out.println("Harga Tiket : " + event[index][2]);
                            System.out.println("Stock Tiket : " + event[index][3]);

                            System.out.print("Jumlah tiket dibeli : ");
                            int beli = input.nextInt();
                            input.nextLine();

                            int harga = Integer.parseInt(event[index][2]);
                            int stock = Integer.parseInt(event[index][3]);

                            if (beli <= stock) {
                                int subtotal = harga * beli;
                                total += subtotal;
                                event[index][3] = Integer.toString(stock - beli);
                                System.out.println("Subtotal = " + subtotal);
                            } else {
                                System.out.println("Stock tidak cukup.");
                            }
                        }

                        System.out.print("Tambah transaksi? (y/t): ");
                        lagi = input.next().charAt(0);
                        input.nextLine();
                    } while (lagi == 'y');

                    System.out.println("Total = " + total);
                    System.out.println("--- Terimakasih ---");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
            System.out.print("Kembali ke program? (y/t): ");
            lagi = input.next().charAt(0);
            input.nextLine();
   
       } while (lagi == 'y');

        input.close();


    }
}
