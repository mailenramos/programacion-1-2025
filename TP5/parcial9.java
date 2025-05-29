public class parcial9 {
    static final int MAX = 17;
    static final int MAXC = 3;
    static final char SEPARADOR = ' ';
    public static void main(String[] args) {
        char[]mensaje={' ','h','o','l','a',' ','c','o','o','o',' ','e','s','s','s','s',' '};
        int[]clave={1,2,3};

        encriptar(mensaje,clave);
        mostrarArreglo(mensaje);
    }

    public static void encriptar(char[]mensaje,int[]clave){
        int ini=0, fin=-1;
        int j=0;
        while(ini<MAX){
            ini=buscarInicio(mensaje,fin+1);
            if(ini<MAX){
                fin=buscarFin(mensaje,ini);
                if(patronAlDescubierto(mensaje,ini,fin))
                    System.out.println("Por seguridad NO se pudo encriptar la secuencia.");
                else
                    j = encriptarSecuencia(mensaje,ini,fin,clave,j);
            }
        }
    }

    public static boolean patronAlDescubierto(char[]mensaje, int ini, int fin){
        boolean patronInseguro=false;
        int repeticiones=1;
        for(int i=ini+1;i<=fin;i++){
            if(mensaje[i]==mensaje[i-1]){
               repeticiones++;
               if(repeticiones>=MAXC){
                    patronInseguro=true;    
               }
            }else{
                repeticiones=1;
            }
        }

        return patronInseguro;
    }

    public static int encriptarSecuencia(char[]mensaje,int ini,int fin,int[]clave,int j){
        int i=ini;
        while(i<=fin && j<MAXC){
            mensaje[i]+=clave[j];
            i++;
            j++;
            if(j==MAXC){
                j=0;
            }
        }
        return j;
    }

    public static int buscarInicio(char[]arr,int pos){
        int i=pos;
        while(i<MAX && arr[i]==SEPARADOR){
            i++;
        }
        return i;
    }

    public static int buscarFin(char[]arr,int pos){
        int i=pos;
        while(i<MAX && arr[i]!=SEPARADOR){
            i++;
        }
        return i-1;
    }
    public static void mostrarArreglo(char[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("| "+arr[i]);
        }
        System.err.println();
    }
}
