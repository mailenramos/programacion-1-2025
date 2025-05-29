/*
Se debe implementar un programa que verifique, que todos los autos que ingresaron hayan también egresado del predio. 
En caso de detectar algún vehículo que no haya egresado se debe almacenar la patente en un arreglo arrNoE.
De igual manera, puede ocurrir que al ingreso del vehículo la patente no quede registrada pero si al egresar.
En estos casos, se debe almacenar las patentes de los autos que no hayan quedado registrados en el arreglo
arrI pero si en el arrE, en un arreglo arrNoI.

Nota: los arreglos arrNoE y arrNoI son de tamaño MAXA y deben almacenar las patentes separadas por uno
o más espacios.

 */
public class parcial7 {
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

        while(ini<MAX){
            ini=buscarInicio(arrI,fin+1);
            if(ini<MAX){
                fin=buscarFin(arrI,ini);

                buscarPatentes(arrI,ini,fin,arrE);
                
            }
        }
    }

    public static void buscarPatentes(char[]arrI,int ini,int fin,char[]arrE){
        int ini2=0, fin2=-1;
        int i =0;
        int ubicacionPatente=0;
        
        
        while(ini2<MAX){
            ini2=buscarInicio(arrE,fin+1);
            if(ini2<MAX){
                fin2=buscarFin(arrE,ini);
                ubicacionPatente++;
                if((fin-ini+1)==(fin2-ini2+1)){
                    i=compararPatentes(arrI,ini,fin,arrE,ini2);
                    if(i!=fin){
                        System.out.println("La patente "+ubicacionPatente+" no egresó");
                    }
                }
            }
        }
    }

    public static int compararPatentes(char[]arrI,int ini,int fin,char[]arrE,int ini2){
        int i = ini;
        int i2= ini2;
        while(i<=fin && arrI[i]==arrE[i2]){
            i++;
            i2++;
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