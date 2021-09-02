
import java.util.Scanner;

public class NotasProva {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int nota = scan.nextInt();

        char notaChar = 'E';

        if (nota > 0 && nota <= 35) {
            notaChar = 'D';
        } else if (nota > 35 && nota <= 60) {
            notaChar = 'C';
        } else if (nota > 60 && nota <= 85) {
            notaChar = 'B';
        } else if (nota > 85 && nota <= 100) {
            notaChar = 'A';
        }

        System.out.println(notaChar);
    }
}
