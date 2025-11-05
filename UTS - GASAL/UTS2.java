import java.util.*;
public class UTS2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a,b,c,x1,x2;

        System.out.print("Masukkan nilai a: ");
        a = input.nextDouble();
        System.out.print("Masukkan nilai b: ");
        b = input.nextDouble();
        System.out.print("Masukkan nilai c: ");
        c = input.nextDouble();

        double D = b*b - 4 * a * c; //Diskriminan

        if (D >=0 ) {
            x1 = (-b + Math.sqrt(D)) / (2*a);
            x2 = (-b - Math.sqrt(D)) / (2*a);

           System.out.println("Nilai x1 = " + x1);
           System.out.println("Nilai x2 = " + x2);
        } else {
            System.out.println("Diskriminan negatif, tidak ada akar real."); 
        }
    }
}