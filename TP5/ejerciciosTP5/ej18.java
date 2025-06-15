public class ej18 {
    public static final int MAX=10;
    public static void main(String[] args) {
    /*Hacer un programa que dado un arreglo de enteros de tamaño10 que se encuentra precargado,
     solicite al usuario un número entero y elimine la primera ocurrencia del número (un número
     igual) en el arreglo (si existe). Para ello tendrá que buscar la
     posición y si está, realizar un corrimiento a izquierda .
    */
    int[] arr={1,2,3,5,5,6,7,8,9,10};
    System.out.println("ingrese un numero ");
    int num=Utils.leerInt();
    mostrarArregloInt(arr);
    encontrarOcurrencia(arr,num);
    mostrarArregloInt(arr);
    }
    public static void encontrarOcurrencia(int[]arr,int num) {
        for(int i=0;i<MAX;i++){
            if(arr[i]==num){
                corrimientoIzquierda(arr,i);
                
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
