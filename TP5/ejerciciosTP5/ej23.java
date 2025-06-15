public class ej23 {
    static final int MAX = 10;
    static final int SEPARADOR = 0;
/*
Hacer un programa que devuelva la posición de inicio y fin de la
primera secuencia de números distinta de ceros
 */
    public static void main(String[] args) {
        int[]arr={0,1,2,3,0,4,5,0,4,0};
        MostrarIniYFin(arr);
        mostrarArregloInt(arr);
    }

    public static void MostrarIniYFin(int[]arr){
        int ini=0, fin=-1;

            ini=buscarInicio(arr,fin+1);
            if(ini<MAX){
                fin=buscarFin(arr,ini);
                //ya tengo la secuencia
                System.out.println("El inicio de la secuencia es: \n"+ini+" y el fin es: "+fin);
            } 
    }
    public static int buscarInicio(int[]arr,int pos){
        while(pos<MAX && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
    public static int buscarFin(int[]arr,int pos){
        while(pos<MAX && arr[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArregloInt(int[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }

    
}
