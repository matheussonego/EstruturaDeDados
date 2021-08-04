
import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;


public class FilaSuperMercado {
    
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);

        String linha1 = scan.nextLine();
        String linha2 = scan.nextLine();
        String linha3 = scan.nextLine();

        String[] primeiraLinha = linha1.split("\\s+");
        String[] segundaLinha = linha2.split("\\s+");
        String[] terceiraLinha = linha3.split("\\s+");

        int funcionarios = Integer.parseInt(primeiraLinha[0]);
        int clientes = Integer.parseInt(primeiraLinha[1]);

        int[] arrayFuncionarios = new int[funcionarios];
        int[] atendimentos = new int[funcionarios];
        List<Integer> arrayClientes = new ArrayList<>();

        for (int i = 0; i < funcionarios; i++) {
            arrayFuncionarios[i] = Integer.parseInt(segundaLinha[i]);
            atendimentos[i] = 0;
        }

        for (int j = 0; j < clientes; j++) {
            arrayClientes.add(Integer.parseInt(terceiraLinha[j]));
        }

        int time = 0;
        
        do {

            time += removeClient(atendimentos);

            alocate(arrayFuncionarios, atendimentos, arrayClientes);

        } while (!isEmpty(atendimentos));

        System.out.print(time);
    }

    public static int removeClient(int[] atendimentos) {

        int menor = getSmallest(atendimentos);

        for (int i = 0; i < atendimentos.length; i++) {
            atendimentos[i] -= menor;
        }

        return menor;
    }

    public static int getSmallest(int[] atendimentos) {

        int smallest = 0;
        for (int i = 0; i < atendimentos.length; i++) {
            if (atendimentos[i] != 0) {
                smallest = atendimentos[i];
                break;
            }
        }

        for (int j = 0; j < atendimentos.length; j++) {
            if (atendimentos[j] != 0 && atendimentos[j] < smallest) {
                smallest = atendimentos[j];
            }
        }

        return smallest;
    }

    public static void alocate(int[] funcionarios, int[] atendimentos, List<Integer> clientes) {

        for (int i = 0; i < atendimentos.length; i++) {
            if (atendimentos[i] == 0 && !clientes.isEmpty()) {
                atendimentos[i] = clientes.remove(0) * funcionarios[i];
            }
        }
    }

    public static boolean isEmpty(int[] atendimentos) {

        int n;
        for (int i = 0; i < atendimentos.length; i++) {
            n = atendimentos[i];
            if (atendimentos[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
