/*Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N 
 */
public class ej27 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 5, 6, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 0, 0, 0};
        System.out.println("ingrese el largo de la sec q desea eliminar");
        int N=Utils.leerInt();
        mostrarArregloInt(arr);
        procesar(arr,N);
        mostrarArregloInt(arr);
    }

    public static void procesar(int[] arr,int N) {
        int inicio = 0, fin = -1,tamanio=0;

        
        while (inicio < MAX) {
            inicio = buscarIni(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio);
                tamanio=fin-inicio+1;
                if(tamanio==N){
                    eliminarSec(arr,inicio,fin);
                    fin = inicio - 1;
                }

            }
        }
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
