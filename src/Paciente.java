public class Paciente {
    private static int totalPacientes = 0;

    private String id;
    private String nombre;
    private String telefono;
    private char genero;

    public Paciente(String nombre, String telefono, char genero) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.genero = genero;
        this.id = "P" + String.format("%03d", ++totalPacientes);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
