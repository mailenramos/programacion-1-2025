/*La reserva natural Sierra del Tigre desea controlar el ingreso y egreso de vehículos. Para ello, dispone de 
cámaras que identifican las patentes de los vehículos que ingresan y egresan del predio. Los ingresos y 
egresos se registran en dos arreglos arrI y arrE respectivamente. Ambos arreglos son de tamaño MAXA y 
almacenan las patentes como secuencias de caracteres separados por uno o más espacios. 
Por ejemplo, en los siguientes arreglos la patente del primer vehículo en ingresar al predio fue AA 123 ZZ, y el 
primero en egresar fue AB 987 EX. 
ArrI: 
A A 1 2 3 Z Z  P R G 0 1 0  A B 9 8 7 E X   
ArrE: 
A B 9 8 7 E X  A A 1 2 3 Z Z  F O R 0 0 1  
Se debe implementar un programa que verifique, al finalizar el día, que todos los autos que ingresaron hayan 
también egresado del predio. En caso de detectar algún vehículo que no haya egresado se debe almacenar la 
patente en un arreglo arrNoE.  
De igual manera, puede ocurrir que al ingreso del vehículo la patente no quede registrada pero si al egresar. 
En estos casos, se debe almacenar las patentes de los autos que no hayan quedado registrados en el arreglo 
arrI pero si en el arrE, en un arreglo arrNoI. 
Nota: los arreglos arrNoE y arrNoI son de tamaño MAXA y deben almacenar las patentes separadas por uno 
o más espacios.  
Siguiendo con el ejemplo anterior, los arreglos resultantes quedarían de la siguiente forma: 
ArrNoE 
P R G 0 1 0                   
ArrNoI: 
F O R 0 0 1                   
Aclaración: Asumir que cada vehículo puede ingresar o egresar una vez al día.  */
public class ej7comparacion {
    final static int MAX = 24;
    final static char SEPARADOR = ' ';
    public static void main(String[] args) {
        char[] arrI = {' ','A','A','i','2','3','Z','Z',' ','P',' ','G','0','1','0',' ','A','B','9','8','7','E','X',' '};
        char[] arrE = {' ','A','B','9','8','7','E','X',' ','A','A','1','2','3','Z','Z',' ','F','O','R','0','0','1',' '};

        char[] arrNoI = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] arrNoE = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};

        System.out.println("Patentes de ingreso:");
        mostrarArreglo(arrI);
        System.out.println("Patentes de egreso:");
        mostrarArreglo(arrE);
        procesarSecuencia(arrI, arrE, arrNoE);
        procesarSecuencia(arrE, arrI, arrNoI);
        System.out.println("Patentes que no ingresaron:");
        mostrarArreglo(arrNoI);
        System.out.println("Patentes q no egresaron");
        mostrarArreglo(arrNoE);
    }

    //para cada sescuencia del arreglo I:
        //verificar si la secuencia existe en el arreglo E
        //si no existe se agrega en el arreglo NoE

    //para cada sescuencia del arreglo E:
        //verificar si la secuencia existe en el arreglo I
        //si no existe se agrega en el arreglo NoI

    public static void procesarSecuencia( char[] arr, char[] arrAComparar, char[] arrAInsertar){
        int ini = 0;
        int fin = -1;

        while (ini < MAX) {
            ini = buscarInicio(arr, fin + 1);
            if (ini < MAX) {
                fin = buscarFin(arr, ini);
                //determinar si la secuencia i existe en el arreglo e
                
                if(!existeSecuencia(arr, ini, fin, arrAComparar)){
                    insertarSecuencia(arr, ini, fin, arrAInsertar);
                }
            }
        }
    }

    public static void insertarSecuencia(char[] arr, int ini, int fin, char[] arrAInsertar) {
        int i = 1;
        while (ini <= fin) {
            correrDerecha(arrAInsertar, i);
            arrAInsertar[i] = arr[ini];
            i++;
            ini++;
        }
        correrDerecha(arrAInsertar, i);
        arrAInsertar[i] = ' '; 

    }

    public static boolean existeSecuencia(char[] arr, int ini, int fin, char[] arrAComparar) {
        int ini2 = 0;
        int fin2 = - 1;
        boolean existe = false;

        while (ini2 < MAX) {
            ini2 = buscarInicio(arrAComparar, fin2 + 1);
            if (ini2 < MAX) {
                fin2 = buscarFin(arrAComparar, ini2);

                if (compararSecuencias(arr, ini, fin, arrAComparar, ini2, fin2)) {
                    existe = true;
                }
            }  
        }  
        return existe;        
    }

    public static boolean compararSecuencias(char[] arrI, int iniI, int finI,char[] arrE, int iniE, int finE){
        if ((finI - iniI + 1) == (finE - iniE + 1)) {
            while(iniI <= finI && arrI[iniI] == arrE[iniE]){
                iniI++;
                iniE++;
            }

            if(iniI > finI)
                return true;
            return false;
        }
        return false;
    }

    public static void correrDerecha(char[] arr, int pos) {
        for(int i = MAX - 1; i > pos; i --)  {
            arr[i] = arr[i-1];
        }
    }

    public static int buscarInicio(char[] arr, int pos) {
        while (pos < MAX && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos) {
        while (pos < MAX && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarArreglo(char[] arr) {
        for(int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
