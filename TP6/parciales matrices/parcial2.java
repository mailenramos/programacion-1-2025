class parcial2 {
    static final int MAFILA=7;
    static final int MAXCOLUM=20;
    static final double P=0.5;
    static final int MAXarr=7;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
    int matriz[][]={
                    {0,300,298,298,297,0,240,233,245,240,0,257,254,254,0,234,230,222,0,0},
                    {0,310,302,284,271,0,280,263,263,0,0,0,264,264,0,234,230,0,0,0},
                    {0,310,302,294,0,0,250,243,0,245,0,257,255,253,0,234,229,0,0,0},
                    {0,315,320,395,398,0,351,333,353,0,0,0,334,354,0,454,490,499,0,0},
                    {0,410,400,397,0,0,250,243,0,0,0,257,255,253,0,234,229,220,0,0},
                    {0,0,420,430,430,450,420,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,415,425,435,420,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}  
                    };
    int dias[]={1,2,5,0,0,0,0};
    procesarMatriz(matriz,dias);
    mostrarArreglo(dias);
    }
    public static void procesarMatriz(int[][]matriz, int[] dias) {
        int i=0;
        double Progresivos=0;
        double diasTotales=0;
        while (i<MAXarr && dias[i]!=0){
            diasTotales++;
            if(Esprogresivo(matriz[dias[i]-1])){
                correrIzquierda(dias,i);   
                Progresivos++; 
            }else{
                i++;
            }
        }
        cumplioEntrenamiento(Progresivos, diasTotales);
    }

    public static void cumplioEntrenamiento(double Progresivos, double diasTotales){
        double promedio = (Progresivos/diasTotales);
        System.out.println("El atleta cumplio con el entrenamiento? "+ (promedio>=P)); 
    }

    public static void correrIzquierda(int [] arr,int pos) {
        for(int i=pos;i<MAXarr-1;i++){
            arr[i]=arr[i+1];
        }
    }
    public static boolean Esprogresivo(int[] arr){
        int ini=0,fin=-1;
        boolean EsProg=true;
        while (ini<MAXCOLUM && EsProg) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                EsProg=CheckProgresividad(arr,ini,fin);
            }    
        }
        return EsProg;
    }
    public static boolean CheckProgresividad(int[] arr,int ini,int fin) {
        while (ini<fin && arr[ini]>=arr[ini+1]) {
            ini++;
        }
        return ini==fin;
    }
    public static int buscarInicio(int[]arr, int pos) {
        while (pos<MAXCOLUM && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }
     public static int buscarFin(int[]arr, int pos) {
        while (pos<MAXCOLUM && arr[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArreglo(int arr[]) {
        for(int i=0;i<MAXarr;i++){
            System.out.print(arr[i]+"|");
        }
        System.out.println();
    }
}