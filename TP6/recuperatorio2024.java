

public class recuperatorio2024 {
    final static int M = 20;
    final static int N = 3;
    final static int R = 2;
    final static int MAXB = 3;

    public static void main(String[] args) {
        char[][] matrizV = {{'x', 't', 'a', 'C', 'M', 'O', 't', 'a', 'a', 't', 'O', 'C', 't', 't', 'a', 'O', 'M', 'C', 't', 'x'},
                {'x', 'r', 'r', 'r', 'C', 'C', 'O', 'O', 'r', 'r', 'C', 'r', 'G', 'G', 'G', 'r', 'r', 'x', 'x', 'x'},
                {'x', 'm', 'G', 'm', 'h', 'h', 'L', 'G', 'G', 'O', 'h', 'h', 'm', 'm', 'O', 'B', 'M', 'C', 'x', 'x'}
        };
        char[] arregloB = {'C', 'L', 'O'};

        procesarMatriz(matrizV, arregloB);
        MostrarMatriz(matrizV);

    }
    public static void correr_a_izquierda(char [] arrV, int ini) {
        for (int i = ini; i < M - 1; i++) {
            arrV[i] = arrV[i + 1];
        }
    }

    public static void procesarMatriz(char[][] matrizV, char[] arregloB) {
        int contMalezasEliminadas = 0;
        for (int i = 0; i < N; i++) {
            contMalezasEliminadas += aplicarLaser(matrizV[i], arregloB, R);
        }
        System.out.println("la cantidad de malezas eliminadas es: " + contMalezasEliminadas);
    }

    public static int aplicarLaser(char[] arrV, char[] arrB, int R) {
        int contMalezasEliminadas = 0;
        int ini = 0;
        int fin = -1;

        while (ini < M) {
            ini = buscarInicio(arrV, fin + 1);
            if (ini < M) {
                fin = buscarFin(arrV, ini);
                if (fin - ini + 1 > R) {
                    contMalezasEliminadas+=eliminarMalezas(arrV, ini, fin, arrB);
                    fin -= contMalezasEliminadas;
                }
            }
                //    int cantidad = eliminarMalezas(arrV, ini, fin, arrB);
                //    fin = fin - cantidad;
                //    contMalezasEliminadas += cantidad;
                // }
           // }
        }
        return contMalezasEliminadas;
    }


    public static int eliminarMalezas(char[] arrV, int ini, int fin, char[] arrB) {
        int cantidad = 0;
        while (ini <= fin) {
            if (esBeneficiosa(arrV[ini], arrB)) {
                ini++;
            } else {
                correr_a_izquierda(arrV, ini);
                fin--;
                cantidad++;
            }
        }
        return cantidad;
    }

    public static boolean esBeneficiosa(char c, char[] arregloB) {
        int i = 0;
        while (i < MAXB && c != arregloB[i])
            i++;

        return i < MAXB; // preguntar al chat
    }

    public static boolean esMinuscula(char c) {
    return c >= 'a' && c <= 'z';
    }

    public static int buscarInicio(char [] arrV, int ini) {
        while (ini < M && esMinuscula(arrV[ini])) {
            ini++;
        }
        return ini;
    }
    public static int buscarFin(char[] arrV, int ini) {
        while (ini < M && !esMinuscula(arrV[ini])) {
            ini++;
        }
        return ini-1;
    }

public static void MostrarMatriz(char[][] matriz) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++)
            System.out.print(matriz[i][j] + " | ");
        System.out.println();
    }
}

}



