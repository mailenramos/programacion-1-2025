/* ANALISIS DE CODIGO


public class Practica_3_Bonus_1 {
    public static void main (String [] args){
        int resultado=0;
        System.out.println(“Tabla de multiplicar del 7”);
        resultado=imprimirTabla7(resultado);--->no debe ser contenida por resultado y en caso de pasar resultado como un parametro
                                                tambien la funcion debe recibirlo(en este caso no , es de tipo VOID)
    }
    public static void imprimirTabla5(){ ---> la funcion es de tipo VOID, no retorna 
        for (int i = 1 ; i <= 10; i++) {
        System.out.println(5*i);-----> DEBE SER 7*i
        }
    }
}

---------------------------------------------------------------------------------------------------------------------------------
public class Practica_3_Bonus_2 {
    public static void main(String []args){
        char letra=’a’;
        letra=Utils.leerChar();
            if (letra>=‘a’ && letra<=‘z’){------> deberia usar comilla simple ''
                System.out.println(“Es una letra minuscula”);
            }
    }
}
----------------------------------------------------------------------------------------------------------------------------------

public class Practica_3_Bonus_3 {
    public static int numero = 2;----->no es la forma correcta de declarar una constante --> final static int numero=2;
        public static void main(String[] args) {
            int b = 3;
            {
            System.out.println (a + ", " + numero);-----> la variable a aun no esta declarada y numero no es una const valida
            int b = 2;
            int a = 5;
            System.out.println (a + ", " + b);
                {
                    int c = 7;
                    System.out.println (a + ", " + b + ", " + c);
                }
            System.out.println (a + ", " + b + ", " + c);----> no va a poder mostrar C porque esta en otro bloque al que no puede acceder
            }
        }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------    
a. Escribir un programa que llame un método que calcule el
promedio de la suma de valores enteros entre 1 y 1000.
Finalmente, el promedio debe mostrarse por pantalla

public class Practica_3_Bonus_4 {
    public static final int MAX = 1, MIN = 1000;------>Deberia ser MAX=1000 y MIN=1

    public static void main(String[] args) {
        System.out.println("El promedio de la suma entre " MIN " y
        " MAX " es "+ calcular_promedio());------------> deberia estar contenida por otra variable , para guardar el valor y no perderlo
    }

    public static char calcular_promedio(int MAX, int MIN) {-------> debe returnar un double , no char
        int suma = 0;
        int numero = MIN;
            for (; numero <= MAX; numero++) {--------> ; no va al principo, y sus valores estan mal 
            suma += numero;
            }
        return suma/(MAX-MIN+1);--------------------> debe ser return (double) suma / (max - min + 1);

    }
}
Dados dos números positivos y un carácter opción cuyo
valor es una letra minúscula ‘s’ o ‘r’ (únicamente puede
tomar estos dos valores), obtener la suma de ambos
números si la opción es ‘s’ o si es ‘r’ se debe restar el
primero al segundo.

public class Practica_3_Bonus_5 {
    public static void main(String[] args) {
        int numero1=235; // valor de ejemplo
        int numero2=-5; //-------->no debe ser negativo , podria crear una funcion obtenerPositivo();
        char opcion=’s’;
        resolver(opcion,numero1,numero2);----- debe enviar los parametro en el mismo orden correcto de dicha funcion (numero1,numero2,opcion)
    }
    public static void resolver(int num1, int num2, char op){
        if (op==’s’){--------------------------------------------->debe usar comillas simples 
            System.out.println("La suma es: "+num1+num2);-----------> falta un parentesis en la suma
        }
        else if (op==’r’){---------------------------------------->debe usar comillas simples 
            System.out.println("La resta es:"+num1-num2);------------>falta un parentesis en la suma
        }
        else
            System.out.println("Opción no válida”);
    }
}
*/


