public class parcial6 {
    static final int MAXP = 28;
    static final int MAXR = 2;
    static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] P = {0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] R = {44, 6};

        incorporarPromocion(P, R);

        System.out.println("Después de asignar:");
        mostrarArreglo(P);
    }

    public static void incorporarPromocion(int[] P, int[] R) {
        int CantProductosRegalados = 0;
        int ini = 0, fin = -1;

        while (ini < MAXP) {
            ini = buscarInicio(P, fin + 1);
            if (ini < MAXP) {
                fin = buscarFin(P, ini);
                CantProductosRegalados += AsignarProductosPromocionados(P, ini, fin, R);
            }
        }

        System.out.println("Cantidad total de productos regalados: " + CantProductosRegalados);
    }

    public static int AsignarProductosPromocionados(int[] P, int ini, int fin, int[] R) {
        int productosR = 0;
        int i = ini;

        while (i <= fin && productosR < MAXR) {
            if (P[i] > R[productosR]) {
                insertarProducto(i, P, R[productosR]);
                productosR++;
                fin++; // el pedido crece
            } else {
                i++;
            }
        }

        // Si aún quedan productos por insertar, van al final del pedido
        while (productosR < MAXR && fin + 1 < MAXP && P[fin + 1] == SEPARADOR) {
            insertarProducto(fin + 1, P, R[productosR]);
            productosR++;
            fin++;
        }

        return productosR;
    }

    public static void insertarProducto(int pos, int[] P, int producto) {
        if (P[MAXP - 1] != SEPARADOR) {
            System.out.println("No hay espacio para insertar más productos.");
            return;
        }
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
