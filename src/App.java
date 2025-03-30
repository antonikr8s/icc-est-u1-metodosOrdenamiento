import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] arreglo = { 12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8 };
        int tam = arreglo.length;
        int[] arregloCopia = new int[tam];
        int m = arregloCopia.length;

        MetodoBurbuja metodoBurbuja = new MetodoBurbuja();
        MetodoBurbujaMejorado metodoBurbujaMejorado = new MetodoBurbujaMejorado();
        MetodoInsercion metodoInsercion = new MetodoInsercion();
        MetodoSeleccion metodoSeleccion = new MetodoSeleccion();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Metodos de Ordenamiento ===");
            System.out.println("1. Metodo Burbuja");
            System.out.println("2. Metodo Burbuja Mejorado");
            System.out.println("3. Metodo Inserción");
            System.out.println("4. Metodo Selección");
            System.out.println("5. Salir");

            int opcion = getPositiveInt(scanner, "-> Seleccione una opcion (1-5)");

            if (opcion < 1 || opcion > 5) {
                System.out.println("\nERROR: Debe ingresar un numero entre 1 y 5");
                continue;
            }
            if (opcion == 5) {
                continuar = false;
                System.out.println("Saliendo...");
                break;
            }

            for (int i = 0; i < m; i++) {
                arregloCopia[i] = arreglo[i];
            }

            boolean conPasos = getBooleanInput(scanner, "¿Desea ver los pasos? (true/false)");

            String orden = getValidString(scanner, new String[] { "A", "D" },
                    "¿Desea ordenar ascendentemente (A) o descendentemente (D)?");
            boolean ascendente = orden.equalsIgnoreCase("A");

            int comparaciones = 0;
            int cambios = 0;

            switch (opcion) {
                case 1:
                    System.out.println(">> Metodo Burbuja");
                    System.out.print("Arreglo original: ");
                    metodoBurbuja.imprimirArreglo(arregloCopia);
                    if (conPasos) {
                        comparaciones = metodoBurbuja.burbujaPasos(arregloCopia, ascendente, true);
                    } else {
                        comparaciones = metodoBurbuja.burbujaSinPasos(arregloCopia, ascendente);
                    }
                    cambios = metodoBurbuja.contarCambios(arreglo.clone(), ascendente);
                    break;
                case 2:
                    System.out.println(">> Metodo Burbuja Mejorado");
                    System.out.print("Arreglo original: ");
                    metodoBurbujaMejorado.imprimirEstado(arregloCopia);
                    if (conPasos) {
                        comparaciones = metodoBurbujaMejorado.burbujaMejoradoPasos(arregloCopia, ascendente);
                    } else {
                        comparaciones = metodoBurbujaMejorado.burbujaMejoradaSinPasos(arregloCopia, ascendente);
                    }
                    cambios = metodoBurbujaMejorado.contarCambios(arreglo.clone(), ascendente);
                    break;

                case 3:
                    System.out.println(">> Metodo Insercion");
                    System.out.print("Arreglo original: ");
                    metodoInsercion.imprimirArreglo(arregloCopia);
                    if (conPasos) {
                        comparaciones = metodoInsercion.insercionConPasos(arregloCopia, ascendente, true);
                    } else {
                        comparaciones = metodoInsercion.insercionSinPasos(arregloCopia, ascendente);
                    }
                    cambios = metodoInsercion.contarCambios(arreglo.clone(), ascendente);
                    break;
                case 4:
                    System.out.println(">> Metodo Seleccion");
                    System.out.print("Arreglo original: ");
                    metodoSeleccion.imprimirArreglo(arregloCopia);
                    if (conPasos) {
                        comparaciones = metodoSeleccion.seleccionarConPasos(arregloCopia, ascendente, true);
                    } else {
                        comparaciones = metodoSeleccion.seleccionarSinPasos(arregloCopia, ascendente);
                    }
                    cambios = metodoSeleccion.contarCambios(arreglo.clone(), ascendente);
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    continue;
            }

            System.out.print("Arreglo ordenado: ");
            metodoBurbuja.imprimirArreglo(arregloCopia);
            System.out.println("Comparaciones: " + comparaciones);
            System.out.println("Cambios: " + cambios);
        }

        scanner.close();
    }

    // Solicitar al usuario un numero entero positivo. Si se ingresa un texto o un
    // numero <=0 nos muestra un error hasta ingresar la entrada correcta
    public static int getPositiveInt(Scanner scanner, String message) {
        int number;
        do {
            System.out.print(message + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("\nERROR: Debe ingresar un numero");
                System.out.print(message + ": ");
                scanner.next();
            }
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("\nERROR: El numero debe ser positivo");
            }
        } while (number <= 0);
        return number;
    }

    // Solicitar al usuario ingresar A o D. Si ingresa otro valor nos muestra un
    // error hasta ingresar la entrada correcta
    public static String getValidString(Scanner scanner, String[] posibles, String message) {
        String input;
        boolean valido;
        do {
            System.out.print(message + ": ");
            input = scanner.next();
            valido = false;

            for (String posible : posibles) {
                if (input.equalsIgnoreCase(posible)) {
                    valido = true;
                    break;
                }
            }

            if (!valido) {
                System.out.println("\nOpcion invalida. Vuelva a intentar");
            }

        } while (!valido);
        return input;
    }

    // Solicita al usuario ingresar true o false. Nos muestra un error si se escribe
    // otro caracter hasta ingresar la entrada correcta
    public static boolean getBooleanInput(Scanner scanner, String message) {
        String input;
        while (true) {
            System.out.print(message + ": ");
            input = scanner.next();
            if (input.equalsIgnoreCase("true")) {
                return true;
            } else if (input.equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println("\nERROR: Escriba 'true' o 'false'.");
            }
        }
    }
}