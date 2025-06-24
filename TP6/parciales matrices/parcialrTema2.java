public class parcialrTema2 {
    static final int MAX=25;
    static final int N=3;
    public static void main(String[] args) {
        int arr[]={-6,-8,23,21,20,19,15,-1,15,14,13,16,-8,-10,30,28,22,16,12,-3,56,52,54,60,-5};
        procesarArreglo(arr);
        mostrarArreglo(arr);
    }
    public static void procesarArreglo(int[] arr){
        int ini=0,fin=-1;
        int estudiante=0;
        while (ini<MAX) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAX){
                fin=buscarFin(arr,ini);
                System.out.println("ini: "+ini+" fin:"+fin);
                estudiante++;
                if (DisminuyeConcentracion(arr, ini, fin)) {
                    System.out.println("El estudiante " + estudiante + " presenta falta de concentracion.");
                }
                else {
                    TransformarTiempo(arr, ini, fin);
                    fin = ini + 1;
                }
            }
        }
    }
    public static void TransformarTiempo(int[] arr,int ini,int fin){
        int Totalminutos=SumarElementos(arr,ini,fin);
        int horas=Totalminutos/60;
        int minutos=Totalminutos%60;
        arr[ini]=horas;
        arr[ini+1]=minutos;
        SuprimirResto(arr,ini+2,fin);
    }
    public static int SumarElementos(int []arr,int ini,int fin) {
        int suma = 0;
        for (int i = ini; i <= fin; i++)
            suma += arr[i];
        
        return suma;
    }
    public static void SuprimirResto(int[] arr,int ini,int fin){
          for (int i = ini; i <= fin; i++)
            correrIzquierda(arr, ini);
    }
    public static void correrIzquierda(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }
    public static boolean DisminuyeConcentracion(int [] arr,int ini,int fin) {
         while (ini < fin && arr[ini] >= arr[ini + 1])
            ini++;
        
        return ini == fin;
    }
    public static int buscarInicio(int[] arr,int pos) {
        while (pos<MAX && arr[pos]<0) {
            pos++;
        }
        return pos;
    }
    public static int buscarFin(int[] arr,int pos) {
        while (pos<MAX && arr[pos]>=0) {
            pos++;
        }
        return pos-1;
    }
    public static void mostrarArreglo(int[] arr) {
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println("");
    }
}