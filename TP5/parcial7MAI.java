public class parcial7MAI {
    static final int MAX = 25;
    static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        char[] arrI = {' ', ' ', 'A', 'B', '9', '8', '7', 'E', 'X', ' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', 'F', 'O', 'R', '0', '0', '1', ' '};
        char[] arrE = {' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', 'P', 'R', 'G', '0', '1', '0', ' ', 'A', 'B', '9', '8', '7', 'E', 'X', ' ', ' '};
        char[] arrNoE = new char[MAX];
        char[] arrNoI = new char[MAX];

        registrarPatentes(arrE, arrI, arrNoE, arrNoI);

        System.out.println("Patentes que ingresaron pero NO egresaron:");
        mostrarArreglo(arrNoE);
        System.out.println("Patentes que egresaron pero NO ingresaron:");
        mostrarArreglo(arrNoI);
    }

    public static void registrarPatentes(char[] arrE, char[] arrI, char[] arrNoE, char[] arrNoI) {
        int ini = 0, fin = -1;
        int posNoE = 0;

        while (ini < MAX) {
            ini = buscarInicio(arrI, fin + 1);
            if (ini < MAX) {
                fin = buscarFin(arrI, ini);
                if (!existePatente(arrI, ini, fin, arrE)) {
                    posNoE = copiarPatente(arrI, ini, fin, arrNoE, posNoE);
                }
            }
        }

        ini = 0;
        fin = -1;
        int posNoI = 0;

        while (ini < MAX) {
            ini = buscarInicio(arrE, fin + 1);
            if (ini < MAX) {
                fin = buscarFin(arrE, ini);
                if (!existePatente(arrE, ini, fin, arrI)) {
                    posNoI = copiarPatente(arrE, ini, fin, arrNoI, posNoI);
                }
            }
        }
    }

    public static boolean existePatente(char[] arrFuente, int iniF, int finF, char[] arrBusqueda) {
        int ini = 0, fin = -1;

        while (ini < MAX) {
            ini = buscarInicio(arrBusqueda, fin + 1);
            if (ini < MAX) {
                fin = buscarFin(arrBusqueda, ini);
                if (compararPatentes(arrFuente, iniF, finF, arrBusqueda, ini, fin)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean compararPatentes(char[] arr1, int ini1, int fin1, char[] arr2, int ini2, int fin2) {
        if ((fin1 - ini1) != (fin2 - ini2)) 
        return false;

        for (int i = 0; i <= fin1 - ini1; i++) {
            if (arr1[ini1 + i] != arr2[ini2 + i]) return false;
        }
        return true;
    }

    public static int copiarPatente(char[] origen, int ini, int fin, char[] destino, int pos) {
        if (pos < MAX) {
            for (int i = ini; i <= fin && pos < MAX; i++) {
                destino[pos++] = origen[i];
            }
            if (pos < MAX) {
                destino[pos++] = SEPARADOR;
            }
        }
        return pos;
    }

    public static int buscarInicio(char[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int buscarFin(char[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }

    public static void mostrarArreglo(char[] arr) {
        for (char c : arr) {
            System.out.print(c);
        }
        System.out.println();
    }
}
