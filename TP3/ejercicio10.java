/*Escribir un programa que mientras el usuario ingrese un
número entero entre 1 y 10 realice:

a. Si el numero ingresado es múltiplo de 3 pida ingresar un
caracter y para el caracter ingresado imprima a qué tipo de
carácter está asociado:

i. “letra minúscula” si el carácter es una letra del
abecedario en minúscula;
ii. “letra mayúscula” si el carácter es una letra del
abecedario en mayúscula;
iii. “dígito” si el carácter corresponde a un número;
iv. “otro” para los restantes casos de caracteres.

b. Si el número ingresado es múltiplo de 5 imprima la tabla de
multiplicar del número ingresado. */
public class ejercicio10 {
    
    public static void main(String[] args) {
        int num=0;
        System.out.println("ingrese un numero del 1 al 10");
        num=Utils.leerInt();
        char caracter=' ';
            while (num>=1 && num<=10) {
                if (num%3==0){
                    System.out.println("ingrese un caracter");
                    caracter=Utils.leerChar();
                    if(EsMinuscula(caracter)){
                        System.out.println("es minuscula");
                    }else if (EsMayuscula(caracter)){
                        System.out.println("es mayuscula");    
                    }else if (EsDigito(caracter)) {
                        System.out.println("es digito");
                    }else{
                        System.out.println("es otro");
                    }
                }
                if (num%5==0){
                    imprimirtabla(num);
                }
                System.out.println("ingrese un numero del 1 al 10");
                num=Utils.leerInt();    
            }
            System.out.println("opcion no valida");
    }
    public static boolean EsMinuscula(char caracter){
        return ((caracter>='a') && (caracter<='z'));
    }
    public static boolean EsMayuscula(char caracter){
        return ((caracter>='A') && (caracter<='Z'));
    }
    public static boolean EsDigito(char caracter){
        return ((caracter>='0') && (caracter<='9'));
    }
    public static void imprimirtabla(int num) {
        for(int i=1;i<=10;i++){
            System.out.println(num+"*"+i+"="+num*i);
        }
        
    }
}
