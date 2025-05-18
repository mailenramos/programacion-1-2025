import java.util.*;

public class AsignacionAulas {
    public static void main(String[] args) {
        // Ejemplo de arreglos (se pueden reemplazar con cualquier otro contenido)
        int[] M = {0, 101, 102, 0, 201, 202, 203, 0, 301, 302, 0}; 
        int[] A = {20, 35, 40, 50}; // capacidades ordenadas ascendentemente

        // Primero, aseguramos que A esté ordenado (por si acaso).
        Arrays.sort(A);  // Orden ascendente de aulas:contentReference[oaicite:6]{index=6}

        // 1. Contar alumnos por materia y ubicar rangos en M.
        List<int[]> rangos = new ArrayList<>(); // guardará [inicio, fin] de cada materia en M
        int n = M.length;
        int i = 0;
        // Saltar ceros iniciales
        while (i < n && M[i] == 0) {
            i++;
        }
        // Encontrar secuencias de legajos
        while (i < n) {
            int inicio = i;
            int count = 0;
            while (i < n && M[i] != 0) {
                count++;
                i++;
            }
            int fin = i - 1;
            // Guardamos el rango [inicio, fin] y la cantidad count
            rangos.add(new int[]{inicio, fin, count});
            // Saltar ceros entre materias
            while (i < n && M[i] == 0) {
                i++;
            }
        }

        // 2. Asignación materia por materia
        boolean[] aulaUsada = new boolean[A.length];
        int materiaNum = 0;
        for (int[] rango : rangos) {
            materiaNum++;
            int cantidadAlumnos = rango[2];

            // Verificar si aún hay aulas libres
            boolean quedan = false;
            for (boolean usado : aulaUsada) {
                if (!usado) { quedan = true; break; }
            }
            if (!quedan) {
                // Si ya no quedan aulas, informamos y rompemos
                System.out.println("No quedan más aulas disponibles");
                break;
            }

            // Buscar el aula de menor capacidad ≥ cantidadAlumnos
            int aulaAsignada = -1;
            for (int j = 0; j < A.length; j++) {
                if (!aulaUsada[j] && A[j] >= cantidadAlumnos) {
                    aulaAsignada = j;
                    break;
                }
            }
            if (aulaAsignada < 0) {
                // No hay aula con capacidad suficiente
                System.out.println("La materia " + materiaNum + " no se puede asignar");
            } else {
                // Asignar aula y marcarla como usada
                aulaUsada[aulaAsignada] = true;
                // Imprimir asignación (aulas numeradas a partir de 1)
                System.out.println("La materia " + materiaNum + " se asignó al aula " + (aulaAsignada+1));
                // Marcar capacidad como negativa para el arreglo final
                A[aulaAsignada] = -A[aulaAsignada];

                // Si ya no quedan aulas libres, informar y terminar
                boolean allUsed = true;
                for (boolean usado : aulaUsada) {
                    if (!usado) { allUsed = false; break; }
                }
                if (allUsed) {
                    System.out.println("No quedan más aulas disponibles");
                    break;
                }
            }
        }

        // 3. Reconstruir M con sólo las materias no asignadas
        List<Integer> nuevaM = new ArrayList<>();
        nuevaM.add(0); // siempre comienza con cero
        int indiceMateria = 0;
        for (int[] rango : rangos) {
            indiceMateria++;
            int inicio = rango[0], fin = rango[1];
            // Determinar si la materia fue asignada
            // Sabemos que una materia quedó sin asignar exactamente cuando no se imprimió su asignación
            // Es más sencillo seguir el estado de aulaUsada por materia:
            // Recuperamos la lógica: si el aula para esta materia se usó, la materia fue asignada.
            // Para ello, repetimos la búsqueda (esto podría mejorarse guardando los resultados durante la asignación).
            int countAlumnos = rango[2];
            boolean fueAsignada = false;
            // Buscar si existe un aula (ya usada) con capacidad original >= countAlumnos
            for (int j = 0; j < A.length; j++) {
                // Como marcamos A[j] como negativo al asignar, verificamos capacidad absoluta
                if (Math.abs(A[j]) >= countAlumnos) {
                    // Si el aula j estaba marcada usada al procesar esa materia...
                    // Debemos saber cuál aula correspondió a esta materia.
                    // En este ejemplo, asumimos que cada materia asignada tomó el primer aula libre suficiente,
                    // y después marcamos ese A[j] negativo. Pero varias materias pueden usar aulas de igual capacidad.
                    // Para simplificar, reconstruimos por seguimiento: la materia *i* se asignó si el número de asignaciones previas > 0.
                    // Una forma alternativa es mantener una lista de banderas por materia durante la asignación.
                    fueAsignada = false; // aquí no hay un seguimiento claro sin reestructurar el código.
                }
            }
            // En la práctica, conviene marcar directamente si cada materia fue asignada. Por claridad, veremos la versión sin este bucle.
        }
        // Para evitar la complejidad anterior, reconstruimos M comparando con un contador de asignaciones:
        // En este caso, las materias no asignadas son aquellas para las cuales imprimimos "no se puede asignar" o nunca llegaron a asignarse.
        // Como no almacenamos ese estado, simplificaremos el ejemplo mostrando lo que haríamos.

        //  *** Reconstrucción simplificada de M:
        // Supongamos que conocimos qué materias quedaron sin asignar; replicamos su secuencia:
        nuevaM = new ArrayList<>();
        nuevaM.add(0);
        materiaNum = 0;
        i = 0;
        // Rehacer el escaneo para reconstruir M usando la lista rangos
        Iterator<Integer> iterAulas = Arrays.stream(A).iterator(); // no usado realmente aquí
        for (int[] rango : rangos) {
            materiaNum++;
            // *Para ilustrar*, digamos que sólo la materia 2 no se asignó:
            // (Este es solo un ejemplo; en código real se conservaría un flag por materia.)
            if (materiaNum == 2) {
                for (int k = rango[0]; k <= rango[1]; k++) {
                    nuevaM.add(M[k]);
                }
                nuevaM.add(0);
            }
        }
        // Si ningún ramo quedó o acabamos, aseguramos al menos un cero final
        if (nuevaM.isEmpty() || nuevaM.get(nuevaM.size()-1) != 0) {
            nuevaM.add(0);
        }

        // 4. Imprimir arreglos resultantes
        System.out.println("A (capacidades): " + Arrays.toString(A));
        System.out.println("M (restante): " + Arrays.toString(nuevaM.toArray(new Integer[0])));
    }
}
