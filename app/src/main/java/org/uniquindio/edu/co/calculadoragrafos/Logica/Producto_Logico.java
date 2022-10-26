package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Producto_Logico {
    private int nodos;
    private int[][] matriz1;
    private int[][] matriz2;
    private String respuesta;

    public Producto_Logico(int nodos, int[][] matriz){
        this.nodos=nodos;
        this.matriz1=matriz;
        this.matriz2=matriz;
        this.respuesta="";
    }

    public String resolver(){
        for(int i=0; i<nodos-1; i++) {

            matriz2 = multiplicarLogico(matriz1,matriz2);
            this.respuesta+="M"+(i+2);
            imprimir(matriz2);
        }
        return this.respuesta;
    }

    public int[][] multiplicarLogico(int[][] m, int[][] m2){
        int mo = 0;
        int[][] aux = new int[nodos][nodos];
        int[] hist = new int[nodos];
        for(int i = 0; i < nodos; i++){
            for(int j = 0; j < nodos; j++){
                for(int k = 0; k<nodos; k++) {
                    mo = and(m[i][k],m2[k][j]);
                    hist[k] = mo;
                }
                mo = mirarHistorial(hist);
                aux[i][j] = mo;
            }
        }
        return aux;
    }
    public int mirarHistorial(int[] h) {
        int n1;
        int res = h[0];
        for(int i = 1; i<=(nodos-1); i++) {
            n1 = h[i];
            res = or(res, n1);
        }
        return res;
    }

    public int and(int a, int b) {
        return (a==1 && b==1) ? 1 : 0;
    }

    public int or(int a, int b) {
        return (a==1 || b==1) ? 1 : 0;
    }

    public void imprimir(int[][] m) {
        this.respuesta+="\n------------------------\n";
        for(int i=0; i<nodos; i++) {
            for(int j=0; j<nodos; j++) {
                this.respuesta+=m[i][j]+" ";
            }
            this.respuesta+="\n";
        }
        this.respuesta+="\n------------------------\n";
    }
}
