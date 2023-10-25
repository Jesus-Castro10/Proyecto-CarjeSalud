package hosptial;

import datos.CitaDAO;
import dominio.Cita;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class test {

    public static void main(String[] args) {
//        List<Cita> citas = new CitaDAO().listar();
//        for (Cita cita : citas) {
//            System.out.println("cita = " + cita);
//        }
    }

    public static void other() {
        // Crea una lista para almacenar las horas disponibles
        List<LocalTime> horas = new ArrayList<>();

        // Agrega horas a la lista cada media hora
        for (int hora = 7; hora <= 17; hora += 30) {
            horas.add(LocalTime.of(hora, 0));
        }

        // Itera sobre la lista e imprime cada hora
        for (LocalTime hora : horas) {
            System.out.println(hora);
        }
    }

    private java.util.List horas() {
        List<String> horas = new ArrayList<>();
        horas.add(LocalTime.of(7, 0).toString());

        for (int hora = 7; hora <= 17; hora++) {
            horas.add(LocalTime.of(hora, 30).toString());
        }
        return horas;
    }
}
