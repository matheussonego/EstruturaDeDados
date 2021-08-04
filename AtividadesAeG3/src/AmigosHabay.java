
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmigosHabay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> querem = new ArrayList<>();
        List<String> naoQuerem = new ArrayList<>();

        String[] data;

        String input;
        while (!isEnd(input = scan.nextLine())) {

            data = input.split("\\s+");

            switch (data[1]) {
                case "YES":

                    if (!querem.contains(data[0])) {
                        querem.add(data[0]);   
                    }
                    break;
                case "NO":

                    naoQuerem.add(data[0]);
                    break;
            }
        }

        String amigo = null;
        int n = getLongestName(querem);
        for (String s : querem) {
            if (s.length() == n) {
                amigo = s;
                break;
            }
        }

        querem.sort((s1, s2) -> s1.compareTo(s2));
        naoQuerem.sort((s1, s2) -> s1.compareTo(s2));

        for (String s : querem) {
            System.out.println(s);
        }
        for (String s : naoQuerem) {
            System.out.println(s);
        }

        System.out.println("\nAmigo do Habay:");
        
        if (amigo != null) {
            System.out.println(amigo);
        }
    }

    public static int getLongestName(List<String> names) {

        int n = 0;
        for (String s : names) {
            if (s.length() > n) {
                n = s.length();
            }
        }

        return n;
    }

    public static boolean isEnd(String input) {

        String[] data = input.split("\\s+");

        if (data.length == 1 && data[0].equals("FIM")) {
            return true;
        }

        return false;
    }
}