/*
Se debe implementar un programa que verifique, que todos los autos que ingresaron hayan también egresado del predio. 
En caso de detectar algún vehículo que no haya egresado se debe almacenar la patente en un arreglo arrNoE.
De igual manera, puede ocurrir que al ingreso del vehículo la patente no quede registrada pero si al egresar.
En estos casos, se debe almacenar las patentes de los autos que no hayan quedado registrados en el arreglo
arrI pero si en el arrE, en un arreglo arrNoI.

Nota: los arreglos arrNoE y arrNoI son de tamaño MAXA y deben almacenar las patentes separadas por uno
o más espacios.

 */
public class parcial7MAI {
    static final int MAX = 25;
    static final char SEPARADOR = ' ';
    public static void main(String[] args) {
        char[]arrI= {' ',' ','A','B','9','8','7','E','X',' ','A','A','1','2','3','Z','Z',' ','F','O','R','0','0','1',' '};
        char[]arrE= {' ','A','A','1','2','3','Z','Z',' ','P','R','G','0','1','0',' ','A','B','9','8','7','E','X',' ',' '};
        char[]arrNoE=new char[MAX];
        char[]arrNoI=new char[MAX];

        registrarPatentes(arrE,arrI,arrNoE,arrNoI);
    }
    
    public static void registrarPatentes(char[]arrE,char[]arrI,char[]arrNoE,char[]arrNoI){
        int ini=0,fin=-1;
        int patente=0;
        while(ini<MAX){
            ini=buscarInicio(arrI,fin+1);
            if(ini<MAX){
                fin=buscarFin(arrI,ini);
                patente++;
                System.out.println("Patente "+patente+" ArrI");
                Salio(arrI,ini,fin,arrE);
                
            }
            System.out.println("------------------------------------------------");
        }
    }
    public static void Salio(char[]arrI,int ini,int fin,char[]arrE) {
         int iniE=0,finE=-1;
         int largoSec=fin-ini+1;
         int patente=0;
         boolean noSalio=false;

        while(iniE<MAX){
            iniE=buscarInicio(arrE,finE+1);
            if(iniE<MAX){
                finE=buscarFin(arrE,iniE);
                patente++;
                int largoSec2=finE-iniE+1;
                
                if( largoSec==largoSec2){
                    int pos= VerificarIgualdad(arrI,ini,fin,arrE,iniE,finE);
                     if(pos!=fin){
                        noSalio=true;
                     }
                }
            }
        }
    }

    public static int VerificarIgualdad(char[]arrI,int ini,int fin,char[]arrE,int iniE,int finE) {
        int i=ini;
        int iE=iniE;

        while (i<fin && arrI[i]==arrE[iE]){
            i++;
            iE++;    
        }
        return i;
    }

     public static int buscarInicio(char[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int buscarFin(char[] arr, int pos) {
        int i = pos;
        while (i < MAX && arr[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }

    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("| " + arr[i]);
        }
        System.out.println();
    }
}