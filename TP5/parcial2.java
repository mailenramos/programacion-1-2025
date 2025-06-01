public class parcial2 {
  
   static final int MAXC = 20;
   static final int MAXM = 5;
   static final int SEPARADOR = 0;
  
  public static void eliminarCliente(int[] arr, int pos){
    
    for(int i = pos; i < MAXC - 1; i++){
      arr[i] = arr[i+1];
    }  
  }
  
  public static int obtenerMesa(int[] arr, int num){
    int pos = 0;
    while(pos < MAXM && arr[pos] < num){
      pos++;
    }
    return pos;
  }
  
  public static void main(String[] args) {
    int [] arrC = {4, 3, 8, 6, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int [] arrM = {2, 3, 5, 6, 12};
    int cantMesasAsignadas = 0;
    int pos = 0;
    int cliente = 1;
    while(pos < MAXC && arrC[pos] != SEPARADOR && cantMesasAsignadas < MAXM ){
      int mesa = obtenerMesa(arrM, arrC[pos]);
      if(mesa < MAXM){
        arrM[mesa] = -arrM[mesa];
        eliminarCliente(arrC,pos);
        System.out.println("El cliente " + cliente + " se asigno a la mesa " + mesa );
        cantMesasAsignadas++;
      }
      else{
        System.out.println("Al cliente " + cliente + " no se le pudo asignar una mesa");
        pos++;
      }
      cliente++;
    }
    
    if(cantMesasAsignadas == MAXM)
        System.out.println("No quedan mas mesas para asignar clientes");}
}