public class parcial5 {
    static final int MAXCOLUM=20;
    static final int MAXFILA=3;
    static final int SEPARADOR=0;
    public static void main(String[] args) {
        int matriz[][]={
        {0,67,67,67,67,67,67,67,67,0,14,0,33,33,33,33,0,5,98,0},
        {0,23,45,45,45,45,23,0,88,88,88,88,88,0,0,0,78,78,0,0},
        {0,0,0,45,45,45,0,45,45,45,45,45,0,45,45,0,45,0,0,0}
        };

    int X=3;
    procesarMatriz(matriz,X);
    mostrarMatriz(matriz);
    }
    public static void procesarMatriz(int[][] matriz,int X) {
    int fila=0;
    int mayorAnterior=-0;
    int ahorro=0;
    int filaMayor=0;
    while (fila<MAXFILA){
        int mayorActual=SuprimirRepeticiones(matriz[fila],X);
        if(mayorActual>mayorAnterior){
            filaMayor=fila;
            mayorAnterior=mayorActual;
        }
        ahorro+=mayorActual;
    fila++;
    }
    System.out.println("el ahorro de almacenamiento es: "+(ahorro*4));
    System.out.println("la fila mas comprimida fue la "+filaMayor);
    }

    public static int SuprimirRepeticiones(int[] arr,int X) {
        int ini=0,fin=-1;
        int ahorro=0;
        while (ini<MAXCOLUM){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                int largo=fin-ini+1;
                if(largo>X && SonIguales(arr,ini,fin)){
                    ComprimirImagen(arr,ini,fin,largo);
                    ahorro+=largo-2;
                    fin=ini+1;
                }
            }
        }
        return ahorro;
    }
    public static void ComprimirImagen(int[] arr,int ini,int fin,int largo){
        arr[ini]=-largo;
        eliminarSecuencia(arr,ini+2,fin);
        
    }
    public static void eliminarSecuencia(int[] arr,int ini,int fin){
        int i=ini;
        while (i<=fin) {
            correrIzquierda(arr,ini);
            i++;
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
    public static void correrIzquierda(int []arr,int pos){
        for(int i=pos;i<MAXCOLUM-1;i++){
            arr[i]=arr[i+1];
        }
    }
    public static boolean SonIguales(int[] arr,int ini,int fin){
        while (ini<fin && arr[ini]==arr[ini+1]){
            ini++;
        }
        return ini==fin;
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
}
