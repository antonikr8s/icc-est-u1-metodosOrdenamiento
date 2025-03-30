public class MetodoBurbujaMejorado {
    public int burbujaMejoradoPasos(int[] arreglo, boolean ascendente) {
        int n = arreglo.length;
        boolean hayCambio;
        int comparaciones = 0;

        imprimirEstado(arreglo);

        for (int i = 0; i < n - 1; i++) {
            hayCambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                System.out.println("Comparación: " + arreglo[j] + " vs " + arreglo[j + 1]);

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    System.out.println("Intercambio " + arreglo[j] + " con " + arreglo[j + 1]);

                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    hayCambio = true;
                }
            }
            imprimirEstado(arreglo);

            if (!hayCambio) {
                System.out.println("Ya fue ordenado");
                break;
            }
        }
        return comparaciones;
    }

    public int burbujaMejoradaSinPasos(int[] arreglo, boolean ascendente) {
        int n = arreglo.length;
        boolean hayCambio;
        int comparaciones = 0;

        for (int i = 0; i < n - 1; i++) {
            hayCambio = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {

                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    hayCambio = true;
                }
            }

            if (!hayCambio) {
                break;
            }
        }
        return comparaciones;
    }

    public void imprimirEstado(int[] arreglo) {
        System.out.print("Estado actual: ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public int contarComparaciones(int[] arreglo, boolean ascendente) {
        int comparaciones = 0;
        int n = arreglo.length;
        boolean hayCambio;

        for (int i = 0; i < n - 1; i++) {
            hayCambio = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    hayCambio = true;
                }
            }

            if (!hayCambio) {
                break;
            }
        }
        return comparaciones;
    }

    public int contarCambios(int[] arreglo, boolean ascendente) {
        int cambios = 0;
        int n = arreglo.length;
        boolean hayCambio;

        for (int i = 0; i < n - 1; i++) {
            hayCambio = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    cambios++;
                    hayCambio = true;
                }
            }

            if (!hayCambio) {
                break;
            }
        }

        return cambios;
    }
} 