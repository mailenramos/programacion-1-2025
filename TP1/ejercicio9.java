/* Escribir un programa que permita el ingreso de un número entero
por teclado e imprima el cociente de la división de dicho número
por 2, 3, y 4. En base a los resultados obtenidos analice cada
caso si es correcto o no*/
public class ejercicio9 {
    public static void main(String[] args) {
        int num1=0;
        System.out.println("Ingrese un numero entero");
        num1=Utils.leerInt();

        System.out.println(num1/2);
        System.out.println(num1/3);
        System.out.println(num1/4);

        
    }
}
