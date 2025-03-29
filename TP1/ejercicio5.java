/* Escribir un programa que solicite nombre, edad, altura y ocupación, y
los imprima por pantalla.*/
public class ejercicio5 {
    public static void main(String[] args) {
        String nombre,ocupacion;
        int edad;
        double altura;
        System.out.println("ingrese su nombre");
        nombre= Utils.leerString();
        System.out.println("ingrese su edad");
        edad= Utils.leerInt();
        System.out.println("ingrese su altura");
        altura= Utils.leerDouble();
        System.out.println("ingrese su ocupación");
        ocupacion= Utils.leerString();
        System.out.println("Nombre: "+ nombre +"\n"+"edad: "+ edad +"\n"+"Altura: "+ altura +"\n"+"Ocupacion: "+ocupacion+"\n");
    }
}
