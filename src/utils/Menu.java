package utils;

public class Menu {

    public void mostrarTitulo() {
        int repeat = 33;
        System.out.println("-".repeat(repeat));
        System.out.println("\tAgenda de Citas Medicas");
        System.out.println("-".repeat(repeat));
    }

    public void menuPrincipal() {
        System.out.println("\nBienvenido. Selecciona una opcion:\n");
        System.out.println("1) Menu Paciente");
        System.out.println("2) Menu Citas");
        System.out.println("3) Menu Agenda");
        System.out.println("4) Salir");
        System.out.print("\n\tOpcion: ");
    }

    public void menuPacientes() {
        mostrarMensajeConsola("Menu Paciente", 20);
        System.out.println("1) Crear nuevo paciente");
        System.out.println("2) Ver pacientes");
        System.out.println("3) Editar paciente"); // TODO. Implementar metodo editar paciente
        System.out.println("4) Regresar menu anterior");
        System.out.print("\n\tOpcion: ");
    }

    public void menuCitas() {
        mostrarMensajeConsola("Menu Citas", 20);
        System.out.println("1) Crear nueva cita");
        System.out.println("2) Ver todas las citas");
        System.out.println("3) Ver citas por Paciente");
        System.out.println("4) Cancelar cita");
        System.out.println("5) Regresar menu anterior");
        System.out.print("\n\tOpcion: ");
    }

    public void menuAgenda() {
        System.out.println("\n* Implementar menu agenda... *\n"); // TODO: Implemenmtar menu agenda
    }

    public void mostrarMensajeConsola(String mensaje) {
        System.out.println('\n' + mensaje + '\n');
    }

    public void mostrarMensajeConsola(String mensaje, int lineasFormatoTitulo) {
        System.out.println('\n' + "-".repeat(lineasFormatoTitulo));
        System.out.println('\t' + mensaje);
        System.out.println("-".repeat(lineasFormatoTitulo));
    }

    public void mostrarMensajeError(String mensaje) {
        System.out.println("\n* " + mensaje + " *\n");
    }

}
