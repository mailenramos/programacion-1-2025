public class ejercicio5 {
    /*Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y elimine la primera ocurrencia de número en la matriz (un
número igual) si existe. Para ello tendrá que buscar la posición y si
está, realizar un corrimiento a izquierda y no continuar buscando */
     static final int MAXFILA=5;
    static final int MAXCOLUM=10;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
    int [][]matriz= {{0,2,3,4,0,0,9,9,0,0},
                    {0,2,8,0,0,0,7,7,0,0},
                    {0,1,3,9,0,0,1,1,0,0},
                    {0,9,6,0,0,0,9,9,0,0},
                    {0,2,3,4,0,0,9,9,0,0}};
    
    System.out.println("ingrese un numero");
    int numero=Utils.leerInt();
    procesarMatriz(matriz,numero);
    mostrarMatriz(matriz);
    }
    
    public static void procesarMatriz(int[][] matriz,int numero) {
        int fila=0;
        boolean encontro=false;

        while (fila<MAXFILA && !encontro) {
            if(encuentraOcurrencia(matriz[fila],numero))
                encontro=true; 
        fila++;
        }
        if(encontro==false){
            System.out.println("el numero "+numero+" no fue encontrado");
        }
    }
    public static boolean encuentraOcurrencia(int[] arr,int numero) {
        int ini=0,fin=-1;
        boolean encontro=false;
        while (ini<MAXCOLUM &&!encontro) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                
                int pos=encuentraNumero(arr,ini,fin,numero);
                if(pos<=fin){
                    correrIzquierda(arr,pos);
                    encontro=true;
                }
            }
        }
      return encontro;   
    }
    public static void correrIzquierda(int []arr,int pos){
        for(int i=pos;i<MAXCOLUM-1;i++){
            arr[i]=arr[i+1];
        }
    }
    public static int encuentraNumero(int[]arr,int ini,int fin,int numero){
        int i=ini;
        while (i<=fin && arr[i]!=numero){
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
