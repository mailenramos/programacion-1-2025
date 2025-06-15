public class EjDominioReal1 {
    static final int MAX = 20;
    static final int SEPARADOR = 0;
    /*
1. Un sismógrafo ubicado en la ciudad de Mendoza,
registró una fuerte actividad sísmica en los últimos días.

Los datos están en escala de Richter, y están representados en el siguiente arreglo:
0, 2.1, 1.5, 4.1, 0, 3.4, 0, 2.5, 3.0,0 , 3.8, 0, 2.7, 2.7, 3.9, 2.5, 0, 4.2, 2.0, 0
Cada día de actividad sísmica está separada por un cero.
Cada secuencia representa qué sismos hubo en ese dia. 

Entonces, con la información provista, se pide calcular el promedio de actividad sísmica 
para aquellos días donde hubo un número mayor a N de temblores Y que todas las magnitudes de dicho día sean de un mínimo de M en la escala de Richter
Por ejemplo, si N=1 y M=2.0, las secuencias que cumplen son:
Por ende, el promedio de sismos para los días que cumplen la
condición es => 2.9375

     */
    public static void main(String[] args) {
        double arr[]={0, 2.1, 1.5, 4.1, 0, 3.4, 0, 2.5, 3.0, 0 , 3.8, 0, 2.7, 2.7, 3.9, 2.5, 0, 4.2, 2.0, 0};
        int N=1;
        double M=2.0;

        promedioActividadSismica(arr,N,M);
        
        //2.9375
    }

    public static void promedioActividadSismica(double[]arr,int N,double M){
        int ini=0,fin=-1,dias=0, largoSec = 0, magnitudes=0;
        double sumatoria=0;

        while(ini<MAX){
            ini=BuscarInicio(arr,fin+1);
            if(ini<MAX){
                fin=BuscarFin(arr,ini);
                dias++;
                largoSec = (fin-ini) + 1;
                if(largoSec>N){
                    if(superaMinimo(arr,ini,fin,M)){
                        sumatoria += sumatoria(arr,ini,fin);
                        magnitudes+=contarMagnitudes(arr,ini,fin);
                        System.out.println("el dia "+dias+" Sumatoria= "+sumatoria+" Magnitudes= "+magnitudes);
                   }
                }
            }
        }
        if(magnitudes>0){
            System.out.println("El promedio de actividad sismica fue: "+ sumatoria/magnitudes);
        }else{
            System.out.println("No hay dias que cumplan la condicion");
        }
        
    }

    public static int contarMagnitudes(double[]arr,int ini,int fin){
        return fin-ini+1;
    }

    public static double sumatoria(double[]arr,int ini,int fin){
        double sumatoria=0;
        for(int i=ini;i<=fin;i++){
            sumatoria+=arr[i];
        }
        return sumatoria;
    }

    public static boolean superaMinimo(double[] arr, int ini, int fin, double M) {
    for (int i = ini; i <= fin; i++) {
        if (arr[i] < M) return false;
    }
    return true;
}


        public static int BuscarInicio(double[]arr,int pos){
        int i=pos;
          while(i<MAX && arr[i]==SEPARADOR){
                 i++;
          }
    return i;
    }
    
    public static int BuscarFin(double[]arr,int pos){
        int i = pos;
     while(i<MAX && arr[i]!=SEPARADOR){
     i++;
     }
    return i-1;
}
}
