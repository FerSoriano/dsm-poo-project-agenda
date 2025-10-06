public class Paciente {
    private static int totalPacientes = 0;

    private final String id;
    private String nombre;
    private String telefono;
    private char genero;

    public Paciente(String nombre, String telefono, char genero) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.genero = Character.toUpperCase(genero);
        this.id = "P" + String.format("%03d", ++totalPacientes);
    }

    // metodo estatico para crear al paciente con las validaciones.
    public static Paciente crearPaciente(String nombre, String telefono, char genero) {
        if (nombre == null || nombre.isEmpty()) return null;
        if (telefono == null || telefono.length() != 10) return null;
        if (Character.toUpperCase(genero) != 'M' && Character.toUpperCase(genero) != 'F') return null;
        return new Paciente(nombre, telefono, genero);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty()){
            this.nombre = nombre;
        } else {
            System.out.println("Nombre invalido");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono.length() == 10) {
            this.telefono = telefono;
        } else {
            System.out.println("El numero debe tener 10 digitos.");
        }
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        if( Character.toUpperCase(genero) == 'M' || Character.toUpperCase(genero) == 'F') {
            this.genero = genero;
        } else {
            System.out.println("Genero incorrecto. Debe ser 'M' o 'F'");
        }
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", genero=" + genero +
                '}';
    }
}
