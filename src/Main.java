
import utils.Menu;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Menu menu = new Menu();

    public static void main(String[] args) {
        menu.mostrarTitulo();

        while (true) {
            menu.menuPrincipal();
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 4) {
                menu.mostrarMensajeConsola("Opcion incorrecta. Intenta de nuevo");
                continue;
            }
            if (opcion == 1) irAMenuPaciente();
            if (opcion == 2) menu.mostrarMensajeConsola("Creando nueva cita");
            if (opcion == 3) menu.mostrarMensajeConsola("Viendo agenda");
            if (opcion == 4) {
                menu.mostrarMensajeConsola("Saliendo del sistema");
                break;
            }
        }

    }

    public static void irAMenuPaciente() {
        while (true) {
            menu.menuPacientes();
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 4) {
                menu.mostrarMensajeConsola("Opcion incorrecta. Intenta de nuevo");
                continue;
            }
            if (opcion == 1) crearPaciente();
            if (opcion == 2) Paciente.mostrarPacientes();
            if (opcion == 3) menu.mostrarMensajeConsola("Implementar eliminar paciente"); // TODO: Implementar eliminar paciente.
            if (opcion == 4) break;
        }
    }

    public static void crearPaciente() {
        scanner.nextLine(); // se limpia el buffer
        menu.mostrarMensajeConsola("CREAR PACIENTE", 20);
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono (10 digitos): ");
        String telefono = scanner.nextLine();
        System.out.print("Genero (M/F): ");
        String generoString = scanner.next();
        char genero = generoString.charAt(0); // Obtener el primer caracter

        try {
            Paciente paciente = Paciente.crearPaciente(nombre, telefono, genero);
            if (paciente == null) {
                menu.mostrarMensajeConsola("Datos incorrectos del paciente. Intenta de nuevo.");
            } else {
                menu.mostrarMensajeConsola("Paciente " + paciente.getNombre() + " creado exitosamente.");
            }
        } catch (IllegalArgumentException e) {
            menu.mostrarMensajeConsola("Error: " + e.getMessage());
        }
    }
}