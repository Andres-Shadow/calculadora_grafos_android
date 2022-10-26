package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Shumbell {
    private int tamanio;
    private final int inf = 99999;
    private int [][] matriz1;
    private int [][] matriz2;
    private int [][] CAMINOS;
    private String respuesta;

    public Shumbell(int tamanio, int[][] mr){
        this.tamanio=tamanio;
        this.matriz1=mr;
        this.matriz2=mr;
        this.CAMINOS = new int[tamanio][tamanio];
        this.respuesta="";
    }

    public String resolver(){

        for(int i = 1; i<tamanio; i++) {
            matriz2 = calcular(matriz1, matriz2);
            this.respuesta+="-----------------------\n";
            imprimir(matriz2);
            this.respuesta+="-----------------------\n";
        }

        comparar(matriz1,matriz2);
        this.respuesta+="\nMATRIS S\n";
        this.respuesta+="-----------------------\n";
        imprimir(CAMINOS);
        this.respuesta+="-----------------------\n";
        return this.respuesta;
    }

    public int[][] calcular(int[][]m1, int[][] m2){
        int[][] aux = new int[tamanio][tamanio];
        int[] historial = new int[tamanio];
        int menor;
        for(int i = 0; i<tamanio; i++) {
            for(int j = 0; j<tamanio; j++) {
                this.respuesta+="\n"+(i+1)+" - "+(j+1);
                for(int k = 0; k<tamanio; k++) {

                    if(matriz1[i][k] >= inf)
                        this.respuesta+="X + ";

                    else
                        this.respuesta+=matriz1[i][k] + " + ";

                    if(matriz1[k][j] >= inf)
                        this.respuesta+="X = ";
                    else
                        this.respuesta+=matriz1[k][j] + " = ";

                    if((matriz1[i][k]+m2[k][j])>=inf)
                        this.respuesta+="X \n";
                    else
                        this.respuesta+=(matriz1[i][k]+m2[k][j])+" \n";

                    historial[k]=(matriz1[i][k]+m2[k][j]);
                }
                menor = mirarMenor(historial);
                if(menor>=inf)
                    this.respuesta+="\nEL MENOR ES: X\n";
                else
                    this.respuesta+="\nEL MENOR ES: "+menor+"\n";

                aux[i][j]=menor;
            }
        }
        return aux;
    }

    public int mirarMenor(int[] historial) {
        int menor = historial[0];

        for(int i = 0 ; i<tamanio; i++) {
            if(historial[i]<menor) {
                menor = historial[i];
            }
        }

        return menor;
    }

    public void imprimir(int[][] mr) {
        for(int i = 0 ; i<tamanio; i++) {
            for(int j = 0; j<tamanio; j++) {
                if(mr[i][j] == inf)
                    this.respuesta+="X ";
                else
                    this.respuesta+=mr[i][j]+" ";
            }
            this.respuesta+="\n";
        }
    }

    public void comparar(int[][] m1, int[][] m2) {

        for(int i = 0;i<tamanio; i++) {
            for(int j = 0; j<tamanio; j++) {
                if(i == j) {
                    CAMINOS[i][j] = 0;
                }

                if(m1[i][j] == inf && m2[i][j] == inf) {
                    CAMINOS[i][j] = 0;
                }

                if(m1[i][j]!=m2[i][j]) {
                    CAMINOS[i][j] = 0;
                }

                if(m1[i][j]==m2[i][j] && m1[i][j]!=inf && m2[i][j]!=inf && m1[i][j]!= 0 && m2[i][j]!= 0) {
                    CAMINOS[i][j] = 1;
                }

            }
        }


    }
}
