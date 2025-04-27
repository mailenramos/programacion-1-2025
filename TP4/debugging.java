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
        esPrimoNum=true;
        }
    return esPrimoNum;
    }

    divisor:2
    esPrimoNum:true
    numero: 5
--------------------------------------------------------------------------------------------------------------------------------
*/