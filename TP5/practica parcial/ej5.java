public class ej5 {
    static final int MAXE = 16;
    public static void main(String[] args) {
        int[]E = {-1,5,5,7,7,-6,4,9,10,-4,1,1,2,7,-9,-8};
        System.out.println("ingrese el numero pedido");
        int NroPedido=Utils.leerInt();
        System.out.println("ingrese empanada a agregar");
        int emp=Utils.leerInt();

        agregarOrden(NroPedido,emp,E);
        mostrarArreglo(E);
    }
    public static void agregarOrden(int NroPedido,int emp,int[] E) {
        int ini=0,fin=-1;
        int pedido=0;
        while (ini<MAXE){
            ini=buscarInicio(E,fin+1);
            if(ini<MAXE){
                fin=buscarFin(E,ini);
                pedido++;
                if(pedido==NroPedido){
                    int pos=BuscarPosicion(ini,fin,E,emp);
                    AgregarEmpanada(pos,E,emp);
                    fin++;
                }
            }
        }
    }

    public static void AgregarEmpanada(int pos, int[]E, int emp){
        int i = MAXE-1;
        while(i>pos){
            E[i]=E[i-1];
            i--;
        }
        E[i]=emp;
    }

    public static int BuscarPosicion(int ini,int fin ,int []arr,int emp) {
        int i=ini;
        while (i<=fin && arr[i]<emp) {
            i++;
        }
        return i;
    }
    public static int buscarInicio(int [] arr,int pos){
        int i=pos;
        while (i<MAXE && arr[i]<0) {
            i++;
        }
        return i;
        
    }
     public static int buscarFin(int [] arr,int pos){
        int i=pos;
        while (i<MAXE && arr[i]>0) {
            i++;
        }
        return i-1;
        
    }
    public static void mostrarArreglo(int[]arr){
        for(int i=0;i<MAXE;i++){
            System.out.print(" |"+arr[i]);
        }
        System.out.println();
    }
}
