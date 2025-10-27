import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {
    public static ArrayList<Cita> citas = new ArrayList<>();

    public static boolean agendar(Cita cita) {
        if (citas.isEmpty()) {
            citas.add(cita);
            return true;
        }
        boolean citaAceptada = false;
        for (Cita c : citas) {
            if (cita.getFechaHora().isEqual(c.getFechaHora())) {
                citaAceptada = false;
            } else if (cita.getFechaHora().isAfter(c.getFechaHora()) && cita.getFechaHora().isBefore(c.terminaEn())) {
                citaAceptada = false;
            } else {
                citaAceptada = true;
            }
        }
        if (citaAceptada) citas.add(cita);
        return citaAceptada;
    }

    // sobrecarga de metodos.
    public static void mostrarAgenda () {
        if (citas.isEmpty()) {
            System.out.println("\nNo hay citas registradas");
            return;
        }
        for (Cita c : citas) {
            System.out.println(c.toString());
        }
    }
    public static void mostrarAgenda (LocalDate fecha) {
        for (Cita c : citas) {
            if (fecha.equals(c.getFecha())){
                System.out.println(c.toString());
            }
        }
    }

    public static ArrayList<Cita> citasDe(String idPaciente) {
        ArrayList<Cita> citasPaciente = new ArrayList<>();
        for (Cita c : citas) {
            Paciente p = c.getPaciente();
            if (p.getId().equals(idPaciente)) citasPaciente.add(c);
        }
        return citasPaciente;
    }

    public static boolean cancelarCita(Cita cita) {
        boolean citaCancelada = false;
        for (Cita c : citas) {
            if (cita.equals(c)) citas.remove(c);
            citaCancelada = true;
        }
        return citaCancelada;
    }

    public static Cita siguienteCitaDe(String idPaciente) {
        for (Cita c : citas) {
            Paciente p = c.getPaciente();
            if (p.getId().equals(idPaciente) && LocalDateTime.now().isBefore(c.getFechaHora())) {
                    return c;
            }
        }
        return null;
    }
}
