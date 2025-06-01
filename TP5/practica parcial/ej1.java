public class ej1{
    static final int MAX=20;
    static final int SEPARADOR=0;
    public static void main(String[] args) {
        int [] arr={0,0,67,67,67,0,2,2,2,0,14,0,33,33,33,33,0,5,5,0};
        int X=2;
        mostrarArreglo(arr);
        comprimirImagen(arr,X);
        mostrarArreglo(arr);
    }
    public static void comprimirImagen(int[] arr,int X) {
        int ini=0, fin=-1;
        while (ini<MAX) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAX){
                fin=buscarFin(arr,ini);
                int largo=fin-ini+1;
                if(largo>X && SonTodosIguales(arr,ini,fin)){
                    ComprimirSecuencia(arr,ini,fin,largo);
                    fin=ini-1;
                }

            }
            
        }
        
    }
    public static void ComprimirSecuencia(int []arr,int ini,int fin,int repeticiones) {
        int i = ini;
        while(i<fin){
            correrIzquierda(arr,ini);
            i++;
        }
        correrDerecha(arr,ini);
        arr[ini]=-repeticiones;
    }

    public static void correrIzquierda(int[]arr, int ini){
        for(int i=ini; i<MAX-1; i++){
            arr[i]=arr[i+1];
        }
    }

    public static void correrDerecha(int[]arr,int ini){
        for(int i=MAX-1;i>ini;i--){
            arr[i]=arr[i-1];
        }

    }

    public static boolean SonTodosIguales(int []arr,int ini,int fin){
        int i=ini;
        while (i<fin && arr[i]==arr[i+1]){
            i++;            
        }
        return i==fin;
    }

    public static int buscarInicio(int[]arr,int pos){
        int i=pos;
        while (i<MAX && arr[i]==SEPARADOR){
            i++;    
        }
        return i;
    }
    public static int buscarFin(int[]arr,int pos){
        int i=pos;
        while (i<MAX && arr[i]!=SEPARADOR) {
            i++;
        }
        return i-1;
    }
    public static void mostrarArreglo(int[] arr) {
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+"|");
        }
        System.out.println();
        
    }
}
