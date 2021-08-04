
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilaSuperMercadoOtimizado {
    
    public static void main(String[] args) throws IOException {
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

        for (int i = 0; i < clientes; i++) {
            if (i < arrayFuncionarios.length) {
                arrayFuncionarios[i] = Integer.parseInt(segundaLinha[i]);
                atendimentos[i] = 0;
            }

            arrayClientes.add(Integer.parseInt(terceiraLinha[i]));
        }

        int biggest = 0;

        do {

            biggest = runAlocation(atendimentos, arrayFuncionarios, arrayClientes, biggest);
        } while (!arrayClientes.isEmpty());

        System.out.println(biggest);
    }

    public static int runAlocation(int[] atendimentos, int[] arrayFuncionarios, List<Integer> arrayClientes, int biggestValue) {

        int indexSmaller = getSmallest(atendimentos);
        int smallestValue = atendimentos[indexSmaller];

        for (int i = indexSmaller; i < atendimentos.length && !arrayClientes.isEmpty(); i++) {
            if (atendimentos[i] == smallestValue) {
                atendimentos[i] += arrayFuncionarios[i] * arrayClientes.remove(0);

                if (atendimentos[i] > biggestValue) {
                    biggestValue = atendimentos[i];
                }
            }
        }

        return biggestValue;
    }

    public static int getSmallest(int[] atendimentos) {
        int index = 0;

        for (int i = 0; i < atendimentos.length; i++) {
            if (atendimentos[i] < atendimentos[index]) {
                index = i;
            }
        }

        return index;
    }
}
