/*Implementar un método que realice un corrimiento a izquierda
en un arreglo ordenado de tamaño MAX=10 a partir de una posición. */
public class ej16 {
    static final int MAX = 5;
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        int pos = 2;

        mostrarArregloInt(arr);
        corrimientoIzquierda(arr,pos);
        mostrarArregloInt(arr);
    }

    public static void corrimientoIzquierda(int[]arr,int pos){
        while(pos<MAX-1){
            arr[pos]=arr[pos+1];
            pos++;
        }
    }

    public static void mostrarArregloInt(int[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
