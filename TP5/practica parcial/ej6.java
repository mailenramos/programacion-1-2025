public class ej6 {
    static final int SEPARADOR = 0;
    static final int MAXP = 28;
    static final int MAXR=2;
    public static void main(String[] args) {
        int[]P={0,0,9,12,18,0,1,5,43,73,88,0,8,9,52,0,1,10,90,0,0,0,0,0,0,0,0,0};
        int[]R={44,6};
        mostrarArreglo(P);
        System.out.println("-------------------------------------------------------");
        regalarProductos(P,R);
        mostrarArreglo(P);
    }

    public static void regalarProductos(int[]P,int[]R){
        int ini=0, fin=-1;
        int sumatoria=0;
        while(ini<MAXP){
            ini=buscarInicio(P,fin+1);
            if(ini<MAXP){
                fin=buscarFin(P,ini);
                int productosIncorporados=incorporarProducto(ini,fin,P,R);
                sumatoria+=productosIncorporados;
                fin=fin+productosIncorporados;

            }
        }
        System.out.println("Se incorporaron en total "+sumatoria+" productos regalados");
    }

    public static int incorporarProducto(int ini, int fin, int[]P,int[]R){
       
        int regalados=0;
            while(regalados<MAXR){
                int pos=BuscarPosicion(P,ini,fin,R[regalados]);
                incorporarProducto(pos,P,R[regalados]);
                regalados++;
                fin++;
            }
        return regalados;
    }

    public static void incorporarProducto(int pos,int[] arr,int regalo){
        int i=MAXP-1;
        while(i>pos){
            arr[i]=arr[i-1];
            i--;
        }

        arr[i]=regalo;
    }

    public static int BuscarPosicion(int [ ]arr, int ini, int fin,int prod) {
        int i=ini;
        while (i<=fin && arr[i]<prod){
            i++;
        }
        return i;
    }

    public static int buscarInicio(int[]arr, int pos){
        int i=pos;
        while(i<MAXP && arr[i]==SEPARADOR){
            i++;
        }
        return i;
    }

    public static int buscarFin(int[]arr, int pos){
        int i=pos;
        while(i<MAXP && arr[i]!=SEPARADOR){
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
