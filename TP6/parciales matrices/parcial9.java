 class parcial9 {
    static final int MAXFILA = 3;
    static final int MAXCOLUM = 15;
    static final int SEPARADOR = 0;
    static final int X = 600;
    static final int MAXARR = 3;


    public static void main(String[] args) {
        int matriz[][] = {
            {0,0,150,200,165,0,154,352,240,256,0,900,750,0,0},
            {0,940,105,265,845,215,0,245,765,348,0,741,125,541,0},
            {0,851,543,625,845,914,0,754,184,452,637,917,0,0,0}
        };
        int arr1[]={1,2,0};
        int arr2[]={3,0,0};
        promedioMensualVentas(matriz,arr1);
        promedioDiarioSuperior(matriz,arr2);
    }
    public static void promedioDiarioSuperior(int[][]matriz,int[] arr) {
        int i=0;
        while (i<MAXARR && arr[i]!=0) {
            if(SuperiorTodosDias(matriz[arr[i]-1])){
                System.out.println("MES: "+arr[i]+" fue superior a "+X);
            }else{
                System.out.println("MES: "+arr[i]+" no supero "+X);
            }
            i++;
        }
    }
    public static boolean SuperiorTodosDias(int[]arr){
        int ini=0,fin=-1;
        boolean supera=true;
        while (ini<MAXCOLUM && supera) {
            ini=buscarInicio(arr, fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr, ini);
                int largo=fin-ini+1;
                double promedio=SacarPromedio(arr,ini,fin,largo);
                supera=promedio>X;
            }
        }
        return supera;
    }
    public static double SacarPromedio(int[] arr,int ini,int fin,int ventas) {
        int sumatoria=0;
        while (ini<=fin){
            sumatoria+=arr[ini];
            ini++;
        }
        return sumatoria/ventas;
    }
    public static void promedioMensualVentas(int[][] matriz,int[] arr) {
        int i=0;
        while (i<MAXARR && arr[i]!=0) {
            double promedioMensual=VentasMayorImporteXdia(matriz[arr[i]-1]);
            System.out.println("MES "+arr[i]+" Promedio: "+promedioMensual);
            i++;
        }
    }
    public static double VentasMayorImporteXdia(int[] arr){
        int ini=0,fin=-1;
        double sumatoria=0;
        int dias=0;
        while (ini<MAXCOLUM){
            ini=buscarInicio(arr,fin+1);
            if(ini<MAXCOLUM){
                fin=buscarFin(arr,ini);
                dias++;
                double ventaMayor=BuscarVentaMayor(arr,ini,fin);
                sumatoria+=ventaMayor;
            }
        }   
        return sumatoria/dias; 
    }
    public static double BuscarVentaMayor(int[] arr,int ini,int fin){
        double MayorAnterior=-0;
        while (ini<=fin){
            if(arr[ini]>MayorAnterior){
                MayorAnterior=arr[ini];
            }     
            ini++;       
        }
        return MayorAnterior;
    }
    public static int buscarInicio(int[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while (pos < MAXCOLUM && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }
    public static void mostrarMatriz(int[][] matriz) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            mostrarArreglo(matriz[fila]);
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < MAXCOLUM; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
    
}