
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Volei {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String nome = null;
        String tentativas;
        String acertos;

        float totalSaque = 0f;
        float totalBloqueio = 0f;
        float totalAtaque = 0f;

        float saque = 0f;
        float bloqueio = 0f;
        float ataque = 0f;

        String[] dados;
        for (int i = 0; i < n; i++) {
            nome = scan.nextLine();
            tentativas = scan.nextLine();
            dados = tentativas.split("\\s+");
            totalSaque += Float.parseFloat(dados[0]);
            totalBloqueio += Float.parseFloat(dados[1]);
            totalAtaque += Float.parseFloat(dados[2]);

            acertos = scan.nextLine();
            dados = acertos.split("\\s+");
            saque += Float.parseFloat(dados[0]);
            bloqueio += Float.parseFloat(dados[1]);
            ataque += Float.parseFloat(dados[2]);
        }

        saque *= 100;
        saque /= totalSaque;

        bloqueio *= 100;
        bloqueio /= totalBloqueio;

        ataque *= 100;
        ataque /= totalAtaque;

        System.out.printf("Pontos de Saque: %.2f %%.\n", saque);
        System.out.printf("Pontos de Bloqueio: %.2f %%.\n", bloqueio);
        System.out.printf("Pontos de Ataque: %.2f %%.\n", ataque);

    }
}