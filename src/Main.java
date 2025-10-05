import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("Pepe", "3355118622", 'M');

        Cita cita = new Cita(paciente, LocalDateTime.now().plusHours(3), "Cita medica", 30);

        if(cita.proximaCita() != null) {
            System.out.println("Proxima cita: " + cita.proximaCita());
        } else {
            System.out.println("No hay citas registradas.");
        }
    }
}