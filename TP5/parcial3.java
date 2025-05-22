/*
Se pide implementar un programa en Java que asigne a cada materia almacenada en el arreglo M, un aula
del arreglo A. 
La asignación debe realizarse en el orden en que aparecen las materias en el arreglo M y
considerando, una asignación eficiente del espacio, esto es, el aula asignada debe ser aquella que deje
menos cantidad de lugares sin ocupar (y que ya no haya sido asignada). Para indicar que un aula ya ha sido
asignada, la capacidad debe ser cambiada a negativo. 
Una vez realizada la asignación se debe eliminar la secuencia del arreglo M. En caso de no existir un aula disponible con la capacidad
necesaria, se debe informar que no se pudo asignar y se debe conservar la secuencia.
Si la cantidad de materias fuera superior a la cantidad de aulas disponibles, se debe informar que no quedan
más aulas cuando éstas hayan sido todas asignadas. Siguiendo el ejemplo, el arreglo A resultante sería:
*/
public class parcial3 {
    static final int MAXM = 20;
    static final int MAXA = 3;
    static final int SEPARADOR = 0;
    public static void main(String[] args) {
       int[]materias={0,0,34,2,12,25,0,32,55,12,3,88,14,0,0,17,36,19,0,0} ;
       int[]aulas={2,3,6} ;
       
       int aulasAsignadas= asignarAulas(materias,aulas);
        System.out.println("Se asignaron "+aulasAsignadas+ " aulas");
        mostrarArreglo(materias);
        mostrarArreglo(aulas);
    }

    public static int asignarAulas(int[]materias,int[]aulas){
        int aulasAsignadas = 0;
        int aulaDisponible = -1;
        int materia = 0;
        int ini=0, fin=-1;

        while(ini<MAXM){
            ini=buscarInicio(materias,fin+1);
            if(ini<MAXM){
                fin=buscarFin(materias,ini);
                materia++;
                int cantAlumnos = fin-ini+1;

                if(aulasAsignadas<MAXA){
                    aulaDisponible=obtenerAulaDisponible(aulas,cantAlumnos);
                    if(aulaDisponible!=-1){
                        asignarAula(aulas,aulaDisponible);
                        aulasAsignadas++;
                        System.out.println("A la materia: "+materia+" se le asignó el aula: "+aulaDisponible);
                        eliminarMateria(materias,ini,fin);
                        fin = ini-1;
                    }else{
                        System.out.println("La materia "+materia+" no se pudo asignar");
                    }
                }else{
                    System.out.println("Ya no hay aulas disponibles");
                }
                
            }
        }
        return aulasAsignadas;
    }
    public static void eliminarMateria(int[]arr,int ini,int fin) {
        int largo = fin - ini + 1;

        for(int i=0;i<largo;i++){
            CorrerIzquierda(arr,ini);
        }
    }
    public static void CorrerIzquierda(int[] arr,int pos) {
        while (pos<MAXM-1) {
            arr[pos]=arr[pos+1];
            pos++; 
        }
    }
    public static void asignarAula(int[]aulas,int aulaDisponible){
        aulas[aulaDisponible]=-aulas[aulaDisponible];
    }
    public static int obtenerAulaDisponible(int[]aulas,int cantAlumnos){
        boolean encontro = false;
        int aulaDisponible = -1;
        int i=0;

        while(i<MAXA && !encontro){
            if(aulas[i]>0 && aulas[i]>=cantAlumnos){
                aulaDisponible=i;
                encontro=true;
            }else{
                i++;
            }
        }

        return aulaDisponible;
    }

    public static int buscarInicio(int[]arr,int pos){
        int i=pos;
        while(i<MAXM && arr[i]==SEPARADOR){
            i++;
        }
        return i;
    }

    public static int buscarFin(int[]arr,int pos){
        int i=pos;
        while(i<MAXM && arr[i]!=SEPARADOR){
            i++;
        }
        return i-1;
    }

    public static void mostrarArreglo(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("| "+arr[i]);
        }
        System.err.println();
    }
}
