/*Escribir un programa que declare una constante de tipo int y pida el
ingreso de un valor por teclado (hacer uso de Utils.java). Luego
muestre el valor ingresado. ¿Qué pasa en este caso? ¿Se puede o
surge algún problema?
 */
public class ejercicio3 {
    public static void main(String[] args) {
        final int entero;

        System.out.println("Ingrese un numero entero");
        entero = Utils.leerInt();

        System.out.println("El numero ingresado es: "+entero);
    }
}
