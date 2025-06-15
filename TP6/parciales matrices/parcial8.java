class parcial8 {
    static final int MAXFILA=3;
    static final int MAXCOLUM=15;
    static final int SEPARADOR=0;
    static final int X=2;
    public static void main(String[] args) {
        int matriz[][]={{0,120,250,80,0,0,620,410,645,0,0,240,960,0,0},
                        {0,85,90,155,250,0,150,625,0,0,225,750,900,0,0},
                        {0,580,550,850,0,0,110,220,0,0,150,480,690,0,0}};
        procesarMatriz(matriz);
        mostrarMatriz(matriz);
    }
    public static void procesarMatriz(int [][]matriz) {
        int fila=0;
        int reordenamientos=0;
        while (fila<MAXFILA) {
                reordenamientos=OrdenarASClasDESC(matriz[fila]);
                if(reordenamientos>=X){
                    System.out.println("en el estante "+(fila+1)+" hubo al menos "+X+" reordenamiento");
                }
                fila++;
        }
    }
    public static int OrdenarASClasDESC(int []arr){
        int ini=0,fin=-1;
        int reordenamientos=0;
        while (ini<MAXCOLUM) {
            ini=buscarInicio(arr, fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr, ini);
                if(EsDesc(arr,ini,fin)){
                    Reordenar(arr,ini,fin);
                    reordenamientos++;
                }
            }
        }
        return reordenamientos;
    }
    public static void Reordenar(int [] arr,int ini,int fin) {
        int largo=fin-ini+1;
        while (ini<=largo/2) {
            int temporal=arr[ini];
            arr[ini]=arr[fin];
            arr[fin]=temporal;
            ini++;
            fin--;
        }
    }
    public static boolean EsDesc(int [] arr,int ini,int fin) {
        while (ini<fin && arr[ini]>=arr[ini+1]) {
            ini++;
        }
        return ini==fin;
    }
     public static int buscarInicio(int[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }
    public static void mostrarMatriz(int[][] matriz) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            mostrarArreglo(matriz[fila]);
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < MAXCOLUM; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
