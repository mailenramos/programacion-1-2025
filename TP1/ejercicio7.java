/*Escribir un programa que dado tres números reales ingresados
por el usuario, divida el primero por el segundo y al resultado
obtenido le reste el tercero. Muestre por pantalla el resultado
obtenido. Puede o no usar variables auxiliares para los cálculos.
¿Puede ocurrir algún error? */
public class ejercicio7 {
    public static void main(String[] args) {
    double numeroReal1=0,numeroReal2=0, numeroReal3=0,resultado=0;
    System.out.println ("Ingrese 3 numeros reales");
    numeroReal1=Utils.leerDouble();
    numeroReal2=Utils.leerDouble();
    numeroReal3=Utils.leerDouble();
    resultado=(numeroReal1/numeroReal2)-numeroReal3;
    System.out.println("el resultado es: "+resultado);
    }
    /*el resultado es: Infinity cuando el numReal2 tiene el valor de 0 */
}
