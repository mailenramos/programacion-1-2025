class parcial1{
    static final int MAXM=19;
    static final int MAXA=3;
    static final int SEPARADOR=0;
     public static void main (String[] args){
        int[] M= {0,0,34,2,12,25,0,32,12,3,88,14,0,0,17,36,19,0,0};
        int[] A= {2,3,6};

        mostrarArreglo(A, MAXA);
        mostrarArreglo(M, MAXM);
        Procesar(M,A);
        System.out.println("-----------------");
        mostrarArreglo(A, MAXA);
        mostrarArreglo(M, MAXM);
    }

    public static void Procesar ( int[] M , int[] A){
          int ini=0;
          int fin=-1;

          while (ini<MAXM){
                     ini=BuscarInicio(M,ini);
                    if (ini<MAXM){
                          fin=BuscarFin(M,ini);
                                              
                          if (EncuentraAulas(M,A,ini,fin)){
                            mostrarArreglo(M,MAXM);
                            BorrarMateria(M,ini,fin+1); 
                            mostrarArreglo(M,MAXM);
                          }
                          else {
                                ini = fin + 1; // solo si no se asignó, avanzar normalmente
                          }  
                                            
                    }       
          }
    }

    public static boolean EncuentraAulas( int[] M,  int[] A, int ini,  int fin){
      int CantAlumnos=fin-ini+1;
      boolean encontro=false;
      int i=0;

          while( i<MAXA  &&  !encontro){
            System.out.println("inicio sec "+ini+" fin sec "+fin+" largo "+CantAlumnos);
                  if(A[i]>=CantAlumnos){
                       BorrarAula(A,i);
                       encontro=true;
                  }
                   i++;
                } 
    return encontro;
    }
    public static void BorrarAula(int[]A,int pos){
        A[pos] = -A[pos];
    }
    
    public static void BorrarMateria(int[]M,int ini,int fin){
        for(int i=ini;i<=fin;i++){
            CorrerIzquierda(M,ini);
            }
         }
    public static void CorrerIzquierda(int[]M,int pos){
        int i=pos;
        while(i<MAXM-1){
            M[i]=M[i+1];
            i++;
        }
        M[MAXM-1]=SEPARADOR;                     
    }      
           
    public static int BuscarInicio(int[]arr,int pos){
        int i=pos;
          while(i<MAXM && arr[i]==SEPARADOR){
                 i++;
          }
    return i;
    }
    
    public static int BuscarFin(int[]arr,int pos){
        int i = pos;
     while(i<MAXM && arr[i]!=SEPARADOR){
     i++;
     }
    return i-1;
}

    public static void mostrarArreglo(int[]arr,int MAX){
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
