/* Escribir un programa que imprima por pantalla los números
perfectos que existen entre 2 y 10000.

Un número perfecto es que cuya suma de sus divisores (excepto sí mismo) es igual al
propio número. 

Ejemplo: 6 es un número perfecto dado que sus
divisores (excepto sí mismo) son 1, 2 y 3 cuya suma da 6. En
cambio 12, no es un número perfecto dado que sus divisores
(excepto sí mismo) 1, 2, 3, 4 y 6 cuya suma es 16.*/

public class ejercicio18 {
    public static void main(String[] args){
        for (int i=2 ;i<=10000;i++){
            int sumatoria=0;
            for( int j=1;j<i;j++){
                if(i%j==0){
                    sumatoria+=j;
                }
            }
            if(sumatoria==i){
                System.out.println(i+"es numero perfecto");
            }
        }

    }
}
