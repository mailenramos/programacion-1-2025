class parcial1{
    static final int MAXM=20;
    static final int MAXA=3;
    static final int SEPARADOR=0;
     public static void main (String[] args){
        int[] M= {0,0,33,2,12, 25, 0, 32, 55, 12 ,3, 88 ,14 ,0 ,0, 17, 36 ,19, 0, 0};
        int[] A= {2,3,6};

        mostrarArreglo(M,MAXM);
        mostrarArreglo(A,MAXA);
        Procesar(M,A);
        mostrarArreglo(M,MAXM);
        mostrarArreglo(A,MAXA);
    }

    public static void Procesar ( int[] M , int[] A){
          int ini=0, fin=-1;
    
          while (ini<MAXM){
                     ini=BuscarInicio(M,fin+1);
                     if (ini<MAXM){
                          fin=BuscarFin(M,ini);                    
                          AsignarAula(M,A,ini,fin);                     
                     } 
          }
    }
    public static void AsignarAula( int[] M,  int[] A, int ini,  int fin){
      int CantAlumnos=SacarCantAlumnos(ini,fin);
      int i=0;
          while( i<MAXA  &&  A[i]<  CantAlumnos && A[i]>0){
                  if(A[i]>=CantAlumnos){
                       A[i]*= -1;
                       EliminarMateria(M,ini);
                        fin=ini-1;
                  }else{
                        System.out.println("No se pudo asignar la materia, la conservaremos");
                   } 
                  i++;
           }
    }
        public static void EliminarMateria(int[]M,int ini){
             while(ini<=MAXM){
                    CorrerIzquierda(M,ini);
                     ini++;
              }
         }
          public static void CorrerIzquierda(int[]M,int pos){
                 while(pos<MAXM){
                            M[pos]=M[pos+1];
                             pos++;
                    }                     
    }      
           
    public static int BuscarInicio(int[]arr,int pos){
          while(pos<MAXM && arr[pos]==SEPARADOR){
                 pos++;
          }
    return pos;
    }
    
    public static int BuscarFin(int[]arr,int pos){
     while(pos<MAXM && arr[pos]!=SEPARADOR){
     pos++;
     }
    return pos-1;}

    public static int SacarCantAlumnos(int ini , int fin){
         return fin-ini+1;
    }
    public static void mostrarArreglo(int[]arr,int MAX){
        for(int i=0;i<MAX;i++){
            System.out.print(arr[i]+" |");
        }
        System.out.println();
    }
}
