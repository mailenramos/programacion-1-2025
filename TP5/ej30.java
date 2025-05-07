public class ej30 {
/*Hacer un programa que reemplace de un arreglo A todas las
ocurrencias de una secuencia patrón dada en un arreglo P, por la
secuencia contenida en el arreglo R de igual tamaño. */
        static final int MAX = 20;
        static final int MAXPATRON = 2; 
        public static void main(String[] args) {
            int[] arrA = {0, 1, 2, 0, 5, 2, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 0, 0, 0};
            int[] arrP = {5,6};
            int[] arrR = {9,9};
    
            mostrarArregloInt(arrA);
            procesar(arrA,arrP,arrR);
            mostrarArregloInt(arrA);
        }
    
        public static void procesar(int[] arrA,int[]arrP,int[]arrR) {
            int ini = 0, fin = -1;
            while (ini < MAX) {
                ini = buscarIni(arrA, fin + 1);
                if (ini < MAX) {
                    fin = buscarFin(arrA, ini);
                    if(verificarCoincidencia(arrA,arrP,ini,fin)){
                        reemplazarSec(arrA,arrR,ini,fin);
                    }
                }
            }
        }
        public static void reemplazarSec(int[]arrA,int[]arrR,int ini,int fin){
            int i=0;
            while(ini<=fin){
                arrA[ini]=arrR[i];
                i++;
                ini++;
            }
        }
        public static boolean verificarCoincidencia(int[]arr,int[]patron,int ini,int fin){
            int contador =0;
            for(int i=0;i<MAXPATRON;i++){
                if(patron[i]==arr[ini]){
                    contador++;
                    ini++;
                }
            }
            return contador==MAXPATRON;
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


