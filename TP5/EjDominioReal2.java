public class EjDominioReal2 {
    /*
double[] importes = {203.56, 87.5, 1233.4}; // el total de cada ticket
int[] cantidades = {25, 2, 13}; // la cantidad de artículos en cada ticket

double[]tickets={0, 203.56, 87.5, 1233.4, 0,  }

Hacer un programa completo con un menú de opciones (con la
opción ‘0’ sale) para que informe los diferentes valores al
departamento de ventas. Considerar constantes y variables
acordes al problema. Establezca cómo será la estructura que
usará y definala en el programa teniendo en cuenta los conceptos
de secuencias vistos en la teoría.

a. cuántos tickets se emitieron ese fin de semana
b. cuánto fue el importe total de ventas
c. cuál fue el ticket de mayor importe, cuánto fue su valor
d. cuál fue la mayor cantidad de artículos vendidos en un ticket
e. del ticket con mayor cantidad de artículos vendidos, cuál fue el de mayor importe, el de menor y el promedio
f. del ticket de mayor importe, cuántos artículos hay
involucrados y cuál es el promedio de valores
g. cuanto es el valor promedio de venta por ticket en todo el fin
de semana
h. cuál fue el ticket con el menor importe, cuánto fue su valor
i. cuál fue el ticket con la menor cantidad de artículos vendidos


     */
    public static void main(String[] args) {
        double[] importes = {203.56, 87.5, 1233.4}; // el total de cada ticket
        int[] cantidades = {25, 2, 13}; // la cantidad de artículos en cada ticket
        
        System.out.println("ingrese una opcion de 'a' hasta 'i' y '0' para salir");
        char opcion=Utils.leerChar();
        while (opcion!='0') {
            
            switch (opcion) {
                case 'a':cantidadTickets(importes);                    
                break;
                case 'b':importeTotal(importes);    
                break;
                case 'c':ticketMayorImporte(importes);       
                break;
                case 'd':MayorCantidadArticulosVendidos(cantidades);
                    
                break;
                 case 'e':
                    
                break;
                 case 'f':
                    
                break;
                 case 'g':
                    
                break;
                 case 'h':
                    
                break;
                 case 'i':
                    
                break;
                case '0':
                    
                break;

                default:break;
            
            }
            System.out.println("ingrese una opcion de 'a' hasta 'i' y '0' para salir");
            opcion=Utils.leerChar();
        }
    }
    public static void MayorCantidadArticulosVendidos(int[] cantidades) {
        int mayor=-9999;
       for(int i=0;i<cantidades.length;i++){
           if (cantidades[i]>mayor) {
                mayor=cantidades[i];
            }
        }
        System.out.println("La mayor cantidad de articulos vendidos es: "+mayor);
    }
    public static void cantidadTickets(double[] importes) {
        System.out.println("La cantidad de tickets es: "+importes.length);
    }
    public static void importeTotal(double[] importes) {
        double sumatoria=0;
        for(int i=0;i<importes.length;i++){
            sumatoria+=importes[i];
        }
        System.out.println("El importe Total de Ventas es: "+sumatoria);
    }
    public static void ticketMayorImporte(double[] importes) {
       double mayor=-9999;
       int ticketMayor=0;
        for(int i=0;i<importes.length;i++){
            if (importes[i]>mayor) {
                mayor=importes[i];
                ticketMayor=i;
            }
        }
        System.out.println("El ticket con Mayor Importe es el "+ticketMayor+" importe: "+mayor);
    }
}
