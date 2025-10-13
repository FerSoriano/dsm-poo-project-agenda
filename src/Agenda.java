import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {
    ArrayList<Cita> citas = new ArrayList<>();

    public boolean agendar(Cita cita) {
        if (citas.isEmpty()) {
            citas.add(cita);
            return true;
        }
        boolean citaAceptada = false;
        for (Cita c : citas) {
            if (cita.terminaEn().isAfter(c.getFechaHora()) && cita.terminaEn().isBefore(c.terminaEn())) {
                citaAceptada = false;
            } else {
                citaAceptada = true;
            }
        }
        if (citaAceptada) citas.add(cita);
        return citaAceptada;
    }

    // sobrecarga de metodos.
    public void mostrarAgenda () {
        for (Cita c : citas) {
            System.out.println(c.toString());
        }
    }
    public void mostrarAgenda (LocalDate fecha) {
        for (Cita c : citas) {
            if (fecha.equals(c.getFecha())){
                System.out.println(c.toString());
            }
        }
    }

    public ArrayList<Cita> citasDe(String idPaciente) {
        ArrayList<Cita> citasPaciente = new ArrayList<>();
        for (Cita c : citas) {
            Paciente p = c.getPaciente();
            if (p.getId().equals(idPaciente)) citasPaciente.add(c);
        }
        return citasPaciente;
    }

    public boolean cancelarCita(Cita cita) {
        boolean citaCancelada = false;
        for (Cita c : citas) {
            if (cita.equals(c)) citas.remove(c);
            citaCancelada = true;
        }
        return citaCancelada;
    }

    public Cita siguienteCitaDe(String idPaciente) {
        for (Cita c : citas) {
            Paciente p = c.getPaciente();
            if (p.getId().equals(idPaciente) && LocalDateTime.now().isBefore(c.getFechaHora())) {
                    return c;
            }
        }
        return null;
    }
}
