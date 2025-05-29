/*
Se pide realizar un programa en Java que permita incorporar un producto promocionado R en aquellos
pedidos que posean al menos uno de los productos almacenados en un arreglo T de tamaño MAXT
(ordenado en forma ascendente). Debido a que solo se cuenta con una cantidad C del producto
promocionado R, sólo serán incorporados en los primeros pedidos que cumplan con el requisito antes
mencionado. La incorporación del producto se realiza al final del pedido.
Continuando con el ejemplo, dado un arreglo T = {8, 9} con MAXT = 2, un producto promocionado R = 22 y
una cantidad C = 2, el arreglo resultante será:
0 0 12 9 18 22 0 15 5 4 7 10 0 8 9 12 22 0 19 10 9 0 0 0 0
Por último, se debe indicar cuántos productos R quedaron sin agregar a los pedidos. En dicho ejemplo no
quedaron productos por agregar
 */

public class parcial4 {
    static final int MAXP = 25;
    static final int MAXT = 2;
    static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int[]pedidos={0,0,12,9,18,0,15,5,4,7,10,0,8,9,12,0,19,10,9,0,0,0,0,0,0};
        int[]T={8,9};
        
        int promosDisponibles=asignarProductoPromocionado(pedidos,T);
        mostrarArreglo(pedidos);
        System.out.println("Quedaron "+promosDisponibles+" promos sin asignar");

    }
    public static int asignarProductoPromocionado(int[]pedidos,int[]T){
        int pedidosAsignados=0;
        int ini=0, fin = -1;
        int promosDisponibles=2;
        int R= 22;

        while(ini<MAXP && pedidosAsignados<MAXT){
            ini=buscarInicio(pedidos,fin+1);
            if(ini<MAXP){
                fin=buscarFin(pedidos,ini);
                    if(encuentraOcurrencias(pedidos,ini,fin,T)){
                    agregarPromocion(pedidos,fin,R);
                    pedidosAsignados++;
                    promosDisponibles--;
                    }
            }
        }
        return promosDisponibles;
    }
    public static void agregarPromocion(int[]pedidos,int fin,int R){
        corrimientoDerecha(pedidos, fin);
        pedidos[fin+1]=R;
    }
    public static void corrimientoDerecha(int[]arr,int pos){
        for(int i=MAXP-1; i>pos; i--){
            arr[i]=arr[i-1];
        }
    }
    public static boolean encuentraOcurrencias(int[]pedidos,int ini, int fin,int[]T){
        boolean encontro = false;
        int i =ini;
        while(i<fin && !encontro){
            int j = 0;
            while(j<T.length && !encontro){
                if(pedidos[i]==T[j]){
                encontro=true;
                }else{
                    j++;
                }
            }
        i++;
        }

        return encontro;
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