/*Escribir un programa que permita el ingreso de dos números
enteros por teclado e imprima:
a. si el primero es mayor al segundo.
b. si ambos son múltiplos de 2.
 */
public class ejercicio10 {
    public static void main(String[] args) {
        double num1=0,num2=0;
        System.out.println("ingrese 2 numeros reales");
        num1=Utils.leerDouble();
        num2=Utils.leerDouble();
        System.out.println("El primer numero es mayor al segundo? "+(num1>num2));
        System.out.println("Ambos numeros son multiplos de 2? "+((num1%2==0)&&(num2%2==0)));
    }
    
}
        