public class parcial2 {
    public static void main(String[] args) {
        int[] C = {4, 3, 8, 6, 2, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] M = {2, 3, 5, 6, 12};

        System.out.println("Antes de asignar:");
        mostrarArreglo("Clientes", C);
        mostrarArreglo("Mesas", M);

        asignarMesas(C, M);

        System.out.println("\nDespués de asignar:");
        mostrarArreglo("Clientes", C);
        mostrarArreglo("Mesas", M);
    }

    public static void asignarMesas(int[] C, int[] M) {
        int i = 0;

        while (i < C.length && C[i] != 0) {
            boolean asignado = false;

            for (int j = 0; j < M.length; j++) {
                if (M[j] > 0 && C[i] <= M[j]) {
                    System.out.println("Cliente de " + C[i] + " asignado a mesa de " + M[j]);
                    asignarMesa(M, j);
                    borrarOrden(C, i);
                    asignado = true;
                    break; // Asignamos solo una mesa
                }
            }

            if (!asignado) {
                System.out.println("No se pudo asignar cliente de " + C[i]);
                i++; // Solo avanzamos si no se asignó, ya que se mantiene en el arreglo
            }
        }
    }

    public static void borrarOrden(int[] C, int pos) {
        while (pos < C.length - 1 && C[pos] != 0) {
            C[pos] = C[pos + 1];
            pos++;
        }
        C[pos] = 0;
    }

    public static void asignarMesa(int[] M, int j) {
        M[j] = -M[j]; // Marcamos la mesa como usada
    }

    public static void mostrarArreglo(String nombre, int[] A) {
        System.out.print(nombre + ": ");
        for (int i = 0; i < A.length && A[i] != 0; i++) {
            System.out.print("| " + A[i] + " ");
        }
        System.out.println("|");
    }
}
