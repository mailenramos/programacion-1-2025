public class ej8 {
    static final int MAX=21;
    static final int SEPARADOR=0;

    public static void main(String[] args) {
        double [] arr= {0,2.1,1.5,4.1,0,3.4,0,2.5,3.0,0,3.8,0,2.7,2.7,3.9,2.5,0,4.2,2.0,0,0};
        int N=2;
        double M=2.6;

        existio(arr,N,M);
    }
    public static void existio(double[] arr,int N,double M) {
        int ini=0, fin=-1;
        boolean superaMinimo=false;
        int secuencia=0;
        while (ini<MAX && !superaMinimo) {
            ini=buscarInicio(arr,fin+1);
            if(ini<MAX){
                fin=buscarFin(arr,ini);
                secuencia++;
                int largo=fin-ini+1;
                if(largo>=N){
                    superaMinimo=verificarPromedioM(arr,ini,fin,M,largo);
                    if(superaMinimo){
                        System.out.println("la secuencia "+secuencia+" cumple con lo buscado");
                    }
                }
            }
        }   
    }
    public static boolean verificarPromedioM(double [] arr,int ini,int fin, double M,int largo) {
        double sumatoria=0;
        int i=ini;
        double promedio=0;

        while (i<=fin){
            sumatoria+=arr[i];
            i++; 
        }
        promedio=sumatoria/largo;

        return promedio>M;
        
    }
    public static int buscarInicio(double[] arr,int pos) {
        int i=pos;
        while (i<MAX && arr[i]==SEPARADOR){
            i++;     
        }
        return i;
    }
    public static int buscarFin(double[] arr,int pos) {
        int i=pos;
        while (i<MAX && arr[i]!=SEPARADOR){
            i++;     
        }
        return i-1;
    }
}
