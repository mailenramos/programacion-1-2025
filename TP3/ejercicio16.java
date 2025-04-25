/*Escribir un programa que mientras el usuario ingresa un
número de mes (entero) entre 1 y 12 inclusive, muestre por
pantalla la cantidad de días del mes ingresado (suponer febrero
de 28 días) (Mostrar por pantalla la cantidad de días del mes
debería realizarse con un método).
 */
public class ejercicio16 {
    public static void main(String[] args) {
        int mes;
        System.out.println("Ingrese un numero del 1 al 12");
        mes=Utils.leerInt();
        while(mes>=1&&mes<=12){
            determinarMes(mes);
            System.out.println("Ingrese un numero del 1 al 12");
            mes=Utils.leerInt();
        }
    }
    public static void determinarMes(int mes){
        switch (mes) {
            case 1,3,5,7,8,9,12:
                System.out.println("El mes tiene 31 dias");
                break;
            case 2,4,6,10,11:
                System.out.println("El mes tiene 30 dias");
            default:
                break;
        }
    }
}
