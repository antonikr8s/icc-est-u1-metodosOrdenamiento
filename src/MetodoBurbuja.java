public class MetodoBurbuja {
    public int burbujaPasos(int[] arreglo, boolean ascendente, boolean conPasos) {
        int n = arreglo.length;
        int comparaciones = 0;

        if (conPasos) {
            imprimirEstado(arreglo);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;

                    if (conPasos) {
                        System.out.println("Intercambia " + arreglo[j + 1] + " con " + arreglo[j]);
                    }

                }
                if (conPasos) {
                    System.out.println("Comparación #" + comparaciones + ": " + arreglo[j] + " vs " + arreglo[j + 1]);
                }
            }
            if (conPasos) {
                imprimirEstado(arreglo);
            }
        }
        return comparaciones;
    }

    public int burbujaSinPasos(int[] arreglo, boolean ascendente) {
        int comparaciones = 0;
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;

                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }

        return comparaciones;
    }

    private void imprimirEstado(int[] arreglo) {
        System.out.print("Estado actual: ");
        imprimirArreglo(arreglo);
    }

    public int ordearAscendente(int arreglo[]) {
        int n = arreglo.length;
        int comparaciones = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
            }
        }
        return comparaciones;
    }

    public void imprimirArreglo(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i]);
            if (i < n - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public int contarCambios(int[] arreglo, boolean ascendente) {
        int cambios = 0;
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    cambios++;
                }
            }
        }

        return cambios;
    }
}
