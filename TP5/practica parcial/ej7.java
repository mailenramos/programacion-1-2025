public class ej7 {
    static final int MAX=24;
    static final char SEPARADOR = ' ';
    public static void main(String[] args) {
        char[]I={' ','A','A','3','2','3','Z','Z',' ','P','R','G','0','1','0',' ','A','B','9','8','7','E','X',' ',' '};
        char[]E={' ',' ','A','B','9','8','7','E','X',' ','A','A','1','2','3','Z','Z',' ','F','O','R','0','0','1',' '};
        char[]NoE=new char[MAX];
        char[]NoI=new char[MAX];

        verificarIngresos(I,E,NoE,NoI);
        mostrarArreglo(NoE);
    }

    public static void verificarIngresos(char[]I,char[]E,char[]NoE,char[]NoI){
        int ini=0,fin=-1;
        while(ini<MAX){
            ini=buscarInicio(I,fin+1);
            if(ini<MAX){
                fin=buscarFin(I,ini);

                if(!egreso(I,E,ini,fin)){
                    guardarPatente(I,ini,fin,NoE);
                }
            }
        }
    }

    public static void guardarPatente(char[]I,int ini,int fin,char[]NoE){
        int i=ini;
        int pos=0;
        pos = buscarPosDisponible(NoE,pos);
        if(pos==MAX){
            pos=1;
            insertarSecuencia(i, pos, fin, null, null);
        }else{
            insertarSecuencia(i, pos, fin, null, null);
        }
    }

    public static void insertarSecuencia(int i, int pos, int fin, char[]NoE,char[]I){
        while (i<=fin){
                NoE[pos]=I[i];
                i++;
                pos++;
            }
    }

    public static int buscarPosDisponible(char[]NoE,int pos){
        int i =pos;
        while(i<MAX && NoE[i]==SEPARADOR){

            i++;
        }
        return i;
    }

    public static boolean egreso(char[]I,char[]E,int ini,int fin){
        boolean sonIguales =false;
        int ini2=0,fin2=-1;
        while(ini2<MAX && !sonIguales){
            ini2=buscarInicio(E,fin2+1);
            if(ini2<MAX){
                fin2=buscarFin(E,ini2);
                int largo1=fin-ini+1;
                int largo2=fin2-ini2+1;
                if(largo1==largo2){
                    if(sonIguales(ini,fin,ini2,fin2,I,E)){
                        sonIguales=true;
                    }
                }
            }
        }
        return sonIguales;
    }

    public static boolean sonIguales(int ini,int fin,int ini2,int fin2,char[]I,char[]E){
        int i=ini;
        int i2=ini2;

        while(i<fin && I[i]==E[i2]){
            i++;
            i2++;
        }

        return i==fin;
    }

    public static int buscarInicio(char[]arr, int pos){
        int i=pos;
        while(i<MAX && arr[i]==SEPARADOR){
            i++;
        }
        return i;
    }

    public static int buscarFin(char[]arr, int pos){
        int i=pos;
        while(i<MAX && arr[i]!=SEPARADOR){
            i++;
        }
        return i-1;
    }

    public static void mostrarArreglo(char[]arr){
        for(int i=0;i<MAX;i++){
            System.out.print(" |"+arr[i]);
        }
        System.out.println();
    }
}