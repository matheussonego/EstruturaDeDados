import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Teste {
    
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();

        l.add("bad");
        l.add("cade");
        l.add("cade");
        l.add("abr");

        l.sort((l1, l2) -> l1.compareTo(l2));

        for (String str : l) {
            System.out.println(str);
        }
    }
}
