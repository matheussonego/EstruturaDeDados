
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Mercado2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String values = scan.nextLine();

        String workersString = scan.nextLine();

        String customersString = scan.nextLine();

        String[] valuesArray = values.split("\\s+");

        int workers = Integer.parseInt(valuesArray[0]);

        int[] workersArray = new int[workers];

        int[] atendenceArray = new int[workers];

        for (int n = 0; n < atendenceArray.length; n++) {
            atendenceArray[n] = 0;
        }

        fill(atendenceArray);

        String[] stringArrayWorkers = workersString.split("\\s+");

        for (int i = 0; i < stringArrayWorkers.length; i++) {
            workersArray[i] = Integer.parseInt(stringArrayWorkers[i]);
        }

        List<Integer> customersArray = new ArrayList<>();

        String[] stringArrayCustomers = customersString.split("\\s+");

        for (int j = 0; j < stringArrayCustomers.length; j++) {
            customersArray.add(Integer.parseInt(stringArrayCustomers[j]));
        }

        int time = 0;
        do {

            time += removeSmallest(atendenceArray);

            addClients(atendenceArray, workersArray, customersArray);
        } while (!isEmpty(atendenceArray));

        System.out.println(time);

    }

    public static boolean isEmpty(int[] atendence) {

        for (int i = 0; i < atendence.length; i++) {
            if (atendence[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void addClients(int[] atendence, int[] workers, List<Integer> customers) {

        for (int i = 0; i < atendence.length; i++) {
            if (atendence[i] == 0 && !customers.isEmpty()) {
                atendence[i] = workers[i] * customers.remove(0);
            }
        }
    }

    public static int removeSmallest(int[] atendence) {

        int smallest = 0;
        for (int j = 0; j < atendence.length; j++) {
            if (atendence[j] != 0) {
                smallest = atendence[j];
            }
        }

        for (int i = 0; i < atendence.length; i++) {
            if (atendence[i] != 0) {
                atendence[i] -= smallest;
            }
        }

        return smallest;
    }

    public static int getSmallest(int[] atendence) {
        
        int smallest = atendence[0];
        
        for (int i = 0; i < atendence.length; i++) {
            if (atendence[i] < smallest && atendence[i] != 0) {
                smallest = atendence[i];
            }
        }

        return smallest;
    }

    public static void fill(int[] atendence) {
        for (int i = 0; i < atendence.length; i++) {
            atendence[i] = 0;
        }
    }
}
