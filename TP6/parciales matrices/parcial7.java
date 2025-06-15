public class parcial7 {
    static final int MAFILA = 3;
    static final int MAXCOLUM = 20;
    static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int matriz[][] = {
            {0, -8, 67, 0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 25, 25, 0, -5, 3, 0, 25, 44, 44, 0, -4, 1, 0, 0, 0, 0, 0, 0},
            {0, 44, 44, 44, 0, -7, 15, 0, -4, 9, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        procesarMatriz(matriz);
        mostrarMatriz(matriz);
    }

    public static void procesarMatriz(int[][] matriz) {
        int fila = 0;
        int filaMayor = 0;
        int mayorAnterior = -0;
        int descomprimidos = 0;

        while (fila < MAFILA) {
            int mayorActual = descomprimirFila(matriz[fila]);
            if (mayorActual > mayorAnterior) {
                filaMayor = fila;
                mayorAnterior = mayorActual;
            }
            descomprimidos += mayorActual;
            fila++;
        }

        System.out.println("La cantidad total de píxeles descomprimidos es: " + (descomprimidos ));
        System.out.println("La fila que tiene más descomprimidos fue la fila " + filaMayor);
    }

    public static int descomprimirFila(int[] arr) {
        int ini = 0, fin = -1;
        int descomprimidos = 0;
        int cantidadDescomprimidos=0;
        while (ini < MAXCOLUM) {
            ini = buscarInicio(arr, fin + 1);
            if (ini < MAXCOLUM) {
                fin = buscarFin(arr, ini);
                if (encuentraCompresion(arr, ini, fin)) {
                    cantidadDescomprimidos=-arr[ini];
                    int descompresiones = descomprimirSecuencia(arr, ini, fin,cantidadDescomprimidos-2);
                    fin = ini + descompresiones + 1;  
                    descomprimidos += cantidadDescomprimidos;  
                } 
            }
        }
        return descomprimidos;
    }

    public static int descomprimirSecuencia(int[] arr, int ini, int fin,int largo) {
        int i = 0;
        while (i < largo) {
            correrDerecha(arr, ini+1);
            i++;
        }
        arr[ini]=arr[ini+1];
        return largo; 
    }

    public static void correrDerecha(int[] arr, int pos) {
        for (int i = MAXCOLUM - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static boolean encuentraCompresion(int[] arr, int ini, int fin) {
        while (ini <= fin && arr[ini] > 0) {
            ini++;
        }
        return ini < fin;
    }

    public static int buscarInicio(int[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int fila = 0; fila < MAFILA; fila++) {
            mostrarArreglo(matriz[fila]);
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < MAXCOLUM; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}