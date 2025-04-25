/*Escribir un método que retorne el mayor de dos números. Usar
ese método para calcular el máximo de una serie de números
ingresados por el usuario (20 números en total).
*/

public class ejercicio11 {
    public static void main(String[] args) {
        int num= 0,mayor=0;;
        for(int i=1;i<=20;i++){
            System.out.println("Ingrese el " +i+" numero");
            num =Utils.leerInt();
            mayor=EsMayor(num,mayor);
        }
        System.out.println("El mayor es "+mayor);
    }

    public static int EsMayor(int num,int mayor){
        if(num>mayor){
            mayor=num;
        }
        return mayor;
    }

    }