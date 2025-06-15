public class ej25 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 5, 6, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 0, 0, 0};
        procesar(arr);
    }

    public static void procesar(int[] arr) {
        int inicio = 0, fin = -1;
        int contadorSecuencias = 0;
        int[] inicios = new int[MAX];
        int[] fines = new int[MAX];

        // Guardamos las posiciones de inicio y fin de todas las secuencias
        while (inicio < MAX) {
            inicio = buscarIni(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio);
                inicios[contadorSecuencias] = inicio;
                fines[contadorSecuencias] = fin;
                contadorSecuencias++;
            }
        }

        // Si hay al menos dos secuencias, mostramos la anteúltima
        if (contadorSecuencias >= 2) {
            int inicioAnteultima = inicios[contadorSecuencias - 2];
            int finAnteultima = fines[contadorSecuencias - 2];
            System.out.println("La anteúltima secuencia empieza en: "+ inicioAnteultima + " y termina en: " + finAnteultima);
        } else {
            System.out.println("No hay suficientes secuencias para encontrar la anteúltima.");
        }
    }

    public static int buscarIni(int[] arr, int ini) {
        while (ini < MAX && arr[ini] == 0) {
            ini++;
        }
        return ini;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini < MAX && arr[ini] != 0) {
            ini++;
        }
        return ini - 1;
    }
}
