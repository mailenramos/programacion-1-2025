public class ej4 {
    static final int MAXP=25;
    static final int MAXT=2;
    public static void main(String[] args) {
        int[]P={0,0,12,9,18,0,15,5,4,7,10,0,8,9,12,0,19,10,9,0,0,0,0,0,0};
        int[]T={8,9};
        int C = 2, R=22;

        regalarProductos(P,T,C,R);
        mostrarArreglo(P);
    }

    public static void regalarProductos(int[]P,int[]T,int C,int R){
        int ini=0, fin=-1;

        while(ini<MAXP && C>0){
            ini=buscarInicio(P,fin+1);
            if(ini<MAXP){
                fin=buscarFin(P,ini);
                if(poseeProducto(P,T,ini,fin)){
                        incorporarProducto(P,fin,R);
                        fin++;
                        C--;
                    }
            }
        }
        System.out.println("Quedaron "+C+" productos sin agregar");
    }

    public static void incorporarProducto(int[]P,int fin,int R){
        int i=MAXP-1;
        while(i>fin+1){
            P[i]=P[i-1];
            i--;
        }
        P[i]=R;
    }



    public static boolean poseeProducto(int[]P,int[]T,int ini, int fin){
    boolean posee=false;
    int i=ini;
        while(i<=fin && !posee){
            int j=0;
            while(j<MAXT){
                if(P[i]==T[j])
                posee=true;
                j++;
            }
        i++;
        }
    return posee;
    }

    public static int buscarInicio(int[]arr,int pos){
    int i=pos;
        while(i<MAXP && arr[i]==0){
            i++;
        }
    return i;
    }

    public static int buscarFin(int[]arr,int pos){
    int i=pos;
        while(i<MAXP && arr[i]!=0){
            i++;
        }
    return i-1;
    }

    public static void mostrarArreglo(int[]arr){
        for(int i=0;i<MAXP;i++){
            System.out.print(" |"+arr[i]);
        }
        System.out.println();
    }
}
