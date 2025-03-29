/* Escribir un programa que permita ingresar 5 números de a uno por
vez y que los muestre por pantalla en orden inverso:
Ejemplo: Ingreso: 23, 4, 2, 100, 3
Se debe mostrar: 3, 100, 2, 4, 23*/
public class ejercicio4 {
    public static void main(String[] args) {
        int num1,num2,num3,num4,num5;
        System.out.println("ingrese n1:");
        num1= Utils.leerInt();
        System.out.println("ingrese n2:");
        num2= Utils.leerInt();
        System.out.println("ingrese n3:");
        num3= Utils.leerInt();
        System.out.println("ingrese n4:");
        num4= Utils.leerInt();
        System.out.println("ingrese n5:");
        num5= Utils.leerInt();
        System.out.println("Numero al reves:"+num5+num4+num3+num2+num1);
    }
}
