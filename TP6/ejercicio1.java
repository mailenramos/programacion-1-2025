/* Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, invierta el orden del contenido
por fila. Este intercambio no se debe realizar de manera explícita,
hay que hacer un método que incluya una iteración de
intercambio.
 */
public class ejercicio1 {
    static final int MAXFILA=5;
    static final int MAXCOLUM=10;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
    int [][]matriz= {{0,2,3,4,0,0,9,9,0,0},
                    {0,2,8,0,0,0,7,7,0,0},
                    {0,1,3,9,0,0,1,1,0,0},
                    {0,9,6,0,0,0,9,9,0,0},
                    {0,2,3,4,0,0,9,9,0,0}};
    invertirMatriz(matriz);
    mostrarMatriz(matriz);
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
    public static void invertirMatriz(int[][] matriz) {
        int fila=0;
        while (fila<MAXFILA) {
            invertirArreglo(matriz[fila]);
            fila++;
        }
    }
    public static void invertirArreglo(int[] arr) {
        int ini=0,fin=-1;
        while (ini<MAXCOLUM) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                InvertirSec(arr,ini,fin);
            }
        }
        
    }
    public static void InvertirSec(int []arr,int ini,int fin){
        int i=ini;
        int j=fin;
        int aux=0;
        int largo=fin-ini+1;

        while (i<=largo/2) {
            aux=arr[i];
            arr[i]=arr[j];
            arr[j]=aux;
            j--;
            i++;
        }
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
