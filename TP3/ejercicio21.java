/*intenta determinar si corresponde a una señal
inteligente de vida extraterrestre. Para este proyecto, se pide un

programa que permita ingresar valores enteros positivos (si ingresa 0 termina el turno del operador) que
representan diferentes intensidades captadas por el radiotelescopio.

 En el inicio del turno (antes de ingresar los
valores ), el operador indica el tipo de patrón a
buscar (1 o 2) y la cantidad de repeticiones de dicho patrón. 

Hay dos tipos de patrones 
- Patrón primo (1): la intensidad captada es un número primo.
- Patrón divisor (2): la intensidad captada es múltiplo de la unidad de la propia intensidad (Ej: el 357 cumple
porque 357 es múltiplo de 7, mientras que 837 no)


El programa debe indicar que se halló el patrón buscado cuando
haya habido tantas repeticiones del patrón como lo indicó el
operador 
(luego de hallar un patrón las repeticiones comienzan
nuevamente desde 0). 
Al finalizar el turno, se debe indicar la
cantidad de patrones hallados durante el mismo */
public class ejercicio21 {
public static void main(String[] args) {
    int num = 0, tipoPatron, cantRepeticiones;
        int contador = 0; // usamos un solo contador
        int patronesHallados = 0;

        System.out.println("Ingrese el tipo de patrón a buscar (1 = primo, 2 = divisor):");
        tipoPatron = Utils.leerInt();
        System.out.println("Ingrese la cantidad máxima de repeticiones del patrón:");
        cantRepeticiones = Utils.leerInt();

        System.out.println("Ingrese un número entero (0 para terminar):");
        num = Utils.leerInt();

        while (num > 0) {
            if (cumplepatron(num, tipoPatron)) {
                contador++;
                if (contador == cantRepeticiones) {
                    if (tipoPatron == 1) {
                        System.out.println("Se halló un patrón primo.");
                    } else {
                        System.out.println("Se halló un patrón divisor.");
                    }
                    patronesHallados++;
                    contador = 0; // reiniciar repeticiones
                }
            } else {
                contador = 0; // si no cumple, reiniciar
            }

            System.out.println("Ingrese un número entero (0 para terminar):");
            num = Utils.leerInt();
        }

        System.out.println("Terminó su turno. Cantidad de patrones hallados: " + patronesHallados);
}
public static boolean cumplepatron(int num,int tipoPatron){
    if(tipoPatron==1){
        if(esPrimo(num)){
            return true;
        }
    }else if(tipoPatron==2){
        if(num%(num%10)==0){
            return true;
        } 
    }return false;
}
public static boolean esPrimo(int numero) {
    int divisor=2;
    if (numero < 2)
      return false;
    while (divisor < numero){

      if (numero%divisor==0)
        return false;
      divisor++;
    }
    return true;
  }
    
}
