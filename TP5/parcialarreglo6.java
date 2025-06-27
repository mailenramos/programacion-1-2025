public class parcialarreglo6 {
    static final int MAXP = 28;
    static final int MAXR = 2;
    static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] P = {0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] R = {44, 6};

        int productosRegalados=incorporarPromocion(P, R);
        mostrarArreglo(P);
        System.out.println("La cantidad de productos regalados es: "+productosRegalados);
    }

    public static int incorporarPromocion(int[] P, int[] R) {
        int ini = 0, fin = -1;
        int productosRegalados=0;
        while (ini < MAXP) {
            ini = buscarInicio(P, fin + 1);
            if (ini<MAXP) {
                fin=buscarFin(P, ini);
                int productos=asignarPromociones(P, ini, fin,R);
                productosRegalados+=productos;
                fin=fin+productos;
            }
            
        }
        return productosRegalados;
    }
    public static int asignarPromociones(int[] arr,int ini,int fin ,int[] R) {
     int i=0;
     int productosRegalados=0;

        while(i<MAXR & productosRegalados<=MAXR){
                asignarPromo(arr,ini,fin,R[i]);
                i++;
                fin++;
                productosRegalados++;
        }
        return productosRegalados; 
    }

    public static void asignarPromo(int[]P,int ini,int fin,int producto){
            int pos=buscarPosicion(P, ini, fin,producto);
            insertarProducto(P, pos, producto);
    }    

    public static int buscarPosicion(int[] P, int ini, int fin, int producto) {
        while (ini <= fin && P[ini]<producto) {
            ini++;
        }
        return ini;
    }

    public static void insertarProducto(int[] P, int pos, int producto) {
        correrDerecha(P, pos);
        P[pos] = producto;
    }

    public static void correrDerecha(int[] arr, int pos) {
        for (int i = MAXP - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static int buscarInicio(int[] arr, int pos) {
        int i = pos;
        while (i < MAXP && arr[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int buscarFin(int[] arr, int pos) {
        int i = pos;
        while (i < MAXP && arr[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("| " + arr[i]);
        }
        System.out.println();
    }
}
