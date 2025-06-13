public class parcial4{
    /*El dueño del food truck está analizando la incorporación de más personal,
     por lo tanto, desea conocer si al menos en X
    días consecutivos, el promedio de ventas por hora, se incrementó crecientemente 
    (en forma ascendente).
    En ejemplo anterior, con un X = 2 se deberá informar que SÍ hubo al menos 2 días cuyo promedio de ventas por hora
    se incrementó crecientemente. Esto es así porque en el día 2 (fila 1)
    los promedios de cada hora fueron: $324,5; $606,33 y
    $820 respectivamente, mientras que en el día 3 (fila 2) los promedios de cada hora fueron: $478,5; $733,33 y $907. */
    static final int MAXFILA=4;
    static final int MAXCOLUM=15;
    static final int SEPARADOR=0;
    public static void main(String[] args) {
        int[][] matriz={
                    {0,625,815,900,0,562,952,300,0,365,169,254,0,0,0},
                    {0,958,62,57,221,0,596,623,600,0,587,889,984,0,0},
                    {0,0,700,257,0,0,0,854,958,388,0,954,842,925,0},
                    {0,988,899,874,0,254,258,652,200,0,568,958,210,0,0}
                    };
        procesarMatriz(matriz);
    }
    public static void procesarMatriz(int[][] matriz){
    int fila=0;
    int consecutivos=0;
    int X=2;
        while (fila<MAXFILA && consecutivos<X) {
            if(PromedioIncreCrec(matriz[fila])){
                consecutivos++;
            }else{
                consecutivos=0;
            }
        fila++;
        }
        if (consecutivos==X){
            System.out.println("se cumple la cantidad de "+X+" dias consecutivos");
        }
    }

    public static boolean PromedioIncreCrec(int[]arr){
        int ini=0,fin=-1;
        double promedioAnterior=-999999999.9;
        double promedioActual=0;
        boolean promAsc=true;
        while (ini<MAXCOLUM && promAsc){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                promedioActual=SacarPromedio(arr,ini,fin);
                if(promedioActual>promedioAnterior){
                    promedioAnterior=promedioActual;
                }else{
                    promAsc=false;
                }
            }   
        }
        return promAsc;
    }
    public static double SacarPromedio(int[]arr, int ini,int fin) {
        int i=ini;
        double sumatoria=0;
        while (i<=fin){
            sumatoria+=arr[i];
            i++;
        }
       
        int cantVentas=fin-ini+1;
        return sumatoria/cantVentas;
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
        
    
}
