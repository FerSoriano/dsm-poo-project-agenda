import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Paciente {
    private static int totalPacientes = 0;
    private static Set<String> telefonosPacientes = new HashSet<>();
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    private final String id;
    private String nombre;
    private String telefono;
    private char genero;

    public Paciente(String nombre, String telefono, char genero) {
        if (existePaciente(telefono)) {
            throw new IllegalArgumentException("El paciente con este teléfono ya existe.");
        }

        this.nombre = nombre;
        this.telefono = telefono;
        this.genero = Character.toUpperCase(genero);
        this.id = "P" + String.format("%03d", ++totalPacientes);

        telefonosPacientes.add(telefono); // se agrega al set de telefonos.
    }

    // metodo estatico para crear al paciente con las validaciones.
    public static Paciente crearPaciente(String nombre, String telefono, char genero) {
        if (nombre == null || nombre.isEmpty()) return null;
        if (telefono == null || telefono.length() != 10) return null;
        if (Character.toUpperCase(genero) != 'M' && Character.toUpperCase(genero) != 'F') return null;
        Paciente paciente = new Paciente(nombre, telefono, genero);
        listaPacientes.add(paciente); // se agrega nuevo paciente a la lista statica.
        return  paciente;
    }

    private static boolean existePaciente(String telefono) {
        return telefonosPacientes.contains(telefono);
    }

    public static void mostrarPacientes() {
        System.out.println();
        for (Paciente paciente : listaPacientes) {
            System.out.println(paciente.toString());
        }
    }

    public static Paciente getPacientePorId(String id) {
        if (id == null || listaPacientes == null || listaPacientes.isEmpty()) {
            return null;
        }
        for (Paciente paciente : listaPacientes) {
            if (paciente.id.equals(id.toUpperCase())) return paciente;
        }
        return null;
    }

    public static Paciente getPacientePorTelefono(String telefono) {
        if (telefono == null || listaPacientes == null || listaPacientes.isEmpty()) {
            return null;
        }
        for (Paciente paciente : listaPacientes) {
            if (paciente.telefono.equals(telefono)) return paciente;
        }
        return null;
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
