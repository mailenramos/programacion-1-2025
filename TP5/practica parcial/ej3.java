public class ej3 {
    static final int MAXM = 20;
    static final int MAXA = 3;
public static void main(String[] args) {
    int[]M={0,0, 32,2,12,25 ,0, 32,55,12,3,88,13 ,0,0, 17,36,19 ,0,0};
    int[]A={2,3,6};

    asignarAulas(M,A);
}

public static void asignarAulas(int[]M,int[]A){
    int ini=0, fin=-1;
    int cantAulasAsignadas=0;
    int materia = 1;

    while(ini<MAXM && cantAulasAsignadas<MAXA){
        ini=buscarInicio(M,fin+1);
        if(ini<MAXM){
            fin=buscarFin(M,ini);
            int cantAlumnos=fin-ini+1;
            int pos=buscarAula(A,cantAlumnos);
            if (pos<MAXA) {
                Asignar(pos,A);
                cantAulasAsignadas++;
            }
        }
    }

}

public static int buscarAula(int[]A, int cantAlumnos){
    int i=0;
    while(i<MAXA && A[i]<cantAlumnos && A[i]>0){
        i++;
    }

    return i;
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
}
