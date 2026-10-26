import java.util.Scanner;

public class Examenpato {

    public class ExamenPracticoo {
        static int totalRegistrados = 0;
        static int aprobados = 0;
        static int reprobados = 0;
        static double sumaPromedios = 0;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarEstudiantes(scanner);
                        break;
                    case 2:
                        mostrarEstadisticas();
                        break;
                    case 3:
                        System.out.println("Gracias po usarlo");
                        break;
                    default:
                        System.out.println("Opción no vlida. Por favor, intente de nuevo.");
                }
                System.out.println();
            } while (opcion != 3);

            scanner.close();
        }

        public static void mostrarMenu() {

            System.out.println("      CONTROL DE CALIFICACIONES      ");

            System.out.println("1. Registrar calificaciones");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Sair");
            System.out.print("Seleccione una opción 1,2 o 3: ");
        }
        public static void registrarEstudiantes(Scanner scanner) {

            System.out.println("        REGISTRAR ESTUDIANTE         ");

            System.out.print("¿Cuántos estudiantes vas a registrar?: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            for (int i = 1; i <= cantidad; i++) {

                System.out.println("Estudiante " + i);

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Evaluación 1: ");
                double eval1 = scanner.nextDouble();

                System.out.print("Evaluación 2: ");
                double eval2 = scanner.nextDouble();

                System.out.print("Evaluación 3: ");
                double eval3 = scanner.nextDouble();
                scanner.nextLine();
                double promedio = (eval1 + eval2 + eval3) / 3.0;
                String resultado = (promedio >= 6.0) ? "aprobado" : "reprobado";
                totalRegistrados++;
                sumaPromedios += promedio;
                if (resultado.equals("aprobado")) {
                    aprobados++;
                } else {
                    reprobados++;
                }
                System.out.printf("Promedio", promedio);
                System.out.println("Resultado: " + resultado);
            }

        }
        public static void mostrarEstadisticas() {

            System.out.println("      estadisticas del grupo       ");


            double promedioGeneral = (totalRegistrados > 0) ? (sumaPromedios / totalRegistrados) : 0.0;

            System.out.println("Estudiantes registrados: " + totalRegistrados);
            System.out.println("Estudiantes aprobados: " + aprobados);
            System.out.println("Estudiantes reprobados: " + reprobados);
            System.out.printf("Promedio general: ", promedioGeneral);

        }
    }
}
