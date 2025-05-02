/*Dado un arreglo de caracteres de tamaño MAX, hacer un
programa que implemente métodos tal que devuelva al main: un
arreglo con las posiciones de los caracteres que son letras
vocales y otro con las posiciones que son consonantes.
*/
public class ej14 {
    static final int MAX =5;
    public static void main(String[] args) {
        char[]arr = {'a','b','c','d','e'};
        int[]vocales = new int[MAX];
        int[]consonantes = new int[MAX];

        posicionLetras(arr,vocales,consonantes);
        mostrarArregloChar(arr);
        mostrarArregloInt(vocales);
        mostrarArregloInt(consonantes);
        
    }

    public static void posicionLetras(char[]arr, int[]vocales, int[]consonantes){
        char caracter = ' ';
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        for(int i=0; i<MAX; i++){
            caracter=arr[i];
            switch(caracter){
                case 'a','e','i','o','u':
                    vocales[contadorVocales++]=i;
                    break;
                default:
                    consonantes[contadorConsonantes++]=i;
                    break;
            }
        }
    }

    public static void mostrarArregloChar(char[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
    public static void mostrarArregloInt(int[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
