
public class ej2{
static final int MAXC = 20;
static final int MAXM = 5;
static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[]C ={4,3,8,6,2,12,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[]M={2,3,5,6,12};

        AsignarMesaACliente(C,M);
    }    
    public static void AsignarMesaACliente(int[]C,int[]M){
        int i=0, cliente=1,mesasAsignadas=0;
        while(i<MAXC && C[i]!=SEPARADOR && mesasAsignadas<MAXM){
            int mesa=buscarMesa(C[i],M);
            if(mesa<MAXM){
                AsignarMesa(M,mesa);
                SuprimirCliente(C,i);
                System.out.println("Al ciente "+cliente+" se le asignó la mesa "+mesa);
                mesasAsignadas++;
            }
            else{
                System.out.println("El cliente "+cliente+" No se pudo asignar");
                i++;
            }
            cliente++;
        }
        if(mesasAsignadas==MAXM){
            System.out.println("No hay mas mesas por asignar");
        }
    }

    public static int buscarMesa(int cliente,int[]M){
        int mesa=0;
        while (mesa < MAXM && M[mesa]<cliente ) {
            mesa++;
        }
        return mesa;
    }

    public static void SuprimirCliente(int[]arr,int i){
       for(int pos=i;pos<MAXC-1;pos++){
            arr[pos]=arr[pos+1];
       }

    }

    public static void AsignarMesa(int[]M,int posMesa){
        M[posMesa]=-M[posMesa];

    }

    public static void mostrarArreglo(int[]arr,int MAX){
        for(int i=0; i<MAX;i++){
            System.out.print(" |"+arr[i]);
        }
        System.out.println();
    }
    
}
