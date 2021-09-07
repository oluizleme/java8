import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasParis = LocalDate.of(2024, Month.JUNE, 5);

        var anos = olimpiadasParis.getYear() - hoje.getYear();

        System.out.println(anos);

        var periodo = Period.between(hoje, olimpiadasParis);
        System.out.println("Falta: "+ periodo.getYears() + " anos, " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias");

        var proximasOlimpiadas = olimpiadasParis.plusYears(4);

        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var valorFormatado = proximasOlimpiadas.format(formatador);

        System.out.println(valorFormatado);

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));
    }
}
