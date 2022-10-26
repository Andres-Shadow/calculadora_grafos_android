package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Conexidad {
    private int tam;
    private int[][] m;
    private int[][] m2;
    private String respuesta;

    public Conexidad(int tam, int[][] m) {
        this.tam = tam;
        this.m=m;
        this.m2=m;
        this.respuesta = "";
    }

    public String resolver() {
        boolean conexo = false;

        for(int n=0; n<=tam; n++) {
            if(!verificar()) {
                this.respuesta+="m"+(n+2);
                m2 = multiplicar(m,m2);
                imprimir(m2);
            }
            else{
                conexo = true;
            }

        }
        if(conexo)
            this.respuesta+="\n\nGrafo Conexo :D\n\n";
        else
            this.respuesta+="\n\nGrafo No Conexo :D\n\n";

        return this.respuesta;
    }

    public boolean verificar() {
        boolean conexo = true;
        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam; j++) {
                if(m2[i][j]==0) {
                    conexo = false;
                }
            }
        }
        return conexo;
    }

    public int[][] multiplicar(int[][] m, int[][] m2){
        int suma;
        int[][] aux = new int[tam][tam];
        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam; j++) {
                suma = 0;
                for(int k=0; k<tam; k++) {
                    suma+=m[i][k]*m2[k][j];
                }
                aux[i][j]=suma;
            }
        }
        return aux;
    }

    private void imprimir(int[][] m2) {
        this.respuesta+="\n-----------------------\n";

        for(int i=0; i<tam; i++ ) {
            for(int j=0; j<tam; j++) {
                this.respuesta+=m2[i][j]+" ";

            }
            this.respuesta+="\n";
        }
        this.respuesta+="\n-----------------------\n";
    }
}
