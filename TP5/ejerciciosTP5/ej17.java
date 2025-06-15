/*Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra cargado, solicite al usuario un número entero
y lo agregue al principio del arreglo (posición 0). Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del
arreglo) y colocar el número en el arreglo en la posición indicada. */
public class ej17 {
    static final int MAX = 10;
    
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9,10};
        int num=0,pos=0;
        System.out.println("Ingrese un numero entero para colocar al principio del arreglo");
        num=Utils.leerInt();
        corrimientoDerecha(arr, pos);
        arr[pos]=num;
        mostrarArregloInt(arr);
    }

    public static void corrimientoDerecha(int[]arr,int pos){
        for(int i=MAX-1;i>pos;i--){
            arr[i]=arr[i-1];
        }
    }
    public static void mostrarArregloInt(int[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
