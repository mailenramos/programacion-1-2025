public class ejparcial10MAI {
    static final int MAX=20;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
        int[] imagen={0,67,67,67,67,67,67,67,67,0,14,0,33,33,33,33,0,5,98,0};
        int X=3;
        comprimirSecIguales(X,imagen);
        mostrarArreglo(imagen);

    }
    public static void comprimirSecIguales(int X,int[]imagen){
        int ini=0,fin=-1;
        int repeticiones=0;
        while (ini<MAX) {
            ini=buscarInicio(imagen,fin+1);
            if(ini<MAX){
                fin=buscarFin(imagen,ini);l,

                repeticiones=Repetidas(imagen,ini,fin);
                if(repeticiones>=X){
                    EliminarSecuencia(imagen,ini,fin);
                    fin=ini-1;
                    InsertarCantRepeticionesNegado(imagen,ini,repeticiones);
                    
                }
            
            }

        }
            
    }
    public static void InsertarCantRepeticionesNegado(int[]M,int ini,int repeticiones) {
        corrimientoDerecha(M,ini);
        M[ini]=-repeticiones;
    }
     public static void EliminarSecuencia(int[]M,int ini,int fin){
        for(int i=ini;i<=fin-1;i++){
            CorrerIzquierda(M,ini);
            }
         }
    public static void CorrerIzquierda(int[]M,int pos){
        int i=pos;
        while(i<MAX-1){
            M[i]=M[i+1];
            i++;
        }
        M[MAX-1]=SEPARADOR;                     
    }
    
    public static void corrimientoDerecha(int[]arr,int pos){
        for(int i=MAX-1; i>pos; i--){
            arr[i]=arr[i-1];
        }
    }

    
    public static int Repetidas(int[] imagen,int ini,int fin) {
        int repeticiones=1;
        int i=ini;
        while (i<=fin && imagen[i]==imagen[i+1]) {
            i++;
            repeticiones++;
        }
        return repeticiones;
      
    }
    public static int buscarInicio(int[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int buscarFin(int[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i=0;i<MAX;i++) {
            System.out.print(arr[i]+"|");
        }
        System.out.println();
    }
}
