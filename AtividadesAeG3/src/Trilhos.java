
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trilhos {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n;

        String str;
        String str2;
        List<Integer> inteiros;
        String[] sInteiros;

        List<String> ans = new ArrayList<>();

        do {
            str = scan.nextLine();
            if (!validate(str)) {
                break;
            }
            
            do {
                str2 = scan.nextLine();

                if (!validate(str2)) {
                    break;
                }

                inteiros = new ArrayList<>();

                sInteiros = str2.split("\\s+");
                
                fill(inteiros, sInteiros);

                if (canPass(inteiros)) {
                    ans.add("Yes");
                } else {
                    ans.add("No");
                }
            } while (validate(str2));

            ans.add("\n");

        } while (validate(str));

        ans.remove(ans.size() - 1);
        for (String s : ans) {
            if (!s.equals("\n")) {
                System.out.println(s);
            } else {
                System.out.print(s);
            }
        }
        
    }

    public static boolean canPass(List<Integer> inteiros) {
        List<Integer> parada = new ArrayList<>();

        int inte = inteiros.size();

        int n;
        int i = inteiros.size();
        while (i >= 1) {

            for (int j = inteiros.size() - 1; j >= 0; j--) {
                n = inteiros.remove(j);
                parada.add(n);

                if (n == i) {
                    break;
                }
            }

            for (int r = parada.size() - 1; r >= 0; r--) {
                if (parada.get(r) == i) {
                    parada.remove(r);
                    i--;
                } else {
                    i--;
                    break;
                }
            }
        }

        if (inteiros.isEmpty() && parada.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void fill(List<Integer> inteiros, String[] s) {

        for (int i = 0; i < s.length; i++) {
            inteiros.add(Integer.parseInt(s[i]));
        }
    }

    public static boolean validate(String s) {
        String[] data = s.split("\\s+");

        if (data.length == 1 && Integer.parseInt(data[0]) == 0) {
            return false;
        }
        return true;
    }
}
