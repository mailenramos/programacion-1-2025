public class parcial6 {
    static final int MAXCOLUM=23;
    static final int MAXFILA=3;

    public static void main(String[] args) {
        char matriz[][]={
            {'-','S','u','p','e','r',' ','s','e','c','r','e','t','o',':','-','-','-','-','-','-','-','-'},
            {'¡','¡','n','o',' ','c','o','r','t','a','r',' ','f','o','r',' ',' ',' ',' ',' ',' ',' ',' '},
            {' ','c','o','n',' ','r','e','t','u','r','n','!','!','!','!','!','!','!','!','!','!','!','!'}
        };
        procesarMatriz(matriz);
        mostrarMatriz(matriz);
    }
    public static void procesarMatriz(char[][] matriz) {
        int fila=0;
        int palabrasEncriptadas=0;
        while (fila<MAXFILA) {
            palabrasEncriptadas+=Encriptar(matriz[fila]);
            fila++;
        }
        System.out.println("la cantidad de palabras encriptadas son "+palabrasEncriptadas);
    }
    public static int Encriptar(char[] arr){
        int ini=0,fin=-1;
        int encriptadas=0;
        while (ini<MAXCOLUM){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                int largo=fin-ini+1;
                int ConsAgregadas=Encriptar(arr,ini,fin,largo);
                fin=fin+ConsAgregadas;
                encriptadas++;
            }
        }
        return encriptadas;  
    }
  

    public static int Encriptar(char[] arr, int ini, int fin, int largo){
    int consonantesAgregadas = 0;
        while (ini <= fin) {
            if (EsVocal(arr[ini])) {
                desplazarVocales(arr, ini, largo);
                ini++;
            } else {
                CorrerDerecha(arr, ini);
                fin++;
                consonantesAgregadas++;
                ini += 2;
            }
        }
    return consonantesAgregadas;
    }
    public static void desplazarVocales(char[] arr,int ini,int largo) {
         arr[ini] = (char)(arr[ini] + largo);
    }        
     public static void CorrerDerecha(char[] arr, int pos) {
        for (int i = MAXCOLUM - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }
    public static boolean EsVocal(char valor) {
        return valor=='a'|| valor=='e'||valor=='i'||valor=='o'||valor=='u';
    }
    public static int buscarFin(char[] arr, int pos) {
    while (pos < MAXCOLUM && (EsMinuscula(arr[pos]) || EsMayuscula(arr[pos]))) {
        pos++;
    }
        return pos - 1;
    }
    public static int buscarInicio(char[] arr, int pos) {
        while (pos < MAXCOLUM && !EsMinuscula(arr[pos]) && !EsMayuscula(arr[pos])) {
         pos++;
        }
        return pos;
    }
    public static boolean EsMinuscula(char c) {
        return c >= 'a' && c <= 'z';
    }
    public static boolean EsMayuscula(char c) {
        return c >= 'A' && c <= 'Z';
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
