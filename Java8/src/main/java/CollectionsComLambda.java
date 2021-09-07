import java.util.Arrays;
import java.util.List;

public class CollectionsComLambda {

    public static void main(String[] args) {
        List<String> frutas = Arrays.asList("Jabuticaba", "Groselha", "Laranja","Amora", "Goiaba", "Limao", "Melancia");


        System.out.println("-------------------------------");
        System.out.println("Usando o forEach do Java8 com o Println em Lambda");
        frutas.forEach(f -> System.out.println(f));

        System.out.println("-------------------------------");
        System.out.println("Usando o Streams do Java8 com Lambda");

        frutas.stream().filter(f -> f.startsWith("L")).forEach(System.out::println);

        List<Integer> deUmADez = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        System.out.println("-------------------------------");
        System.out.println("Tranforma os numeros de 0 a 9 para 1 a 10 e filtra os pares e imprime");
        deUmADez.stream().map(n -> n+1).filter(n -> n%2==0).forEach(System.out::println);

    }
}
