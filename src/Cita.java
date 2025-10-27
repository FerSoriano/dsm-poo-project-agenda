
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Cita {
    private Paciente paciente;
    private LocalDateTime fechaHora;
    private String motivo;
    private int duracionMinutos;
    private double costoCita;

    public Cita(Paciente paciente, LocalDateTime fechaHora, String motivo, int duracionMinutos) {
        this.paciente = paciente;
        this.fechaHora = fechaHora;
        this.setMotivo(motivo);
        this.duracionMinutos = duracionMinutos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public LocalDate getFecha() {
        return fechaHora.toLocalDate();
    }

    public LocalTime getHora() {
        return fechaHora.toLocalTime();
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        if(!motivo.isEmpty()) {
            this.motivo = motivo;
        } else {
            System.out.println("El motivo no puede estar vacio.");
        }
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public LocalDateTime terminaEn() {
        return this.fechaHora.plusMinutes(this.duracionMinutos);
    }

    @Override
    public String toString() {
        return "Fecha: " + getFecha() + '\n' +
                "Hora: " + getHora() + '\n' +
                "Paciente: " + paciente.getNombre() + '\n' +
                "Motivo: " + motivo + '\n' +
                "Duracion (min): " + duracionMinutos + '\n';
    }
}
