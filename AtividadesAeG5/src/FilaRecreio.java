
import java.util.Scanner;

public class FilaRecreio {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testCases = Integer.parseInt(scan.nextLine());

        int[][] notas = new int[testCases][];

        int studentsLength;

        for (int i = 0; i < testCases; i++) {

            studentsLength = Integer.parseInt(scan.nextLine());

            notas[i] = new int[studentsLength];

            String input = scan.nextLine();

            fillNotasAlunos(input, notas[i]);
        }

        for (int i = 0; i < testCases; i++) {

            System.out.println(selectionSort(notas[i]));
        }
    }

    public static int selectionSort(int[] notas) {

        int[] copia = notas.clone();

        for (int i = 0; i < notas.length; i++) {
            
            int maiorValor = i;

            for (int j = i; j < notas.length; j++) {
                
                if (notas[j] > notas[maiorValor]) {
                    maiorValor = j;
                }
            }

            int aux = notas[i];
            notas[i] = notas[maiorValor];
            notas[maiorValor] = aux;
        }

        int alunosTrocados = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == copia[i]) {
                alunosTrocados++;
            }
        }

        return alunosTrocados;
    }

    public static void fillNotasAlunos(String input, int[] notasVetor) {

        String[] notasStr = input.split("\\s+");

        for (int i = 0; i < notasStr.length && i < notasVetor.length; i++) {

            notasVetor[i] = Integer.parseInt(notasStr[i]);
        }
    }
}
