/*15. Implementar un método que realice un corrimiento a derecha
en un arreglo ordenado de tamaño MAX=10 a partir de una posición. */
public class ej15 {
    static final int MAX = 10;
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8,9,10};
        int pos= 4;
        mostrarArregloInt(arr);
        corrimientoDerecha(arr,pos);
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
