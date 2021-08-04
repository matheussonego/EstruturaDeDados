
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fila {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String line2 = scan.nextLine();

        int n2 = Integer.parseInt(scan.nextLine());

        String line4 = scan.nextLine();

        String[] data = line2.split("\\s+");
        String[] data2 = line4.split("\\s+");

        int[] intData = new int[data.length];
        int[] intData2 = new int[data2.length];

        for (int i = 0; i < data.length; i++) {
            intData[i] = Integer.parseInt(data[i]);
        }

        for (int j = 0; j < data2.length; j++) {
            intData2[j] = Integer.parseInt(data2[j]);
        }

        List<Integer> list = new ArrayList<>();

        for (int t = 0; t < intData.length; t++) {
            if (!isThere(intData2, intData[t])) {
                list.add(intData[t]);
            }
        }

        StringBuilder sb = new StringBuilder("");

        sb.append(list.get(0));
        for (int s = 1; s < list.size(); s++) {
            sb.append(" ");
            sb.append(list.get(s));
        }

        System.out.println(sb.toString());
    }

    public static boolean isThere(int[] array, int inteiro) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == inteiro) {
                return true;
            }
        }
        return false;
    }
}
