public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("Fernando", "3312168586", 'M');
        System.out.println(paciente.getId());

        Paciente paciente2 = new Paciente("Ramon", "3312168586", 'M');
        System.out.println(paciente2.getId());

        Paciente paciente3 = new Paciente("Juan", "3312168586", 'M');
        System.out.println(paciente3.getId());
    }
}