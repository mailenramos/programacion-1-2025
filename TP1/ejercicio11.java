/*  Escribir un programa que permita el ingreso de un número entero
por teclado e imprima el resultado de determinar:
a. si es múltiplo de 6 y de 7,
b. si es mayor a 30 y múltiplo de 2, o es menor igual a 30,
c. si el cociente de la división de dicho número por 5 es mayor
que 10.
*/
public class ejercicio11 {
    public static void main(String[] args) {
        int entero=0;
        double cociente=0.0;

        System.out.println("Ingrese un numero entero:");
        entero=Utils.leerInt();
        cociente=entero/5;

        System.out.println("El numero es multiplo de 6 y 7?"+((entero%6==0)&&(entero%7==0)));
        System.out.println("El numero es mayor a 30 y multiplo de 2? "+(((entero>30)&&(entero%2==0))+ " es menor igual a 30? " +(entero<=30)));
        System.out.println("El cociente dividido por 5 es mayor que 10?"+ (cociente>10));
    }

    
}
