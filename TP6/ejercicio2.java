public class ejercicio2 {static final int MAXFILA=5;
    static final int MAXCOLUM=10;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
    int [][]matriz= {{0,2,3,4,0,0,9,9,0,0},
                    {0,2,8,0,0,0,7,7,0,0},
                    {0,1,3,9,0,0,1,1,0,0},
                    {0,9,6,0,0,0,9,9,0,0},
                    {0,2,3,4,0,0,8,9,0,0}};
    ProcesarMatriz(matriz);
    }
    
    public static void ProcesarMatriz(int[][] matriz) {
        int fila=0;
        int pares=0;
        while (fila<MAXFILA) {
            pares+=obtenerParesArr(matriz[fila]);
            fila++;
        }
        System.out.println("la cantidad total de pares es: "+pares);
    }
    public static int obtenerParesArr(int[] arr) {
        int ini=0,fin=-1;
        int pares=0;
        while (ini<MAXCOLUM) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                pares+=ObtenerPares(arr,ini,fin);
            }
        };
        return pares;   
    }
    public static int ObtenerPares(int[] arr,int ini,int fin){
        int pares=0;
        int i=ini;
        while (i<=fin){
            if(arr[i]%2==0){
                pares++;
            }
            i++;
        }
        return pares; 
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
