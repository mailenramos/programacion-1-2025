/*La cadena de supermercados Carrefive ha pedido la
refactorización del componente de software que usa para el
control de stock. El código original no estaba modularizado por lo
tanto no era legible y no se aprovechaba la reutilización. Dado un
artículo (id y nombre), fecha y hora y una cantidad, el componente
que maneja el stock genera los siguientes reportes:

    a. Cuando la cantidad de unidades del artículo llega a un límite
de seguridad (valor constante) se debe reportar (por
consola) los siguientes datos que deben ser enviados al
proveedor de dicho artículo: ID_Producto, Nombre, Fecha y
Hora (ingresada por el usuario), Cantidad, Prioridad baja.
    b. Cuando la cantidad de unidades está por debajo del límite
de seguridad en más de un 30% se debe aumentar la
prioridad de baja a media y actualizar la cantidad, la fecha y
la hora en el reporte.
    c. Cuando la cantidad de unidades está por debajo del límite
de seguridad en más de un 70% la prioridad cambia a alta y se debe actualizar la cantidad, la fecha y la hora en el
reporte.
    d. Cuando la cantidad es cero se debe imprimir por consola un
mensaje “No hay más unidades del producto” + ID_Producto
+ Nombre. También se debe actualizar la cantidad (0), la
fecha y la hora en el reporte.
    e. Si la cantidad vendida excede lo que hay en stock (definir un
método getStock(id) que le consulte al usuario y retorne la
cantidad de stock del producto) se debe informar y no
descontar del stock. Informar cuánto stock queda para
vender de ese producto.

Escribir un programa con declaración de constantes y variables
que haga uso de los métodos definidos y que mientras el usuario
no ingrese 0 (en un sistema real lo genera otro componente por
ejemplo el que se ejecuta en la caja registradora) pida el ingreso
de los datos necesarios (la prioridad se debe obtener
automáticamente dependiendo de los valores) para generar el
reporte correctamente. Modularizar la solución.
*/
public class EjDomRealTP3 {
    static final int limite = 50;
    public static void main(String[] args) {
        int id=2;
        String nombre="Papel Higienico";
        String fecha="24/04/2025";
        String hora = "13:30";
        String prioridad = "Desconocida";

        System.out.println("Ingrese cant_unidad:");
        int cant_unidad = Utils.leerInt();
        int stockActual = getStock(id);

        if (cant_unidad > stockActual) {
            System.out.println("La cantidad ingresada excede el stock actual.");
            System.out.println("Stock disponible: " + stockActual);
        } else {
            ComprobarCantidad(id, nombre, fecha, hora, cant_unidad, prioridad);
        }
    }

    public static int getStock(int id){
        System.out.println("Ingrese el stock actual del producto con ID: " + id);
        return Utils.leerInt();
    }
    public static void ComprobarCantidad(int id,String nombre,String fecha,String hora,int cant_unidad,String prioridad) {
        if(cant_unidad==limite){
            prioridad="Baja";
            mostrarReporte(id, nombre, fecha, hora, cant_unidad, prioridad);
        }
        else if(cant_unidad<limite* 0.3){
            prioridad="alta";
            cant_unidad=actualizarCantidad(cant_unidad);
            fecha=actualizarFecha(fecha);
            hora=actualizarHora(hora);
            mostrarReporte(id, nombre, fecha, hora, cant_unidad, prioridad);
        }else if(cant_unidad<(limite*0.7)){
            prioridad="media";
            cant_unidad=actualizarCantidad(cant_unidad);
            fecha=actualizarFecha(fecha);
            hora=actualizarHora(hora);
            mostrarReporte(id, nombre, fecha, hora, cant_unidad,prioridad);
        }else if(cant_unidad==0){
            System.out.println("No hay más unidades.");
            cant_unidad=0;
            fecha=actualizarFecha(fecha);
            hora=actualizarHora(hora);
            mostrarReporte(id, nombre, fecha, hora, cant_unidad, prioridad);
        }
    }
    public static String actualizarHora(String hora){
        System.out.println("Ingrese la hora actual");
        hora=Utils.leerString();
        return hora;
       
    }
    public static int actualizarCantidad(int cant_unidad) {
        if(cant_unidad!=0){
            System.out.println("Ingrese la cantidad Actual");
            cant_unidad=Utils.leerInt();
        }
        return cant_unidad;
        
    }
    public static String actualizarFecha(String fecha) {
        System.out.println("Ingrese la fecha actual");
        fecha=Utils.leerString();
        return fecha;
    }
  
    public static void mostrarReporte(int id,String nombre,String fecha,String hora,int cant_unidad,String prioridad){
            System.out.println("Reporte--------------------------");
            System.out.println("ID: "+id);
            System.out.println("Producto: "+nombre);
            System.out.println("Fecha y Hora: "+fecha+" "+hora);
            System.out.println("Cantidad: "+cant_unidad);
            System.out.println("Prioridad: "+prioridad);
    }
    
}
