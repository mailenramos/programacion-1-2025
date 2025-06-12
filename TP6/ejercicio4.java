public class ejercicio4 {
    /*Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y una posición fila, columna. Con estos datos tendrá que
realizar un corrimiento a derecha (se pierde el último valor en
dicha fila) y colocar el número en la matriz en la posición fila,
columna indicada */
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
    System.out.println("ingrese un numero");
    int numero=Utils.leerInt();
    ProcesarMatriz(matriz,f,pos,numero);
    mostrarMatriz(matriz);
    }
    public static void ProcesarMatriz(int[][] matriz,int f,int pos,int numero) {
        int fila=0;
        while (fila<MAXFILA) {
           if(fila==f){
            procesarArreglo(matriz[fila],pos,numero);
           }
            fila++;
        }
    }
    public static void procesarArreglo(int[] arr,int pos,int numero) {
        if(pos<MAXCOLUM){
            correrDerecha(arr,pos);
            arr[pos]=numero;
        }else{
         System.out.println("la pos "+pos+" no existe");
        }
         
    }
    public static void correrDerecha(int []arr,int pos){
        for(int i=MAXCOLUM-1;i>pos;i--){
            arr[i]=arr[i-1];
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
