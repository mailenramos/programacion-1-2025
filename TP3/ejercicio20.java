/*Los días lunes se recibe la mercadería que envían los
proveedores y se debe actualizar el stock. 
Suponga que se tiene un método que modifica el stock con la cantidad recibida y que
invoca a otro método que elimina la línea del pedido para el producto recibido (se conoce el ID_Producto). 

Programar un método al cual se le pase el día de la semana y si es lunes pida al
usuario el ID_Producto y la cantidad recibida.
Con estos datos invoque al método que modifica el stock (no implementar) y al que
elimina la línea del pedido (no implementar). 
Hacer un programa que llame a los diferentes métodos, establezca variables y constantes.
Finalmente imprima cuanto stock quedó.
 */
public class ejercicio20 {
   static int stock=100;
    public static void main(String[] args) {
        
        System.out.println("ingrese un dia");
        String dia=Utils.leerString();
        metodo(dia);
        System.out.println("El stock actual es : "+ stock);
    }
    public static void metodo(String dia) {
        System.out.println("inicio el metodo");
        if (dia.equals("Lunes")){
            System.out.println("ingrese el Id Producto");
            int id=Utils.leerInt();
            System.out.println("Cantidad recibida del producto:"+id);
            int CantRecibida=Utils.leerInt();
            modificarStock(id,CantRecibida);
            EliminarLineaPedido(id);
        }
    }
    public static void modificarStock(int id,int CantRecibida) {
        stock+=CantRecibida;
    }
    public static void EliminarLineaPedido(int id){
        System.out.println("Linea Eliminada");
    }
}
