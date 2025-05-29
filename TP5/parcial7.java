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
    static final int MAX = 10;
    public static void main(String[] args) {
        char[]arrE= {' ','A','A','1','2','3','Z','Z',' ','P','R','G','0','1','0',' ','A','B','9','8','7','E','X'};
        char[]arrI= {' ',' ','A','B','9','8','7','E','X',' ','A','A','1','2','3','Z','Z',' ','F','O','R','0','0','1',' '};
        char[]arrNoE=new char[MAX];
        char[]arrNoI=new char[MAX];

        registrarPatentes(arrE,arrI,arrNoE,arrNoI);
    }
    
    public static void registrarPatentes(char[]arrE,char[]arrI,char[]arrNoE,char[]arrNoI){
        
    }
}