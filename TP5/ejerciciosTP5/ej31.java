public class ej31 {
    /*
Hacer un programa que invierta el orden de la última secuencia
en un arreglo.
     */
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 5, 6, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 9, 2, 0};
        mostrarArregloInt(arr);
        procesar(arr);
        mostrarArregloInt(arr);
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

        // Si hay al menos dos secuencias, mostramos la última
        if (contadorSecuencias > 1) {
            int inicioUltima = inicios[contadorSecuencias - 1];
            int finUltima = fines[contadorSecuencias - 1];
            System.out.println("inicio ult. sec: "+inicioUltima+" fin: "+finUltima);
            invertirSecuencia(arr,inicioUltima,finUltima);
        }
    }
    public static void invertirSecuencia(int[]arr,int ini,int fin){
        int aux=0;
        while(ini < fin){
            aux=arr[fin];
            arr[fin]=arr[ini];
            arr[ini]=aux;
            ini++;
            fin--;
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
    public static void mostrarArregloInt(int[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
