public class ej19 {
    public static final int MAX=10;
    /*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
     solicite al usuario un número entero y elimine todas las ocurrencia de número en el arreglo.

    Mientras exista (en cada iteración tiene que buscar la posición
    dentro del arreglo) tendrá que usar la posición para realizar un
    corrimiento a izquierda (quedarán tantas copias de la última
    posición del arreglo como cantidad de ocurrencias del número).
 */
public static void main(String[] args) {
    int[] arr={1,2,3,5,5,6,7,8,9,10};
    System.out.println("ingrese un numero ");
    int num=Utils.leerInt();
    mostrarArregloInt(arr);
    eliminarTodasOcurrencias(arr,num);
    mostrarArregloInt(arr);
    
}
public static void eliminarTodasOcurrencias(int[] arr, int num) {
    int i = 0;
    while (i < MAX) {
        if (arr[i] == num) {
            corrimientoIzquierda(arr, i);
            // No incrementamos i, ya que el nuevo valor en arr[i] puede ser también num
        } else {
            i++;
        }
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
