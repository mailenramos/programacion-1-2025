/*Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos.*/
public class ej29 {
    static final int MAX = 20;
    static final int MAXPATRON = 2; 
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 5, 2, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 0, 0, 0};

        mostrarArregloInt(arr);
        procesar(arr);
        mostrarArregloInt(arr);
    }

    public static void procesar(int[] arr) {
        int inicio = 0, fin = -1;
        while (inicio < MAX) {
            inicio = buscarIni(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio);
                if(esAscendente(arr,inicio,fin)){
                    eliminarSec(arr,inicio,fin);
                    fin = inicio - 1;
                }
        }
    }}
    
    public static boolean esAscendente(int[] arr, int ini, int fin) {
        if (ini >= fin) {
            return false;
        }
    
        while (ini < fin) {
            if (arr[ini] >= arr[ini + 1]) {
                return false;
            }
            ini++;
        }
        return true;
    }
    public static void eliminarSec(int[] arr,int ini,int fin) {
        int largo = fin - ini + 1;

        for(int i=0;i<largo;i++){
            CorrerIzquierda(arr,ini);
        }
    }
    public static void CorrerIzquierda(int[] arr,int pos) {
        while (pos<MAX-1) {
            arr[pos]=arr[pos+1];
            pos++; 
        }
    }
    public static int buscarTamanio(int ini,int fin) {
        int tamanio=0;
        while (ini<=fin) {
            tamanio++;  
            ini++;  
        }
        return tamanio;
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
