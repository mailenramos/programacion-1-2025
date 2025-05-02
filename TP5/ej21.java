/*Hacer un programa que inserte un elemento en un arreglo
(ordenado decrecientemente) de tamaño MAX=10. */
public class ej21 {
    static final int MAX = 6;
    public static void main(String[] args) {
        int[]arr={99,80,70,65,9,6};
        System.out.println("ingrese un numero");
        int num=Utils.leerInt();
        int max =MAX-1;
        mostrarArregloInt(arr);
        while(arr[max]<num){
            arr[max]=arr[max-1];
            max--;
            if(arr[max]>num){
                arr[max+1]=num;
            }
        }

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
