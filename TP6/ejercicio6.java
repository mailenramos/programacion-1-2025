public class ejercicio6 {
    /* Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y elimine todas las ocurrencia de número en la matriz si
existe. Mientras exista (en cada iteración tiene que buscar la
posición fila y columna) tendrá que usar dicha posición para
realizar un corrimiento a izquierda (quedarán tantas copias de la
última posición de cada fila como cantidad de ocurrencias del
número). Tener en cuenta, como se hizo en arreglos, si el
elemento a eliminar es el último de alguna fila de la matriz. */
    static final int MAXFILA=5;
    static final int MAXCOLUM=10;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
    int [][]matriz= {{0,2,3,4,0,0,9,9,0,0},
                    {0,2,8,0,0,0,7,7,0,0},
                    {0,1,3,9,0,0,1,1,0,0},
                    {0,9,6,0,0,0,9,9,0,0},
                    {0,2,3,4,0,0,9,9,0,0}};
    System.out.println("ingrese un numero a eliminar en la matriz");
    int numero =Utils.leerInt();
    procesarMatriz(matriz,numero);
    mostrarMatriz(matriz);
    }
    public static void procesarMatriz(int[][] matriz,int numero) {
        int fila=0;
        while (fila<MAXFILA) {
            EliminarCoincidencias(matriz[fila],numero);
            fila++;
        }
    }
    public static void EliminarCoincidencias(int[]arr,int numero) {
        int ini=0,fin=-1;

        while (ini<MAXCOLUM) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                int pos=buscarCoincidencias(arr,ini,fin,numero);
                if(pos<=fin){
                    correrIzquierda(arr,pos);
                    fin=ini-1;
                }    
            }
        }        
    }
    public static int buscarCoincidencias(int[] arr,int ini,int fin,int numero) {
        int i=ini;
        while (i<=fin && arr[i]!=numero) {
            i++;
        }
        return i;
    }
    public static int buscarInicio(int[]arr, int pos) {
        while (pos<MAXCOLUM && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
     public static int buscarFin(int[]arr, int pos) {
        while (pos<MAXCOLUM && arr[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
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

