/*Escribir un programa que imprima por pantalla la tabla de verdad
para los operadores lógicos or y and (por separado) para dos
valores booleanos. Utilizar los operadores para calcular el
resultado. Por ejemplo, imprimir el siguiente caso para el operador
or:
false or true es: true
y se genera con:
System.out.println(“ false or true es: ” + (false || true)); */
public class ejercicio8 {
    public static void main(String[] args) {
        System.out.println("TABLA OR");
        System.out.println("true || true: "+(true || true));
        System.out.println("true || false: "+(true || false));
        System.out.println("false || true: "+(false || true));
        System.out.println("false || false: "+(false || false));
        System.out.println("TABLA AND");
        System.out.println("true && true: "+(true && true));
        System.out.println("true && false: "+(true && false));
        System.out.println("false && true: "+(false && true));
        System.out.println("false && false: "+(false && false));
    }
    
}
