
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ParesImpares {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int quantity = scan.nextInt();

        int[] numbers = new int[quantity];

        for (int i = 0; i < quantity; i++) {

            numbers[i] = scan.nextInt();
        }

        List<Integer> filtered = getFiltered(numbers);

        for (int i : filtered) {
            System.out.println(i);
        }
    }

    public static List<Integer> getFiltered(int[] numbers) {

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 2 == 0) {
                even.add(numbers[i]);
            } else {
                odd.add(numbers[i]);
            }
        }

        sortIncreasing(even);
        sortDecreasing(odd);

        even.addAll(odd);

        return even;
    }

    public static void sortIncreasing(List<Integer> numbers) {

        for (int gap = numbers.size() / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < numbers.size(); i++) {
                int value = numbers.get(i);

                int jumper = i;
                while (jumper >= gap && numbers.get(jumper - gap) > value) {
                    numbers.set(jumper, numbers.get(jumper - gap));
                    jumper -= gap;
                }

                numbers.set(jumper, value);
            }
        }
    }

    public static void sortDecreasing(List<Integer> numbers) {

        for (int gap = numbers.size() / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < numbers.size(); i++) {
                int value = numbers.get(i);

                int jumper = i;
                while (jumper >= gap && numbers.get(jumper - gap) < value) {
                    numbers.set(jumper, numbers.get(jumper - gap));
                    jumper -= gap;
                }

                numbers.set(jumper, value);
            }
        }
    }
}
