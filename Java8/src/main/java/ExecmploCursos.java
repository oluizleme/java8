import java.util.*;
import java.util.stream.Collectors;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public int getAlunos() {
        return alunos;
    }

    public String getNome() {
        return nome;
    }
}

public class ExecmploCursos {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python",45));
        cursos.add(new Curso("JavaScript",150));
        cursos.add(new Curso("Java 8",113));
        cursos.add(new Curso("C",55));

        cursos.sort(Comparator.comparingInt(Curso::getAlunos));

        cursos.forEach(c -> System.out.println(c.getNome()));

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e imprime o nome");
        System.out.println("-------------------------------");

        cursos.stream().filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e imprime o número de alunos");
        System.out.println("-------------------------------");

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e soma o valores");
        System.out.println("-------------------------------");

        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(sum);

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e e pega qualquer um");
        System.out.println("-------------------------------");

        Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();
        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e e pega qualquer um - Mais enxuto");
        System.out.println("-------------------------------");
        cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e imprime o nome - Usando o Collector.toList()");
        System.out.println("-------------------------------");

        List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

        cursos.stream().forEach(c -> System.out.println(c.getNome()));

        System.out.println("Stream filtra os cursos com ou mais de 100 alunos e imprime o nome - Usando o Collector.toMap()");
        System.out.println("-------------------------------");

        cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toMap(
                c -> c.getNome(),
                c -> c.getAlunos()))
                .forEach((nome,alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
    }

}
