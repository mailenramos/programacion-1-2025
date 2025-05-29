/*
Se debe implementar un programa que verifique, al finalizar el día, que todos los autos que ingresaron hayan
también egresado del predio. 
En caso de detectar algún vehículo que no haya egresado se debe almacenar la patente en un arreglo arrNoE.

De igual manera, puede ocurrir que al ingreso del vehículo la patente no quede registrada pero si al egresar.
En estos casos, se debe almacenar las patentes de los autos que no hayan quedado registrados en el arreglo
arrI pero si en el arrE, en un arreglo arrNoI.
Nota: los arreglos arrNoE y arrNoI son de tamaño MAXA y deben almacenar las patentes separadas por uno
o más espacios.
Aclaración: Asumir que cada vehículo puede ingresar o egresar una vez al día.
 */
public class parcial7 {
    static final int MAX=25;
    public static void main(String[] args) {
        int[]arrI={' ','A','A','1','2','3','Z','Z',' ','P','R','G','0','1','0',' ','A','B','9','8','7','E','X',' ',' '};
        int[]arrE={' ',' ','A','B','9','8','7','E','X',' ','A','A','1','2','3','Z','Z',' ','F','O','R','0','0','1',' '};
        int[]arrNoE={' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        int[]arrNoI={' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        detectarVehiculosEgresados(arrI,arrE,arrNoE);
    }

    public static void detectarVehiculosEgresados(int[]arrI,int[]arrE,int[]arrNoE){
        int ini=0,fin=-1;
        while(ini<MAX){
            ini=buscarInicio(arrI,fin+1);
            if(ini<MAX){
                fin=buscarFin(arrI,ini);

            }
        }
    }
}