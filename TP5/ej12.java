public class ej12{
    final static int MAXA=3, MAXB=2;
    /*//Dado dos arreglos de números enteros: un arreglo A de tamaño MAXA
        // y un arreglo B de tamaño MAXB con números entre 0 y MAXA-1

        //, determinar la suma de los elementos del arreglo A 
        //  cuyas posiciones son indicadas por el arreglo B. 
        Por ejemplo, dado
        A={3,6,31,9}, MAXA=3 y B={0,2} con MAXB=2 el sistema deberá
        informar: 34 */
    public static void main(String[] args){
        int[]A ={3,6,31,9};
        int[]B ={0,3};

        int suma=sumarPosiciones(A,B);

        System.out.println("El resultado de sumar las posiciones indicadas es: "+suma);
    }

    public static int sumarPosiciones(int[]A,int[]B){
        int suma=0;
        for(int i =0;i<MAXB;i++){
            suma+=A[ B[i] ];
        }
        return suma;
    }
}