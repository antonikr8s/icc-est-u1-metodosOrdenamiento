public class MetodoInsercion {
    public int insercionConPasos(int[] arreglo, boolean ascendente, boolean conPasos) {
        int comparaciones = 0;
        int n = arreglo.length;

        if (conPasos) {
            imprimirEstado(arreglo);
        }
        for (int i = 1; i < n; i++) {
            int valorActual = arreglo[i];
            int j = i - 1;

            if (conPasos) {
                System.out.println("i: " + i + ", j: " + j + ", aux: " + valorActual);
            }

            if (ascendente) {
                while (j >= 0 && arreglo[j] > valorActual) {
                    comparaciones++;
                    if (conPasos) {
                        System.out.println("Compara aux: " + valorActual + " con arreglo[" + j + "]: " + arreglo[j]);
                        System.out.println("Mueve arreglo[" + j + "] a arreglo[" + (j + 1) + "]");
                    }
                    arreglo[j + 1] = arreglo[j];
                    j--;
                }
            } else {
                while (j >= 0 && arreglo[j] < valorActual) {
                    comparaciones++;
                    if (conPasos) {
                        System.out.println("Compara aux: " + valorActual + " con arreglo[" + j + "]: " + arreglo[j]);
                        System.out.println("Mueve arreglo[" + j + "] a arreglo[" + (j + 1) + "]");
                    }
                    arreglo[j + 1] = arreglo[j];
                    j--;
                }
            }

            arreglo[j + 1] = valorActual;

            if (conPasos) {
                System.out.println("Inserta aux: " + valorActual + " en la posición " + (j + 1));
                imprimirArreglo(arreglo);
            }
        }
        return comparaciones;
    }

    public int insercionSinPasos(int[] arreglo, boolean ascendente) {
        int comparaciones = 0;
        int n = arreglo.length;

        for (int i = 1; i < n; i++) {
            int valorActual = arreglo[i];
            int j = i - 1;

            if (ascendente) {
                while (j >= 0 && arreglo[j] > valorActual) {
                    comparaciones++;
                    arreglo[j + 1] = arreglo[j];
                    j--;
                }
            } else {
                while (j >= 0 && arreglo[j] < valorActual) {
                    comparaciones++;
                    arreglo[j + 1] = arreglo[j];
                    j--;
                }
            }

            arreglo[j + 1] = valorActual;
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

    public void imprimirArreglo(int[] arreglo) {
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

        for (int i = 1; i < n; i++) {
            int valorActual = arreglo[i];
            int j = i - 1;

            if (ascendente) {
                while (j >= 0 && arreglo[j] > valorActual) {
                    comparaciones++;
                    j--;
                }
            } else {
                while (j >= 0 && arreglo[j] < valorActual) {
                    comparaciones++;
                    j--;
                }
            }
        }

        return comparaciones;
    }

    public int contarCambios(int[] arreglo, boolean ascendente) {
        int cambios = 0;
        int n = arreglo.length;

        for (int i = 1; i < n; i++) {
            int valorActual = arreglo[i];
            int j = i - 1;

            if (ascendente) {
                while (j >= 0 && arreglo[j] > valorActual) {
                    arreglo[j + 1] = arreglo[j];
                    j--;
                    cambios++;
                }
            } else {
                while (j >= 0 && arreglo[j] < valorActual) {
                    arreglo[j + 1] = arreglo[j];
                    j--;
                    cambios++;
                }
            }

            arreglo[j + 1] = valorActual;
            cambios++; 
        }

        return cambios;
    }
}

