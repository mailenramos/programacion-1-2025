public class ej13 {
    static final int MAX =5;
    /*Dado un arreglo de caracteres de tamaño MAX, 
    implemente métodos tal que devuelva al main dos arreglos: 
    un arreglo con los caracteres que son letras vocales y
    otro con los que son consonantes. */
    public static void main(String[] args) {
        char[]arr = {'a','b','c','d','e'};
        char[]vocales = new char[MAX];
        char[]consonantes = new char[MAX];

        separarLetras(arr,vocales,consonantes);
        mostrarArreglo(arr);
        mostrarArreglo(vocales);
        mostrarArreglo(consonantes);
        
    }

    public static void separarLetras(char[]arr, char[]vocales, char[]consonantes){
        char caracter = ' ';
        int contadorVocales = 0;
        int contadorConsonantes = 0;
        for(int i=0; i<MAX; i++){
            caracter=arr[i];
            switch(caracter){
                case 'a','e','i','o','u':
                    vocales[contadorVocales]=arr[i];
                    contadorVocales++;
                    break;
                default:
                    consonantes[contadorConsonantes]=arr[i];
                    contadorConsonantes++;
                    break;
            }
        }
    }

    public static void mostrarArreglo(char[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
