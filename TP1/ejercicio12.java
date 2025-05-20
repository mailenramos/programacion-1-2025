/*Escribir un programa que permita ingresar dos números enteros,
incremente el primero y decremente el segundo, para luego
mostrar por pantalla en ambos casos, el valor original y el
modificado */
public class ejercicio12 {
    
}

public stattic int obtenerInicio(int[]arr,int pos){
    while (pos<MAX && arr[pos]==0) {
        pos++;
    }
    return pos;
}
public stattic int obtenerFin(int[]arr,int pos){
    while (pos<MAX && arr[pos]!==0) {
        pos++;
    }
    return pos-1;
}