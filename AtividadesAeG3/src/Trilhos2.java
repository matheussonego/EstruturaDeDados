
import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class Trilhos2 {
    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(System.in);

        List<List<String>> arrayInput = new ArrayList<>();

        String input;

        while (!isZero(input = scan.nextLine())) {

            while (!isZero(input)) {
                input = scan.nextLine();

                arrayInput.add(getList(input));
            }
        }

        for (List<String> s : arrayInput) {

            if (s.size() != 1 && !s.get(0).equals("0")) {
                System.out.println(canDo(s));
            } else {
                System.out.println();
            }
        }
    }

    public static String canDo(List<String> input) {

        List<String> vaga = new ArrayList<>();

        int curValue = input.size();

        String t;
        while (curValue > 0) {

            for (int i = input.size() - 1; i >= 0; i--) {

                t = input.get(i);
                vaga.add(input.remove(i));

                if (Integer.parseInt(t) == curValue) {
                    break;
                }
            }

            for (int j = vaga.size() - 1; j >= 0; j--) {

                if (Integer.parseInt(vaga.get(j)) == curValue) {

                    vaga.remove(j);

                    curValue--;
                } else {
                    break;
                }
            }

            if (input.isEmpty() && !vaga.isEmpty()) {
                return "No";
            }
        }

        return "Yes";
    }

    public static List<String> getList(String input) {

        List<String> arrayIntegers = new ArrayList<>();

        String[] data = input.split("\\s+");

        for (int i = 0; i < data.length; i++) {
            arrayIntegers.add(data[i]);
        }

        return arrayIntegers;
    }

    public static boolean isZero(String input) {

        String[] data = input.split("\\s+");

        if (data.length == 1 && data[0].equals("0")) {
            return true;
        }

        return false;
    }
}