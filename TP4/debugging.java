/* 
  Para los siguientes métodos verificar su funcionamiento por medio
de algunas de las técnicas aprendidas y corregir los errores si
hubiesen:

a. public static int obtenerFactorial(int numero){
 // obtiene el factorial de numero
    int resultado=numero;               
    while (numero>0)--->El limite deberia ser 1 ya que en la ultima vuelta restamos el 1 y terminamos multiplicando por 0
    resultado*=--numero;
    return resultado;
}
    numero: 5,4,3,2,1
    resultado:5,20,60,120,120
    numero>0: T,T,T,T,F
--------------------------------------------------------------------------------------------------------------------------------

b. public static int obtenerSumatoria(int natural){
    // obtiene la sumatoria de los primeros n naturales
    int resultado=1;
    while (natural>0)--->El limite deberia ser 1 ya que en la ultima vuelta restamos el 1 y terminamos multiplicando por 0
    resultado+=natural--;
    return resultado;

    resultado:1,6,10,13,15,16
    natural:5,4,3,2,1,0

    En el While natural>1
}


-------------------------------------------------------------------------------------------------------------------------------- 
c. public static boolean esPrimo(int numero) {
    // devuelve si es primo el numero o no
    int divisor=2;
    boolean esPrimoNum=true;
    if (numero < 2)
        return false;
    while (divisor < numero && esPrimoNum){
        if (numero%divisor++==0)
        esPrimoNum=true;------> error , tiene q ser false "un numero primo solo es divisible por 1 y si mismo , si es divisible por otro numero no es primo"
        }
    return esPrimoNum;
    }


--------------------------------------------------------------------------------------------------------------------------------
d. public static int buscarMayor(int a, int b, int c) {
// retorna el mayor de los 3 números
    int mayor = a;
        if (b > mayor) {
            mayor = b;
        }
        if (c > mayor) {
            mayor = c;
        }
    return mayor;
}
ESTA BIENNN
a=5
b=10
c=8
mayor=5-10
(b > mayor)=true
(c > mayor)=false

 ------------------------------------------------------------------------------------------------

 e. public static int contarDigitos(int n) {
    int contador = 0;
        while (n != 0) {
         n /= 10;
        contador++;
        }
    return contador;
    }
ESTA BIENN
    contador=0-1-2-3
    n=830-83-8-0
  
 -----------------------------------------------------------------------------------------------------



 f. public static boolean buscarDigito(int num, int digito) {
// determina si en num está presente un determinado dígito
    boolean encontrado = false;
    int resto;
        while (num > 0) {
        resto = num % 10;
            if (resto == digito) {
                encontrado = true;
            } 
            else {-----------------------> el else no es necesario, ni cambiar encontrado a false
                encontrado = false;--------->no va
            }
            num = num / 10;
        }
        return encontrado;
    }

    encontrado=false-true-false
    resto=7-8
    num=87-8-0
    digito=7


 ------------------------------------------------------------------------------------------------------------
g. public static int divisorComunMaximo(int num1, int num2){
    int dcm = 1;
    int divisor = 2;
        while (divisor < num1 && divisor < num2) {
            if (num1 % divisor == 0 && num2 % divisor == 0) {
                dcm = divisor;
            }
            divisor++;
        }
        return dcm;
    }
        ESTA BIENNNn!!!
    dcm=1-2
    divisor=2-3-4-5-6-7-8

    num1=8
    num2=10

 

 -------------------------------------------------------------------------------------------------------------
h. public static String decimalABinario(int num) {
// convierte un número decimal a su representación
binaria
 String binario = "";
    while (num > 0) {
        int resto = num % 2;
        binario = resto + binario;-------->Se está concatenando, el int se convierte y concatena como un String
        num = num / 2;
    }
 return binario;
}  ESTA BIENNNn!!!

num = 5
binario= 1
resto = 1


*/public class debugging {

    public static void main(String[] args) {
        System.out.println(5%2);
    }
} /*
 Un comercio de la ciudad, que realiza horario de corrido de 8:30hs a 19hs, 
necesita un programa que responda si está abierto o cerrado
cuando un usuario/cliente ingresa una hora determinada (hora y minutos).


public class ComercioHorario {
    public static int obtenerEntero(int inf, int sup) {
        // retorna un valor entero mayor o igual a inf y menor o
        igual a sup
    }
    public static void main(String[] args) {
        int horaApertura = 8; 
        int minutoApertura = 30; 
        int horaCierre = 19; 
        int minutoCierre = 0;
        int hora = obtenerEntero(0, 23);
        int minuto = obtenerEntero(0, 59);

    // Comprobamos si la hora ingresada está dentro del horario de apertura y cierre
    if  (hora > horaApertura || 
        (hora == horaApertura && minuto >= minutoApertura) && hora < horaCierre ||
        (hora == horaCierre && minuto <= minutoCierre)) {

        System.out.println("El comercio está abierto.");
    } else {
        System.out.println("El comercio está cerrado.");
    }
 }
    horaApertura=8
    minutoApertura=30
    horaCierre=19
    minutoCierre=0
    hora=18
    minuto=30

    hora > horaApertura || = false
    (hora == horaApertura && minuto >= minutoApertura) && hora < horaCierre || =false
    (hora == horaCierre && minuto <= minutoCierre = false
*/