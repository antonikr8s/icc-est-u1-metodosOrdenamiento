public class MetodoSeleccion {
    public int seleccionarConPasos(int[] arreglo, boolean ascendente, boolean conPasos) {
        int n = arreglo.length;
        int comparaciones = 0;

        if (conPasos) {
            imprimirEstado(arreglo);
        }

        for (int i = 0; i < n - 1; i++) {
            int indice = i;

            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if ((ascendente && arreglo[j] < arreglo[indice])
                        || (!ascendente && arreglo[j] > arreglo[indice])) {
                    indice = j;
                }
            }

            int aux = arreglo[indice];
            arreglo[indice] = arreglo[i];
            arreglo[i] = aux;

            if (conPasos) {
                System.out.println("Intercambia " + arreglo[i] + " con " + arreglo[indice]);
                imprimirEstado(arreglo);
            }
        }

        return comparaciones;
    }

    public int seleccionarSinPasos(int[] arreglo, boolean ascendente) {
        int comparaciones = 0;
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indice = i;

            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if ((ascendente && arreglo[j] < arreglo[indice])
                        || (!ascendente && arreglo[j] > arreglo[indice])) {
                    indice = j;
                }
            }

            int aux = arreglo[indice];
            arreglo[indice] = arreglo[i];
            arreglo[i] = aux;
        }

        return comparaciones;
    }

    private void imprimirEstado(int[] arreglo) {
        System.out.print("Estado actual: ");
        imprimirArreglo(arreglo);
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

    public int contarComparaciones(int[] arreglo, boolean ascendente) {
        int comparaciones = 0;
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indice = i;

            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if ((ascendente && arreglo[j] < arreglo[indice])
                        || (!ascendente && arreglo[j] > arreglo[indice])) {
                    indice = j;
                }
            }

            int aux = arreglo[indice];
            arreglo[indice] = arreglo[i];
            arreglo[i] = aux;
        }

        return comparaciones;
    }

    public int contarCambios(int[] arreglo, boolean ascendente) {
        int cambios = 0;
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indice = i;

            for (int j = i + 1; j < n; j++) {
                if ((ascendente && arreglo[j] < arreglo[indice])
                        || (!ascendente && arreglo[j] > arreglo[indice])) {
                    indice = j;
                }
            }

            if (indice != i) {
                int aux = arreglo[indice];
                arreglo[indice] = arreglo[i];
                arreglo[i] = aux;
                cambios++;
            }
        }

        return cambios;
    }
}
