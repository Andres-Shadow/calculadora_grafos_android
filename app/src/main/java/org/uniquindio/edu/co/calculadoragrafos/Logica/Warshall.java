package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Warshall {
    private int cantNodos;
    private int[][] matriz;
    private String respuesta;

    public Warshall(int cantNodos, int[][] matriz){
        this.cantNodos = cantNodos;
        this.matriz = matriz;
        this.respuesta = "";
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String resolver(){
        int[][] w = new int[cantNodos][cantNodos];

        int nW = 0;
        int aux = 0;
        int cont = 1;
        for(int k = 0; k < cantNodos; k++){
            for(int i = 0; i < cantNodos; i++){
                for(int j = 0; j < cantNodos; j++){
                    aux = and(matriz[i][k], w[k][j]);
                    nW = or(matriz[i][j], aux);
                    w[i][j] = nW;
                }
            }
            respuesta+="W"+cont+"\n";
            cont++;
            respuesta+=mostrarMatriz(w);
            matriz = w;

        }
        return this.respuesta;
    }

    public int or(int a, int b){
        return (a==1 | b== 1) ? 1 : 0;
    }

    public int and(int a, int b){
        return (a==1 && b==1) ? 1 : 0;
    }

    public String mostrarMatriz(int[][] matriz){
        String resultado="";
        for (int[] ints : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                resultado += ints[j] + " ";
            }
            resultado += "\n";
        }
        return  resultado;
    }
}
