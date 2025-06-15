public class ej3 {
    static final int MAXM = 20;
    static final int MAXA = 3;
public static void main(String[] args) {
    int[]M={0,0, 34,2,12,25 ,0, 32,55,12,3,88,14 ,0,0, 17,36,19 ,0,0};
    int[]A={2,3,6};

    asignarAulas(M,A);
    mostrarArreglo(M,MAXM);
    mostrarArreglo(A,MAXA);
}

public static void asignarAulas(int[]M,int[]A){
    int ini=0, fin=-1;
    int cantAulasAsignadas=0;
    int materia = 0;

    while(ini<MAXM && cantAulasAsignadas<MAXA){
        ini=buscarInicio(M,fin+1);
        if(ini<MAXM){
            fin=buscarFin(M,ini);
            materia++;
            int cantAlumnos=fin-ini+1;
            int pos=buscarAula(A,cantAlumnos);
            if (pos<MAXA) {
                asignarAula(pos,A);
                suprimirMateria(M, ini,cantAlumnos);
                fin=ini-1;
                cantAulasAsignadas++;
                System.out.println("La materia "+materia+" se le asignó el aula "+pos);
            }else{
                System.out.println("La materia "+materia+" no se pudo asignar");
            }
        }
    }
    if(cantAulasAsignadas==MAXA)
        System.out.println("No hay mas aulas disponibles");
}

public static void suprimirMateria(int[]M, int ini, int cantAlumnos){
    int i=0;
    while(i<cantAlumnos){
        correrIzquierda(M, ini);
        i++;
    }
}
public static void correrIzquierda(int[]arr, int pos){
    while(pos<MAXM-1){
        arr[pos]=arr[pos+1];
        pos++;
    }
}

public static void asignarAula(int aula, int[]A){
    A[aula]= -A[aula];
}

public static int buscarAula(int[]A, int cantAlumnos){
    int aula=0;
    while(aula<MAXA && A[aula]<cantAlumnos){
        aula++;
    }
    return aula;
}
    public static int buscarInicio(int[]arr,int pos){
        int i=pos;
        while(i<MAXM && arr[i]==0){
            i++;
        }
        return i;
    }
    public static int buscarFin(int[]arr,int pos){
        int i=pos;
        while(i<MAXM && arr[i]!=0){
            i++;
        }
        return i-1;
    }

    public static void mostrarArreglo(int[]arr, int MAX){
        for(int i=0; i<MAX; i++){
            System.out.print(" |"+arr[i]);
        }
        System.out.println();
    }
}
