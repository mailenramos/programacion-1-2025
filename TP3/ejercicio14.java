/*4. Escribir un programa que mientras el usuario ingresa un
carácter distinto del carácter ‘*’, invoque a un método que imprima
si es carácter dígito o carácter letra minúscula, y si es letra
minúscula imprimir si es vocal o consonante.
 */
public class ejercicio14 {
    public static void main(String[] args) {
        char caracter = ' ';
        System.out.println("Ingrese un carácter. '*' para terminar");
        caracter=Utils.leerChar();
        while(caracter!='*'){
            procesarCaracter(caracter);
            System.out.println("Ingrese un carácter. '*' para terminar");
            caracter=Utils.leerChar();
        }
    }
    public static void procesarCaracter(char caracter){
        if(EsDigito(caracter))
        System.out.println("Es un digito");
        else if(EsMinuscula(caracter)){
            System.out.println("Es minuscula ");
            determinarVocal_Consonante(caracter);
        }
    }
    public static void determinarVocal_Consonante(char caracter){
       if (caracter=='a' ||caracter=='e'||caracter=='i'||caracter=='o'||caracter=='u'){
        System.out.println("es vocal");
       }else{
        System.out.println("es consonante");
       }
       
    }
    public static boolean EsDigito(char caracter){
        return ((caracter>='0') && (caracter<='9'));
    }
    public static boolean EsMinuscula(char caracter){
        return ((caracter>='a') && (caracter<='z'));
    }
}
