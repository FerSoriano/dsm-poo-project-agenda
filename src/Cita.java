
import java.time.LocalDateTime;

public class Cita {
    private Paciente paciente;
    private LocalDateTime fechaHora;
    private String motivo;
    private int duracionMinutos;

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
}
