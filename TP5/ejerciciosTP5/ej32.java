public class ej32 {
    static final int MAX = 20;
    /*Hacer
Obtener la posición de inicio y fin de la secuencia ubicada a partir de una posición entera ingresada por el usuario. 
Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
     */
    public static void main(String[] args) {
        int[]arr={0,1,2,3,0,4,5,6,0,4,5,0,3,2,3,4,5,6,0,0};
        int pos=0;
        System.out.println("Ingrese una posicion");
        pos=Utils.leerInt();
        mostrarArregloInt(arr);
        procesar(arr,pos);
    }

    public static void procesar(int[]arr,int pos){
        int ini=0,fin=-1;

        if(arr[pos]!=0){
            while(ini<MAX){
                ini=buscarIni(arr,fin+1);
                if(ini<MAX){
                    fin=buscarFin(arr,ini);
                    if (pos>=ini && pos<=fin){
                        System.out.println("La sec. ubicada en pos: "+pos+"\ninicia en: "+ini+" finaliza en "+fin);
                    }

                }

            }
        }else{
            System.out.println("No se encontró una secuencia en "+pos);
        }
    }
    public static void buscarSecuenciaEnPos(int[]arr,int ini,int fin,int pos){
        for (int i=ini;i<fin;i++){
            
        }
    }
    public static int buscarIni(int[] arr, int ini) {
        while (ini < MAX && arr[ini] == 0) {
            ini++;
        }
        return ini;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini < MAX && arr[ini] != 0) {
            ini++;
        }
        return ini - 1;
    }
    public static void mostrarArregloInt(int[]arr){
        for(int i=0; i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
