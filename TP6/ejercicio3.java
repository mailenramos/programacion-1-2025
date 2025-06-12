/*Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario una posición
fila, columna y realice un corrimiento a izquierda. */
public class ejercicio3 {
    static final int MAXFILA=5;
    static final int MAXCOLUM=10;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
    int [][]matriz= {{0,2,3,4,0,0,9,9,0,0},
                    {0,2,8,0,0,0,7,7,0,0},
                    {0,1,3,9,0,0,1,1,0,0},
                    {0,9,6,0,0,0,9,9,0,0},
                    {0,2,3,4,0,0,8,9,0,0}};
    System.out.println("ingrese una fila");
    int f=Utils.leerInt();
    System.out.println("ingrese una posicion");
    int pos=Utils.leerInt();
    ProcesarMatriz(matriz,f,pos);
    mostrarMatriz(matriz);
    }
    public static void ProcesarMatriz(int[][] matriz,int f,int pos) {
        int fila=0;
        while (fila<MAXFILA) {
           if(fila==f){
            procesarArreglo(matriz[fila],pos);
           }
            fila++;
        }
    }
    public static void procesarArreglo(int[] arr,int pos) {
        correrIzquierda(arr,pos);  
    }
    public static void correrIzquierda(int []arr,int pos){
        for(int i=pos;i<MAXCOLUM-1;i++){
            arr[i]=arr[i+1];
        }
    }
    public static void mostrarMatriz(int [][]matriz){
        for(int fila =0;fila<MAXFILA;fila++){
            mostrarArreglo(matriz[fila]);
        }
    }
    public static void mostrarArreglo(int[] arr) {
        for(int i=0;i<MAXCOLUM;i++){
            System.out.print(arr[i]+"|");
        }
        System.out.println("");
        
    }
    
}
