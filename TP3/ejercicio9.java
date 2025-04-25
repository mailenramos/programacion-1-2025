/* . Escribir un programa que mientras el usuario ingrese un número
entero entre 1 y 10, pida ingresar un carácter, y por cada carácter
ingresado imprima:
a. “letra minúscula” si el carácter es una letra del abecedario en
minúscula;
b. “letra mayúscula” si el carácter es una letra del abecedario
en mayúscula;
c. “dígito” si el carácter corresponde a un número;
d. “otro” para los restantes casos de caracteres.*/
public class ejercicio9{
    public static void main(String[] args) {
        char caracter = ' ';
        System.out.println("ingrese unn numero");
        int num1=Utils.leerInt();
            while (num1>=1 && num1<=10) {
                System.out.println("Ingrese un caracter");
                caracter=Utils.leerChar();
                if (EsMinuscula(caracter)){
                    System.out.println("es minuscula");
                }else if(EsMayuscula(caracter)){
                    System.out.println("es mayuscula");
                }else if(EsDigito(caracter)){
                    System.out.println("es digito");
                }else{
                    System.out.println("es otro");
                }
                System.out.println("ingrese un numero");
                num1=Utils.leerInt();
                }
            System.out.println("sali del while");
        
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
          
    } 

