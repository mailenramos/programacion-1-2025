public class parcial6 {
    static final int MAXP = 28;
    static final int MAXR = 2;
    static final int SEPARADOR = 0;
/*
Se pide realizar un programa en Java que permita incorporar a cada pedido los productos promocionados
que están almacenados en un arreglo R. 
La incorporación de los productos se deberá realizar respetando el orden ascendente de los productos de cada pedido. 
Se pide además informar la cantidad de productos regalados en total.

 */
    public static void main(String[] args) {
        int[] R = {44,6};
        int[]P={0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        asignarPromosEnPedidos(R,P);
    }

    public static void asignarPromosEnPedidos(int[]R,int[]P){
        int ini=0,fin=-1;
        int nroPedido=0;
        while(ini<MAXP){
            ini = buscarInicio(P,fin+1);
            if(ini<MAXP){
                fin=buscarFin(P, ini);
                int posPromo=buscarPosInsercion(P,ini,fin,R);
                System.out.println("La promo se debería insertar en la posicion "+posPromo);
                //incorporarPromos(P,ini,fin,R);

            }
        }
    }

    public static int buscarPosInsercion(int[]P,int ini,int fin, int[]R){
        int i = ini;
        int j = 0;
        while(i<=fin && j<MAXR){
            if(R[j] < P[i]){
                i++;
            }
            j++;
        }
        return i;
    }

    public static void incorporarPromos(int[]P,int ini,int fin, int[]R){

    }

    public static void correrDerecha(int[]arr, int pos){
        for(int i=MAXP-1; i>pos;i--){
            arr[i]=arr[i-1];
        }
    }
    
    public static int buscarInicio(int[]arr,int pos){
        int i=pos;
        while(i<MAXP && arr[i]==SEPARADOR){
            i++;
        }
        return i;
    }

    public static int buscarFin(int[]arr,int pos){
        int i=pos;
        while(i<MAXP && arr[i]!=SEPARADOR){
            i++;
        }
        return i-1;
    }
    public static void mostrarArreglo(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("| "+arr[i]);
        }
        System.err.println();
    }
}