
public class ejercicio11 {
    /*Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada permita encontrar por cada fila la
posición de inicio y fin de la secuencia cuya suma de valores sea
mayor.
 */
    static final int MAXFILA=4;
    static final int MAXCOLUM=20;
    static final int SEPARADOR=0;
    public static void main(String[] args) {
        int[][]matriz={
                        {0,0,8,9,1,0,2,3,4,0,0,0,1,2,3,0,0,0,0,0},
                        {0,0,5,9,8,0,2,9,4,0,0,0,9,8,3,0,0,0,0,0},
                        {0,0,8,7,1,0,2,6,3,0,0,0,3,2,3,0,0,0,0,0},
                        {0,0,6,8,1,0,2,3,4,0,0,0,1,2,3,0,0,0,0,0}
                        };
        procesarMatriz(matriz);
    }

    public static void procesarMatriz(int[][] matriz) {
        int fila=0;
        while (fila<MAXFILA) {
            System.out.println("FILA "+fila);
            encontrarSumatoriaMayor(matriz[fila]);
            
            fila++;
        }
    }
    public static void encontrarSumatoriaMayor(int [] arr){
        int ini=0,fin=-1;
        int mayor=-999999999;
        int inimayor=0;
        int finmayor=0;
        while (ini<MAXCOLUM){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                int sumatoria=SumarSec(arr,ini,fin);
                if(sumatoria>mayor){
                    mayor=sumatoria;
                    inimayor=ini;
                    finmayor=fin;
                }
            }
        }
        System.out.println("la suma mayor se encuentra en la sec, ini: "+inimayor+" fin: "+finmayor+" el Total es "+mayor);
    }
    public static int SumarSec(int []arr,int ini,int fin) {
        int i=ini;
        int sumatoria=0;
        while (i<=fin){
            sumatoria+=arr[i];
            i++;
        }
        return sumatoria;
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
