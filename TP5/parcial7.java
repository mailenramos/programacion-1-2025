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

        registrarEgresos(arrE,arrI,arrNoE,arrNoI);
        mostrarArreglo(arrNoI);
    }
    
    public static void registrarEgresos(char[]arrE,char[]arrI,char[]arrNoE,char[]arrNoI){
        int ini=0,fin=-1;
        int cantEgresos=0;
        int iniNoEgreso=0,finNoEgreso=0;


        while(ini<MAX){
            ini=buscarInicio(arrI,fin+1);
            if(ini<MAX){
                fin=buscarFin(arrI,ini);
                cantEgresos=buscarEgresos(arrI,ini,fin,arrE);
                if(cantEgresos==0){
                    iniNoEgreso=ini;
                    finNoEgreso=fin;
                    System.out.println("ini: "+iniNoEgreso+" fin: "+finNoEgreso);
                    insertarPatente(arrNoE,iniNoEgreso,finNoEgreso,arrI);
                }
            }
        }
    }

    public static void insertarPatente(char[]arrNoE,int ini,int fin,char[]arrI){
        int i=1;
        int j=ini;
        int largo=fin-ini+1;
        while(i<MAX && i<largo){
            arrNoE[i]=arrI[j];
            i++;
            j++;
        }
    }

    public static int buscarEgresos(char[]arrI,int ini,int fin,char[]arrE){
        int ini2=0, fin2=-1;
        int largo1=fin-ini+1;
        int cantEgresos =0;
        while(ini2<MAX){
            ini2=buscarInicio(arrE,fin2+1);
            if(ini2<MAX){
                fin2=buscarFin(arrE,ini2);
                int largo2=fin2-ini2+1;

                boolean salio = comprobarEgreso(largo1,largo2,arrI,ini,fin,arrE,ini2);
                if(salio){
                    cantEgresos++;
                }
            }
        }
        return cantEgresos;
    }
    
    public static boolean comprobarEgreso(int largo1,int largo2,char[]arrI,int ini,int fin,char[]arrE,int ini2){
        boolean salio=false;

        if(largo1==largo2){
                    int i=compararPatentes(arrI,ini,fin,arrE,ini2);
                    if(i==fin){
                        salio=true;
                    }
                }

        return salio;
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