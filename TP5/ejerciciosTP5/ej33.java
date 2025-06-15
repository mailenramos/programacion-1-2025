public class ej33 {
    static final int MAX = 20;
    /* 
Dado un arreglo y un número entero ingresado, 
copie de forma continua las secuencias de tamaño igual al número ingresado en otro arreglo de iguales características 
e inicializado con 0. 
La copia en este último arreglo deben comenzar desde el principio del mismo.
    */
    public static void main(String[] args) {
        int[]arr={0,1,2,0,0,3,4,0,0,4,5,3,3,0,5,6,0,7,8,0}; 
        int[]arrB = new int[MAX];
        int tamanio=0;
        System.out.println("Ingrese el tamaño");
        tamanio=Utils.leerInt();
        mostrarArregloInt(arr);
        procesar(arr,arrB,tamanio);
        mostrarArregloInt(arrB);
    }

    public static void procesar(int[]arr,int[]arrB,int tamanio){
        int ini=0,fin=-1,largoSec=0,ultimaPosArrB=0;

            while(ini<MAX){
                ini=buscarIni(arr,fin+1);
                if(ini<MAX){
                    fin=buscarFin(arr,ini);
                    largoSec=fin-ini+1;
                    if(largoSec==tamanio){
                        ultimaPosArrB=copiarSecuenciaEnArreglo(arr,arrB,ini,fin,ultimaPosArrB);
                    }
                }

            }
    }
    public static int copiarSecuenciaEnArreglo(int[]arr,int[]ArrB,int ini, int fin,int ultimaPosArrB){
            while(ini<=fin){
                ArrB[ultimaPosArrB]=arr[ini];
                ini++;
                ultimaPosArrB++;
            }
        return ultimaPosArrB;
    }
    public static void buscarSecuenciaEnPos(int[]arr,int ini,int fin,int pos){
        for (int i=ini;i<fin;i++){
            
        }
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


