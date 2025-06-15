/*Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño.
*/
public class ej26 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 5, 6, 7, 8, 0, 0, 1, 2, 3, 4, 0, 5, 6, 0, 0, 0};
        procesar(arr);
    }

    public static void procesar(int[] arr) {
        int inicio = 0, fin = -1;
        int tamanioSecuencia = 0;
        int mayorTamanio=0;
        int iniciomayor=0;
        int finmayor=0;

        
        while (inicio < MAX) {
            inicio = buscarIni(arr, fin + 1);
            if (inicio < MAX) {
                fin = buscarFin(arr, inicio);

                tamanioSecuencia=buscarTamanio(inicio,fin);
                
                if (tamanioSecuencia>mayorTamanio){
                    mayorTamanio=tamanioSecuencia;
                    iniciomayor=inicio;
                    finmayor=fin;
                    
                }
            }
        }
        System.out.println("inicio: "+iniciomayor+"| fin: "+finmayor);

       
    }
    public static int buscarTamanio(int ini,int fin) {
        int tamanio=0;
        while (ini<=fin) {
            tamanio++;  
            ini++;  
        }
        return tamanio;
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
}
