public class parcial2segundoIntento {
    /*
Asignación de mesas
Cada cliente que ingresa se registra ingresando la cantidad de personas que van a ocupar una mesa. 
El registro se realiza en un arreglo C de tamaño MAXC y cada nuevo registro se pone en la última posición libre. 
4 3 8 6 2 12 0 0 0 0 0 0 0 0 0 0 0 0 0 0

Se tiene un conjunto de mesas disponibles para ser ocupadas según su capacidad.
2 3 5 6 12
Se pide implementar un programa en Java que asigne a cada cliente (cantidad de personas) en el arreglo C,
una mesa del arreglo M. La asignación debe realizarse en el orden en que aparecen los pedidos de mesa en
el arreglo C y considerando, en todo momento, una asignación eficiente del espacio, esto es, la mesa
asignada debe ser aquella que deje menos cantidad de lugares sin ocupar (y que ya no haya sido asignada).
Para indicar que una mesa ya ha sido asignada, la capacidad debe ser cambiada por el valor original pero
negativo. Una vez realizada la asignación se debe eliminar el valor del arreglo C. 
En caso de no existir una mesa disponible con la capacidad necesaria, se debe informar que no se pudo asignar y se debe conservar el valor en el arreglo.
Si la cantidad de pedidos de mesa fuera superior a la cantidad de mesas disponibles, se debe informar que no
quedan más mesas cuando éstas hayan sido todas asignadas. 
Siguiendo el ejemplo, el arreglo resultante sería:
-2 -3 -5 -6 -12
Las asignaciones deben ser impresas por consola. En este ejemplo, las asignaciones serían: “El cliente 1 se
asignó a la mesa 2”, “El cliente 2 se asignó a la mesa 1”, “El cliente 3 se asignó a la mesa 4”, “El cliente 4 se
asignó a la mesa 3”, “El cliente 5 se asignó a la mesa 0” y “No quedan más mesas para asignar clientes”
El arreglo C resultante sería:
12 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     */
    public static void main(String[] args) {
        int[]C={4, 3, 8, 6, 2 ,12, 0,  0, 0, 0, 0 ,0, 0, 0, 0, 0, 0, 0 ,0 ,0};
        int[]M={2, 3, 5, 6, 12};

        asignarMesas(C,M);
        mostrarArreglo(C);
        mostrarArreglo(M);
    }

    public static void asignarMesas(int[]C,int[]M){
        boolean asignado = false;
        int i = 0, cantMesasAsignadas = 0,mesasTotales = M.length;
        while(i<C.length && C[i]!=0 ){
            if(cantMesasAsignadas<mesasTotales){
                for(int j=0; j<M.length;j++){
                    if(C[i]<=M[j] && M[j]>0){
                        System.out.println("El cliente "+C[i]+" se asignó a la mesa "+M[j]);
                        asignarMesa(M,j);
                        borrarPedido(C,i);
                        asignado=true;
                        break;
                    }
                }
            }else{
                System.out.println("Ya no hay mesas disponibles");
            }

            if(!asignado){
                System.out.println("No se pudo asignar al cliente "+C[i]);
                i++;
            }

        }
    }
    
    public static void asignarMesa(int[]M,int j){
        M[j]= -M[j];
    }

    public static void borrarPedido(int[]C,int pos){
        for(int i=pos;i<C.length-1;i++){
            C[i]=C[i+1];
        }
    }
    public static void mostrarArreglo(int[]arr){
        for(int i=0; i<arr.length;i++){

            System.out.print("|"+arr[i]);
        }
        System.out.println();
    }
}