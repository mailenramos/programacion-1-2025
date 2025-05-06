public class ej24 {
    static final int MAX = 20;
    static final int SEPARADOR = 0;
/*
Devuelva la posición de inicio y fin de la
secuencia cuya suma del contenido sea mayor.
*/
    public static void main(String[] args) {
        int[]arr={0,1,2,3,0,4,5,0,4,0,2,4,6,8,0,8,9,9,9,0};
        mostrarArregloInt(arr);
        mostrarSecuenciaMayorSuma(arr);
    }

    public static void mostrarSecuenciaMayorSuma(int[]arr){
        int ini=0,fin=-1, suma =0,sumaMayor=0;
        int iniMayorSuma=0,finMayorSuma=0;

        while(ini<MAX){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAX){
                fin=buscarFin(arr,ini);
                suma=obtenerSumaSecuencia(arr,ini,fin);
                if(suma>sumaMayor){
                    sumaMayor=suma;
                    iniMayorSuma=ini;
                    finMayorSuma=fin;
                }
            }
        }
        System.out.println("La secuencia cuya suma es mayor comienza en: \n"+iniMayorSuma+" y termina en: "+finMayorSuma);
    }
    public static int obtenerSumaSecuencia(int[]arr,int ini,int fin){
        int suma = 0;
        while(ini<=fin){
            suma+=arr[ini];
            ini++;
        }
        return suma;
    }
    public static int buscarInicio(int[]arr,int pos){
        while(pos<MAX && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin(int[]arr,int pos){
        while(pos<MAX && arr[pos]!=0){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArregloInt(int[]arr){
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
