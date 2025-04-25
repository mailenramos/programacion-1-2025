public class ejercicio13 {
    public static void main(String[] args) {
        System.out.println("Ingrese 3 números reales:");
        double r1 = Utils.leerDouble();
        double r2 = Utils.leerDouble();
        double r3 = Utils.leerDouble();

        System.out.println("Ingrese una opción (1 a 4):");
        int opcion = Utils.leerInt();
        while (opcion>=1 && opcion<=4) {
            
        
            if (opcion == 1) {
                calcularRaizDeR1MenosR3(r1, r3);
            } else if (opcion == 2) {
                double promedio = calcularPromedio(r1, r2, r3);
                System.out.println("El promedio de " + r1 + ", " + r2 + " y " + r3 + " es: " + promedio);
            } else if (opcion == 3) {
                calcularRaizDeR3MenosR2SobreR1(r1, r2, r3);
            } else if (opcion == 4) {
                calcularPromedioSobreRaizDeR2(r1, r2, r3);
            } else {
                System.out.println("Opción no válida.");
            }

            System.out.println("Ingrese una opción (1 a 4):");
            opcion = Utils.leerInt();
        }
        System.out.println("OPCION NO VALIDA");
    }

    public static void calcularRaizDeR1MenosR3(double r1, double r3) {
        double resta = r1 - r3;
        if (resta < 0) {
            System.out.println("Error: no se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            System.out.println("La raíz cuadrada de (" + r1 + " - " + r3 + ") = " + resta + " es: " + Math.sqrt(resta));
        }
    }

    public static double calcularPromedio(double r1, double r2, double r3) {
        return (r1 + r2 + r3) / 3;
    }

    public static void calcularRaizDeR3MenosR2SobreR1(double r1, double r2, double r3) {
        double resta = r3 - r2;
        if (resta < 0) {
            System.out.println("Error: no se puede calcular la raíz cuadrada de un número negativo.");
        } else if (r1 == 0) {
            System.out.println("Error: no se puede dividir por cero.");
        } else {
            double raiz = Math.sqrt(resta);
            System.out.println("El cociente de √(" + r3 + " - " + r2 + ") dividido por " + r1 + " es: " + raiz / r1);
        }
    }

    public static void calcularPromedioSobreRaizDeR2(double r1, double r2, double r3) {
        if (r2 < 0) {
            System.out.println("Error: no se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            double promedio = calcularPromedio(r1, r2, r3);
            double raiz = Math.sqrt(r2);
            if (raiz == 0) {
                System.out.println("Error: no se puede dividir por cero.");
            } else {
                System.out.println("El cociente del promedio dividido por √" + r2 + " es: " + promedio / raiz);
            }
        }
    }
}
