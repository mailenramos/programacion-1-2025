public class parcial1 {
    static final int MAXFILA=3;
    static final int MAXCOLUM=20;
    static final int MAXB=3;
    static final int SEPARADOR='x';
    static final int R=2;/*especies vegetales */
    public static void main(String[] args) {
        char matriz[][]={
                        {'x','t','a','C','M','O','t','a','a','t','O','C','t','t','a','O','M','C','t','x'},
                        {'x','r','r','r','C','C','O','O','r','r','C','r','G','G','G','r','r','x','x','x'},
                        {'x','m','G','m','h','h','L','G','G','O','h','h','m','m','O','B','M','C','x','x'}
        };
        char arrB[]={'C','O','L'};
        procesarMatriz(matriz,arrB);
    }
    public static void procesarMatriz(char[][] matriz,char[] arrB) {
        int fila=0;
        int malezas=0;
        while (fila<MAXFILA){
            malezas+=eliminarPlantasNoBeneficiosas(matriz[fila],arrB);
            fila++;
        }
        System.out.println("la cantidad de malezas eliminadas son:"+malezas);
    }
    public static int eliminarPlantasNoBeneficiosas(char[]arr,char[]arrB) {
        int ini=0,fin=-1;
        int malezas=0;
        while (ini<MAXCOLUM){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                if(fin-ini+1>R){
                    int cantidad=buscarMaleza(arr,ini,fin,arrB);
                    fin=fin-malezas;
                    malezas+=cantidad;
                }
            }
        }
        return malezas;
    }
    public static int buscarMaleza(char[]arr,int ini,int fin,char[]arrB) {
        int contMalezasEliminadas=0;
        while (ini<=fin){
            if(esBeneficiosa(arr[ini],arrB)){
                ini++;
            }else{
                correrIzquierda(arr,ini);
                fin--;
                contMalezasEliminadas++;
            }
            
        }
        return contMalezasEliminadas;
    }
    public static boolean esBeneficiosa(char planta,char[]arrB) {
        int i=0;
        while (i<MAXB && arrB[i]!=planta){
            i++;
        }
        return i < MAXB;
    }
   
     public static boolean esMinuscula(char c) {
    return c >= 'a' && c <= 'z';
    }

    public static int buscarInicio(char [] arrV, int ini) {
        while (ini < MAXCOLUM && esMinuscula(arrV[ini])) {
            ini++;
        }
        return ini;
    }
    public static int buscarFin(char[] arrV, int ini) {
        while (ini < MAXCOLUM && !esMinuscula(arrV[ini])) {
            ini++;
        }
        return ini-1;
    }
    public static void mostrarMatriz(char [][]matriz){
        for(int fila =0;fila<MAXFILA;fila++){
            mostrarArreglo(matriz[fila]);
        }
    }
    public static void mostrarArreglo(char[] arr) {
        for(int i=0;i<MAXCOLUM;i++){
            System.out.print(arr[i]+"|");
        }
        System.out.println("");
        
    }
    public static void correrIzquierda(char []arr,int pos){
        for(int i=pos;i<MAXCOLUM-1;i++){
            arr[i]=arr[i+1];
        }
    }

}
