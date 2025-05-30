/*
realizar un programa en JAVA que, dado un arreglo de tamaño M, para cada secuencia delimitada por uno o
mas pixeles de color negro (valor 0) con más de X repeticiones de un valor de píxel (todos los elementos de la
secuencia deben ser iguales), comprima la secuencia poniendo en la primera posición el valor negado de la
cantidad de ocurrencias y a continuación el valor del pixel que se repite. El arreglo empieza y termina con un
separador 0 (color negro). 
 */
public class parcialPixeles {
    static final int MAX = 20;
    static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[]pixeles={0,67,67,67,67,67,67,67,67,0,14,0,33,33,33,33,0,5,98,0};
        int x = 4;

        comprimirArreglo(pixeles,x);
        mostrarArreglo(pixeles);
    }

    public static void comprimirArreglo(int[]pixeles,int x){
        int ini=0,fin=-1;
        int repeticiones=0;
        while(ini<MAX){
            ini=buscarInicio(pixeles,fin+1);
            if(ini<MAX){
                fin=buscarFin(pixeles,ini);
                    int largo=fin-ini+1;
                    repeticiones=buscarCoincidencias(pixeles,ini,fin,x,largo);
                    if(repeticiones>=x && repeticiones==largo){
                        eliminarSecuencia(pixeles,ini,fin,repeticiones);
                        fin=ini-1;
                        insertarNumero(pixeles,ini,repeticiones);
                    }
                }
            }
    }
    
    public static void insertarNumero(int[]pixeles,int ini,int repeticiones){
        correrDerecha(pixeles,ini);
        pixeles[ini]= -repeticiones;
    }

    public static void correrDerecha(int[]arr,int pos){
        int i=MAX-1;
        while(i>pos){
            arr[i]=arr[i-1];
            i--;
        }
    }

    public static void eliminarSecuencia(int[]pixeles,int ini,int fin,int repeticiones){
        for(int i=0;i<repeticiones-1;i++){
            correrIzquierda(pixeles, ini, fin);
        }
    }

    public static void correrIzquierda(int[]arr,int ini,int fin){
        int pos=ini;
        while (pos<MAX-1) {
            arr[pos]=arr[pos+1];
            pos++; 
        }
    }

    public static int buscarCoincidencias(int[]pixeles,int ini,int fin,int x,int largo){
        int repeticiones=1;

        for(int i=ini+1;i<=fin;i++){
            if(pixeles[i]==pixeles[i-1]){
               repeticiones++;
            }
        }
        return repeticiones;
    }

    public static int buscarInicio(int[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int buscarFin(int[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }

    public static void mostrarArreglo(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("| "+arr[i]);
        }
        System.out.println();
    }
}
