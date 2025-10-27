
import utils.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            if (opcion == 2) irAMenuCitas();
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
            if (opcion == 1) crearNuevoPaciente();
            if (opcion == 2) Paciente.mostrarPacientes();
            if (opcion == 3) menu.mostrarMensajeConsola("Implementar eliminar paciente"); // TODO: Implementar eliminar paciente.
            if (opcion == 4) break;
        }
    }

    public static void crearNuevoPaciente() {
        scanner.nextLine(); // se limpia el buffer
        menu.mostrarMensajeConsola("CREAR NUEVO PACIENTE", 25);
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

    public static void irAMenuCitas() {
        while (true) {
            menu.menuCitas();
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 5) {
                menu.mostrarMensajeConsola("Opcion incorrecta. Intenta de nuevo");
                continue;
            }
            if (opcion == 1) crearNuevaCita();
            if (opcion == 2) Agenda.mostrarAgenda();
            if (opcion == 3) menu.mostrarMensajeConsola("Implementar Ver citas por paciente");
            if (opcion == 4) menu.mostrarMensajeConsola("Implementar cancelar cita");
            if (opcion == 5) break;
        }
    }

    public static void crearNuevaCita() {
        scanner.nextLine(); // se limpia el buffer
        menu.mostrarMensajeConsola("CREAR NUEVA CITA", 25);
        Paciente paciente;
        // TODO: Implementar salir con * de cualquier opcion
        // TODO: CREAR VALIDACION PARA PEDIR EL ID O EL TELEFONO

        buscarPaciente:
        do {
//            scanner.nextLine(); // se limpia el buffer
            System.out.println("\nSelecciona una opcion para crear la cita:");
            System.out.println("1) Por ID paciente");
            System.out.println("2) Por numero de telefono");
            System.out.print("Opcion ('*' para salir): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "*" -> {
                    return;
                }
                case "1" -> {
//                    scanner.nextLine(); // se limpia el buffer
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    paciente = Paciente.getPacientePorId(id);
                    if (paciente != null) {
                        menu.mostrarMensajeConsola("Paciente enconrado: " + paciente.getNombre());
                        break buscarPaciente;
                    }
                    menu.mostrarMensajeError("No se encontro el paciente con el id: [" + id + "]. Intenta de nuevo.");
                }
                case "2" -> {
//                    scanner.nextLine(); // se limpia el buffer

                    System.out.print("Telefono (10 digitos): ");
                    String telefono = scanner.nextLine();
                    paciente = Paciente.getPacientePorTelefono(telefono);
                    if (paciente != null) {
                        System.out.println("\nPaciente enconrado: " + paciente.getNombre() + "\n");
                        break buscarPaciente;
                    }
                    menu.mostrarMensajeError("No se encontro el paciente con el telefono: [" + telefono + "]. Intenta de nuevo.");
                }
                default -> {
                    menu.mostrarMensajeError("Opcion incorrecta.");
                }
            }
        } while (true);

        LocalDateTime fechaHora = preguntarFechaYHora();

        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();
        System.out.print("Duracion (min): ");
        int duracion = scanner.nextInt();

        Cita cita = new Cita(paciente, fechaHora, motivo, duracion);
        while (!agendarCita(cita)) {
            menu.mostrarMensajeConsola("Ingresa de nuevo la fecha y hora de tu cita.");
            fechaHora = preguntarFechaYHora();
            cita.setFechaHora(fechaHora);
        }
    }

    public static LocalDateTime preguntarFechaYHora() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        do {
            try {
                System.out.print("Fecha (dd/MM/yyyy): ");
                String fechaInput = scanner.nextLine();
                LocalDate fecha = LocalDate.parse(fechaInput, formatoFecha);

                System.out.print("Hora (HH:mm): ");
                String horaInput = scanner.nextLine();
                LocalTime hora = LocalTime.parse(horaInput, formatoHora);

                return LocalDateTime.of(fecha, hora); // Combinar fecha y hora en un LocalDateTime
            } catch (Exception e) {
                System.out.println("❌ Error: formato incorrecto. Ejemplo correcto -> Fecha: 05/10/2025, Hora: 14:30");
            }
        } while (true);
    }

    public static boolean agendarCita(Cita cita) {
        if (Agenda.agendar(cita)){
            menu.mostrarMensajeConsola("Cita creada para " + cita.getPaciente().getNombre() +
                    " el dia " + cita.getFecha() + " a las " + cita.getHora(), 50);
            return true;
        } else {
            menu.mostrarMensajeError("❌ Error. No hay disponibilidad en ese horario. Intenta de nuevo.");
            String opcion;
            System.out.print("Quieres ver las citas agendadas para el dia " + cita.getFecha() + "? (y/n): ");
            opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("Y")) {
                Agenda.mostrarAgenda(cita.getFecha());
            }
        }
        return false;
    }
}