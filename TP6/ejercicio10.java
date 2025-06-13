public class ejercicio10 {
    /*Hacer un programa que dada la matriz de secuencias de
    enteros definida y precargada, permita obtener a través de
    métodos la posición de inicio y la posición de fin de la secuencia
    ubicada a partir de una posición entera y una fila, ambas
    ingresadas por el usuario. Finalmente, si existen imprima por
    pantalla ambas posiciones obtenidas.
 */ static final int MAXFILA=4;
    static final int MAXCOLUM=20;
    static final int SEPARADOR=0;
    public static void main(String[] args) {
        int[][]matriz={
                        {0,0,8,9,1,0,2,3,4,0,0,0,1,2,3,0,0,0,0,0},
                        {0,0,5,9,8,0,2,9,4,0,0,0,9,8,3,0,0,0,0,0},
                        {0,0,8,7,1,0,2,6,3,0,0,0,3,2,3,0,0,0,0,0},
                        {0,0,6,8,1,0,2,3,4,0,0,0,1,2,3,0,0,0,0,0}
                        };
    System.out.println("ingrese una fila");
    int f= Utils.leerInt();
    System.out.println("ingrese una posicion");
    int pos=Utils.leerInt();
    procesarMatriz(matriz,f,pos);                  

    }
    public static void procesarMatriz(int [][]matriz, int f, int pos) {
    int fila = 0;
    boolean encontrada = false;

    while (fila < MAXFILA && !encontrada) {
        if (fila == f) {
            ubicar(matriz[fila], pos);
            encontrada = true;
        }
        fila++;
    }
    if (!encontrada) {
        System.out.println("La fila " + f + " no se encontró");
    }
}
    public static void ubicar(int[]arr,int pos){
        int ini=0,fin=-1;
        boolean ubico=false;
        while (ini<MAXCOLUM && !ubico){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                
                int posicion=existeposEnSec(arr,ini,fin,pos);

                if(posicion<=fin){
                    System.out.println("existe una sec, ini: "+ini+" fin: "+fin);
                    ubico=true;
                }  
            }  
        }
        if(!ubico){
            System.out.println("no se encuentra una secuencia valida en la pos "+pos);
        }
        
    }
    public static int existeposEnSec(int []arr,int ini,int fin ,int pos) {
        int i=ini;
        while (i<=fin && i!=pos) {
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
}
