/*Escribir un programa que pida se ingresen datos necesarios para
emitir una factura por la compra de dos artículos de librería (tipo
factura, número, nombre cliente, producto 1, importe 1, producto 2,
importe 2, importe total). Como salida debe imprimir por pantalla la
factura en un formato similar al del siguiente ejemplo:
Factura C N 249
Nombre: Juan Perez
Producto Importe
Lápiz 15.5
Papel 20.6
Importe total 36.1 */
public class ejercicio6 {
    public static void main(String[] args) {
        char tipoFactura=' ';
        int numeroFactura= 0 ;
        String nombreCliente="";
        String producto1="";
        String producto2= "";
        double importe1=0;
        double importe2=0;

        System.out.println("Ingrese el tipo de factura(A , B, C");
        tipoFactura = Utils.leerChar();

        System.out.println("Ingrese el numero de factura");
        numeroFactura = Utils.leerInt();

        System.out.println("Ingrese el nombre de cliente");
        nombreCliente = Utils.leerString();

        System.out.println("Ingrese el producto1");
        producto1 = Utils.leerString();

        System.out.println("ingrese el importe1");
        importe1 = Utils.leerDouble();

        System.out.println("Ingrese el producto2");
        producto2 = Utils.leerString();

        System.out.println("Ingrese el importe2");
        importe2 = Utils.leerDouble();

        System.out.println("Factura "+tipoFactura+" N "+numeroFactura);
        System.out.println("Nombre: "+nombreCliente);
        System.out.println("Producto  Importe");
        System.out.println(producto1+"    "+importe1);
        System.out.println(producto2+"    "+importe2);
        System.out.print("Importe Total ="+(importe1+importe2));
    }
}
/*Factura C N 249
Nombre: Juan Perez
Producto Importe
Lápiz 15.5
Papel 20.6
Importe total 36.1 */