public class parcial3 {
    static final int MAXCOLUM=16;
    static final int MAXFILA=4;
    static final char SEPARADOR=' ';
    public static void main(String[] args) {
        char matriz[][]={
            {' ','e','l',' ','a','g','e','n','t','e',' ',' ',' ',' ',' ',' '},
            {' ','J','a','m','e','s',' ','B','o',' ','s','e',' ',' ',' ',' '},
            {' ','e','n','c','u','e','n','t','r','a',' ','e','n',' ',' ',' '},
            {' ','C','o','l','o','n','i','a',' ',' ',' ',' ',' ',' ',' ',' '}
        };
        procesarMatriz(matriz);
        mostrarMatriz(matriz);
    }
    public static void procesarMatriz(char [][] matriz) {
        int fila=0;
        int CantSecEncriptadas=0;
        while (fila<MAXFILA){
            CantSecEncriptadas+=descencriptar(matriz[fila]);
            fila++;
        }
        System.out.println("La cantidad de secuencias encriptadas es: "+CantSecEncriptadas);
    }
    public static int descencriptar(char[] arr){
        int ini=0,fin=-1;
        int CantSecEncriptadas=0;
        while (ini<MAXCOLUM) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                if(EsNombrePropio(arr,ini,fin)){
                    Invertir(arr,ini,fin);
                    int encriptaciones=Encriptar(arr,ini,fin);
                    fin=fin+encriptaciones;
                    CantSecEncriptadas++;
                }
            }
        }
        return CantSecEncriptadas;
    }
    public static int Encriptar(char[] arr,int ini,int fin){
        int minusculas=0;
        while (ini<=fin){
            if(EsVocalMinuscula(arr[ini])){
                CorrerDerecha(arr,ini);
                ini=ini+2;
                minusculas++;
                fin++;
            }
            else{
                ini++;
            }
        }
        return minusculas;
    }
    public static void CorrerDerecha(char[] arr, int pos) {
        for (int i = MAXCOLUM - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }
    public static boolean EsVocalMinuscula(char valor) {
    return valor == 'a' || valor == 'e' || valor == 'i' || valor == 'o' || valor == 'u';
    }

    public static void Invertir(char[] arr,int ini,int fin){
        while (ini<=(fin-ini+1)){
            char temp=arr[ini];
            arr[ini]=arr[fin];
            arr[fin]=temp;
            ini++;
            fin--;
        }
    }
    public static boolean EsNombrePropio(char[] arr,int ini,int fin){
        return (arr[ini]>='A') && (arr[ini]<='Z');
    }
    public static int buscarInicio(char[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }
     public static void mostrarMatriz(char[][] matriz) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            mostrarArreglo(matriz[fila]);
        }
    }

    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < MAXCOLUM; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
