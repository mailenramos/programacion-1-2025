public class parcial5 {
    static final int MAXE = 16;

    public static void main(String[] args) {
        int[]empanadas={-1,5,5,7,7,-6,4,9,10,-4,1,1,2,7,-9,-8};
        System.out.println("ingrese la empanada que desea agregar");
        int empanada=ingresarEmpanadaValida();
        System.out.println("ingrese el pedido");
        int pedido=Utils.leerInt();
        agregarEmpanada(empanadas,empanada,pedido);
        mostrarArreglo(empanadas);
    }
    public static void agregarEmpanada(int[] empanadas,int empanada,int pedido) {
        int ini=0, fin=-1;
        int pedidos=0;
        boolean asigno=false;
        while (ini<MAXE && !asigno ) { 
            ini=buscarInicio(empanadas, fin+1);
            if(ini<MAXE){
                fin=buscarFin(empanadas, ini);
                pedidos++;
                if(pedido==pedidos){
                    agregarEmpanada(ini,fin,empanadas,empanada);
                    asigno=true;
                }
            }
        }
        if(!asigno)
        System.out.println("No existe ese pedido");
       
    }
    public static void agregarEmpanada(int ini,int fin,int[]empanadas,int empanada) {
    int pos=buscarPosEmpanada(empanadas, ini, fin, empanada);
    incorporarEmpanada(empanadas, pos, empanada);
    }
    public static int buscarPosEmpanada(int[]empanadas, int ini,int fin, int empanada) {
        int i = ini;
        while(i<=fin && empanadas[i]<empanada){

            i++;
        }
        return i;
    }
    
    public static void incorporarEmpanada(int[]empanadas,int pos, int empanada){
        correrDerecha(empanadas,pos);
        empanadas[pos]=empanada;
    }

    public static void correrDerecha(int[]arr, int pos){
        for(int i=MAXE-1; i>pos;i--){
            arr[i]=arr[i-1];
        }
    }
    
    public static int buscarInicio(int[]arr,int pos){
        int i=pos;
        while(i<MAXE && arr[i]<=0){
            i++;
        }
        return i;
    }

    public static int buscarFin(int[]arr,int pos){
        int i=pos;
        while(i<MAXE && arr[i]>=0){
            i++;
        }
        return i-1;
    }
    public static void mostrarArreglo(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("| "+arr[i]);
        }
        System.err.println();
    }
    
    public static int ingresarEmpanadaValida(){
        int empanada=Utils.leerInt();
        while(empanada<0){
            System.out.println("Ingrese una empanada mayor a 0");
            empanada=Utils.leerInt();
        }
        
        return empanada;
    }
}
