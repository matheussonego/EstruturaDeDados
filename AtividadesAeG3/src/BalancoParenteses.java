
import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class BalancoParenteses {
    
    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(System.in);

        String entrada;

        List<String> entradas = new ArrayList<>();        

        for (int i = 0; i < 1000; i++) {
            entrada = scan.nextLine();
            if (entrada.isEmpty()) {
                break;
            }
            entradas.add(entrada);
        }

        for (String s : entradas) {
            System.out.println(isCorrect(s));
        }
    }

    private static String isCorrect(String expression) {

        int n = 0;

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                n++;
            } else if (expression.charAt(i) == ')') {
                n--;
                if (i > 0 && expression.charAt(i - 1) == '(') {
                    return "incorrect";
                }
                if (n < 0) {
                    return "incorrect";
                }
            }

        }

        if (n == 0) {
            return "correct";
        }
        return "incorrect";
    }
}
