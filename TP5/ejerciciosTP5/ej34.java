public class ej34 {
    static final int MAX = 20;
    static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        char[] arrA = {' ', 'a', 'b', ' ', 'h', ' ', ' ', 'a', 'b', ' ', 'a', 'b', ' ', 'r', 't', ' ', 'r', 'e', ' ', ' '}; 
        char[] arrB = {' ', 'g', 'j', ' ', 'f', 'f', 'f', ' ', 'b', ' ', 'r', 't', ' ', 'r', 't', ' ', 'r', 'e', ' ', ' '}; 

        System.out.print("Arreglo A (antes): "); mostrarArregloChar(arrA);
        System.out.print("Arreglo B        : "); mostrarArregloChar(arrB);

        procesar(arrA, arrB);

        System.out.print("Arreglo A (final): "); mostrarArregloChar(arrA);
    }

    // Método principal que reemplaza la secuencia más repetida de A con la secuencia con más repetidos de B
    public static void procesar(char[] arrA, char[] arrB) {
        // Simulan los métodos preexistentes del enunciado
        int iniA = obtenerInicioSecuenciaMasRepetida(arrA);
        int iniB = obtenerInicioSecuenciaConMasCaracteresRepetidos(arrB);

        int finA = buscarFin(arrA, iniA);
        int finB = buscarFin(arrB, iniB);

        int largoA = finA - iniA + 1;
        int largoB = finB - iniB + 1;
        int desplazamiento = largoB - largoA;

        // Desplazar hacia la derecha si B es más larga
        if (desplazamiento > 0) {
            for (int i = MAX - 1; i >= finA + 1 + desplazamiento; i--) {
                arrA[i] = arrA[i - desplazamiento];
            }
        }

        // Copiar la secuencia de B en A
        for (int i = 0; i < largoB && iniA + i < MAX; i++) {
            arrA[iniA + i] = arrB[iniB + i];
        }

        // Si la nueva es más corta, completar con separadores
        if (desplazamiento < 0) {
            for (int i = iniA + largoB; i <= finA; i++) {
                arrA[i] = SEPARADOR;
            }
        }
    }

    // Simulación de método del enunciado (solo encabezado)
    public static int obtenerInicioSecuenciaMasRepetida(char[] arr) {
        // Supongamos que es la secuencia "a b" que comienza en el índice 1
        return 1;
    }

    // Simulación de método del enunciado (solo encabezado)
    public static int obtenerInicioSecuenciaConMasCaracteresRepetidos(char[] arr) {
        // Supongamos que es "f f f" que empieza en el índice 4
        return 4;
    }

    public static int buscarFin(char[] arr, int ini) {
        while (ini < MAX && arr[ini] != SEPARADOR) {
            ini++;
        }
        return ini - 1;
    }

    public static void mostrarArregloChar(char[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}