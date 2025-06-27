/*
Determinar si en periodo registrado, existió un día donde hubo un número N mínimo de temblores y cuyo
promedio diario fuese superior a M en la escala de Richter. Por ejemplo, si N=2 y M=2.6, existió dicho día
dado que la 3ra secuencia (2.5, 3.0) cumple con lo buscado.
 */
public class parcialarreglo8 {
    static final int MAX = 21;
    static final int SEPARADOR = 0;

    public static void main(String[] args) {
        double[]periodo={0 ,2.1 ,1.5 ,4.1 ,0 ,3.4 ,0 ,2.5 ,3.0 ,0 ,3.8 ,0 ,2.7 ,2.7 ,3.9 ,2.5 ,0 ,4.2 ,2.0 ,0 ,0};
        int N = 2;
        double M =2.6;
        determinarPeriodo(periodo,N,M);
    }

    public static void determinarPeriodo(double[]periodo,int N, double M){
        int ini=0,fin=-1;
        int dia=0;
        double promedio=0;
        boolean existeDia=false;
    
        while(ini<MAX && !existeDia){
            ini=buscarInicio(periodo,fin+1);
            if(ini<MAX){
                fin=buscarFin(periodo,ini);
                dia++;
                int cantTemblores=fin-ini+1;
                promedio=sacarPromedio(periodo,ini,fin,cantTemblores);
                if(cantTemblores>=N && promedio>M){
                    existeDia=true;
                    System.out.println("Existe un registro en el dia "+dia+" que cumple los requisitos: ");
                }
            }
        }
        if(!existeDia){
            System.out.println("No existe un dia que cumpla lo requerido");
        }
    }

    public static double sacarPromedio(double[]periodo,int ini,int fin,int largo){
        double sumatoria=0;
        for(int i = ini; i<=fin;i++){
            sumatoria+=periodo[i];
        }
        return sumatoria/largo;
    }

    public static int buscarInicio(double[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int buscarFin(double[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }
}
