public class ej22 {
    static final int MAX = 10;
    /*Hacer un programa que elimine los valores pares en un arreglo
de tamaño MAX=10. */
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8,9,10};
        
        mostrarArregloInt(arr);
        eliminarParesArr(arr);
        mostrarArregloInt(arr);
    }

    public static void eliminarParesArr(int[]arr){
        int i =0;
        while(i<MAX){
            if(arr[i]%2==0){
                corrimientoIzquierda(arr, i);
                arr[MAX-1]=0;
            }
        i++;
        }
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
