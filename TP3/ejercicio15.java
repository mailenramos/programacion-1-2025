/*Escribir un programa que mientras que el usuario ingrese un
número entero natural, llame a un método que calcule la
sumatoria desde 1 a dicho número (Ej: si n= 5 sumatoria =
1+2+3+4+5=15) y retorne el resultado.
 */
public class ejercicio15 {
    public static void main(String[] args) {
        int num;
        int sumatoria;
        System.out.println("Ingrese un numero para calcular la sumatoria desde 1 a dicho numero");
        num=Utils.leerInt();
        while (num>0) {
            sumatoria=sumatoria(num);
            System.out.println("La sumatoria es: "+sumatoria);
            System.out.println("Ingrese un numero para calcular la sumatoria desde 1 a dicho numero");
            num=Utils.leerInt();
        }
        System.out.println("el numero ingresado es invalido");
        
    }
    public static int sumatoria(int num){
        int sumatoria=0;
        for (int i=1;i<=num;i++){
            sumatoria+=i;
        }
        return sumatoria;
    }
    
}
