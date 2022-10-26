package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Floyd_Warshall {

    private int tam;
    private final int  inf = 99999;
    private int[][] m;
    private int[][] camino;
    private String respuesta;

    public Floyd_Warshall(int tam, int[][] m){
        this.tam = tam;
        this.m = m;
        this.camino = new int[tam][tam];
        this.respuesta="";
    }

    public String resolver() {
        int[][] aux = new int[tam][tam];
        for(int i =0; i<tam; i++) {
            aux = operar(m,i);
            verificar(aux, m, (i+1));
            m = operar(m,i);
            this.respuesta+="A"+(i+1)+"\n";
            this.respuesta+="\n--------------\n";
            imprimir(m);
            this.respuesta+="\n--------------\n";
            this.respuesta+="CAMINO "+(i+1)+"\n";
            imprimir(camino);
            this.respuesta+="\n--------------\n";
        }
        return this.respuesta;
    }
    public int[][] operar(int[][]m, int k){
        int[][] res = new int [tam][tam];

        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam; j++) {
                res[i][j] = calcularMenor(m[i][j], (m[i][k]+m[k][j]));
            }
        }


        return res;
    }

    private int calcularMenor(int a, int b) {
        int n = (a<=b) ?  a :  b;
        return n;
    }


    private void imprimir(int[][] m) {
        for(int i = 0; i<tam; i++) {
            for(int j =0; j<tam; j++) {
                if(m[i][j]==inf) {
                    this.respuesta+="x"+"  ";
                }else {
                    this.respuesta+=m[i][j]+"  ";
                }


            }
            this.respuesta+="\n";
        }
    }
    private void verificar(int[][] m1, int[][] m2, int k) {
        for(int i = 0; i<tam; i++) {
            for(int j =0; j<tam; j++) {

                if(m1[i][j]!=m2[i][j]) {
                    camino[i][j] = k;
                }
            }

        }
    }

}
