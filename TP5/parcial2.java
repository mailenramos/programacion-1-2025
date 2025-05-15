public class parcial2 {
    static final int MAXM=20, MAXC=5;
    public static void main(String[] args) {
        int[]C={4,3,8,6,2,12,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[]M={2,3,5,6,12};
        int i =0;
        mostrarArreglo(C, i);
        mostrarArreglo(M, i);
        while(i<MAXC && i!=0){

            if( esAsignable(C[i],M) ){
                borrarCliente(C,i);
                
            }
            i++;
        }
        System.out.println("-----------");
        mostrarArreglo(C, MAXC);
        mostrarArreglo(M, MAXM);
        
    }
    public static void borrarCliente(int[]C,int i){
        correrIzquierda(C, i);
    }
    public static void correrIzquierda(int[]arr,int pos){
        
        for(int i = pos;i<MAXC-1;i++){
            arr[i]=arr[i+1];
        }
    }

    public static boolean esAsignable(int cantClientes,int[]M){
        boolean encontro = false;
        int i =0;
        while(i<MAXM){
            if(cantClientes<=M[i]){
                asignarMesa(i,M);
                encontro=true;
            }
            i++;
        }
        
        return encontro;
    }

public static void asignarMesa(int pos, int[]M ){
    M[pos]=-M[pos];

}

public static void mostrarArreglo(int[]arr,int MAX){
    for(int i = 0; i < MAX; i++){
        System.out.print(arr[i]+" |");
    }
    System.out.println();
}
}