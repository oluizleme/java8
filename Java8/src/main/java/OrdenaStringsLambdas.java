import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsLambdas {

    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        frutas.add("Jabuticaba");
        frutas.add("Groselha");
        frutas.add("Laranja");
        frutas.add("Amora");

        System.out.println("-------------------------------");
        System.out.println("Usando o forEach do Java8 com classe Anonima");
        frutas.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("-------------------------------");
        System.out.println("Usando o forEach do Java8 com Lambda");
        frutas.forEach(s -> System.out.println(s));

        //Sort com Lambda complexo
        frutas.sort((s1,s2) -> {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;
        });

        frutas.sort((s1,s2) ->Integer.compare(s1.length(), s2.length()));
        frutas.forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("Outra forma de comparar");

        frutas.sort(Comparator.comparing(s -> s.length()));
        frutas.forEach(System.out::println);

        System.out.println("-------------------------------");
        System.out.println("Outra forma de comparar usando Method reference");
        frutas.sort(Comparator.comparing(String::length));
        frutas.forEach(System.out::println);
    }
}


