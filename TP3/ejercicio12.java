/*Escribir un programa que simule 1000 lanzamientos de un dado
y muestre por pantalla cuántas veces salió el valor del dado
correspondiente al número entero N ingresado por el usuario.
Considerar que el valor N ingresado se corresponda a un valor
posible para un dado. Usar la sentencia Math.random() que
devuelve un valor aleatorio real entre 0 y 1.
Para asignar un posible valor a la variable dado entero:
dado = (int) (6*Math.random() + 1) */
public class ejercicio12 {
    public static void main(String[] args) {
        int num=0, contador=0, random=0;
        System.out.println("Ingrese un numero para adivinar del 1 al 6 ");
        num=Utils.leerInt();
        while(num>=1&&num<=6){
            for(int i=1;i<=1000;i++){
                random=(int)(7*Math.random());
                if(random==num)
                contador++;
            }
            System.out.println("El dado coincidió "+contador+" veces con el número "+num);

            System.out.println("Ingrese un numero para adivinar del 1 al 6 ");
            num=Utils.leerInt();
        }
        System.out.println("El numero ingresado no esta en el rango");
    }
    
}
