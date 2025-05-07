/*
Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo.
*/
public class ej28 {
    static final int MAX = 20;
    static final int MAXPATRON = 2; 
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 5, 6, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 0, 0, 0};
        int[]patron={5,6};

        System.out.println("ingrese el largo de la sec q desea eliminar");
        mostrarArregloInt(arr);
        procesar(arr,patron);
        mostrarArregloInt(arr);
    }

    public static void procesar(int[] arr, int[] patron) {
        int inicio = 0, fin = -1,tamanio=0;
        while (inicio < MAX) {
            inicio = buscarIni(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio);
                tamanio=fin-inicio+1;
                if(tamanio==MAXPATRON){
                    if(verificarCoincidencia(arr,patron,inicio,fin)){
                    eliminarSec(arr,inicio,fin);
                    fin = inicio - 1;
                }
                }

            }
        }
    }
    public static boolean verificarCoincidencia(int[]arr,int[]patron,int ini,int fin){
        int contador =0;
        for(int i=0;i<MAXPATRON;i++){
            if(patron[i]==arr[ini]){
                contador++;
                ini++;
            }
        }
        return contador==MAXPATRON;
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
