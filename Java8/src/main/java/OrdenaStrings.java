import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        frutas.add("Jabuticaba");
        frutas.add("Groselha");
        frutas.add("Laranja");
        frutas.add("Amora");

        Comparator<String> comparator = new ComparadorPorTamanho();
        Collections.sort(frutas, comparator);
        System.out.println("-------------------------------");
        System.out.println("Usando o jeito Java 7");
        System.out.println(frutas);

        System.out.println("-------------------------------");
        System.out.println("Usando o default method sort de List");

        frutas.sort(comparator);
        System.out.println(frutas);

        System.out.println("-------------------------------");
        System.out.println("Usando o forEach do Java8");
        Consumer<String> consumidor = new ImprimeNaLinha();
        frutas.forEach(consumidor);
    }
}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}
