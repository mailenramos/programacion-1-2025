public class procesarSecuencias {
    /*Dado un arreglo de enteros incremente en 1 cada elemento de una secuencia
     si la suma de los elementos de dicha secuencia es par */
static final int SEPARADOR = 0;
static final int MAX = 12;
     public static void main(String[] args) {
    int[]arr = {0,8,4,-2,0,10,5,0,1,25,2,0};
    procesarSecuencias(arr);
    mostrarArreglo(arr);
}

public static void procesarSecuencias(int[]arr){
        int inicio=0,fin=-1,suma=0;
        while(inicio<MAX){
            inicio=obtenerInicio(arr, fin+1);
            if (inicio<MAX) {
                fin=obtenerFin(arr,inicio);
                //ya tengo una secuencia con inicio y fin
                suma=obtenerSuma(arr,inicio,fin);
                if(suma%2==0){
                    modificarSecuencia(arr,inicio,fin);
                }
            }
        }
}
public static void modificarSecuencia(int[]arr,int ini,int fin){
    while(ini<=fin){
        arr[ini]+=1;
        ini++;
    }
}

public static int obtenerSuma(int[]arr,int ini,int fin){
    int suma=0;
    while(ini<=fin){
        suma+=arr[ini];
        ini++;
    }
    return suma;
}

public static int obtenerInicio(int[]arr,int pos){
    while(pos<MAX && arr[pos]==SEPARADOR){
        pos++;
    }
    return pos;
}
public static int obtenerFin(int[]arr,int pos){
    while(pos<MAX && arr[pos]!=SEPARADOR){
        pos++;
    }
    return pos-1;
}
}
