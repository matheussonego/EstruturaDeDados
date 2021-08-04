
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class JogandoCartasFora {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = 0;

        List<Integer> inteiros;
        List<Integer> removidos;

        StringBuilder sb;

        n = scan.nextInt();
        do {

            inteiros = new ArrayList<>();
            removidos = new ArrayList<>();

            fillArray(inteiros, n);

            while (inteiros.size() != 1) {
                removidos.add(inteiros.remove(0));
                inteiros.add(inteiros.get(0));
                inteiros.remove(0);
            }
            int remaining = inteiros.get(0);

            sb = new StringBuilder("Discarded cards: ");
            sb.append(removidos.remove(0));

            for (int inteiro: removidos) {
                sb.append(", " + inteiro);
            }

            System.out.println(sb.toString());
            System.out.println("Remaining card: " + remaining);

            n = scan.nextInt();
        } while (n != 0);
    }

    public static void fillArray(List<Integer> inteiros, int n) {

        for (int i = 1; i <= n; i++) {
            inteiros.add(i);
        }
    }
}