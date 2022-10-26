package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Deijkstra {
    private int tam;
    private int[][] mr;
    private final int inf = 99999;
    private int ni;
    private int nf;
    private int nodoIntermedio;
    private int [][] tabla;
    private String respuesta;

    public Deijkstra(int tam, int[][] mr, int ni, int nf) {
        this.tam = tam;
        this.mr = mr;
        this.ni = ni;
        this.nf = nf;
        this.respuesta="";
        tabla = new int[2][tam];
        this.nodoIntermedio = (ni-1);
        filear();
        this.respuesta+="\nITERACION 0: \n";
        imprimir();
    }

    private void imprimir() {
        this.respuesta+="--------------------------\n";
        for(int i = 0; i<2; i++) {
            for(int j = 0; j<tam; j++) {
                if(tabla[i][j] == 99999)
                    this.respuesta+="X ";
                else
                    this.respuesta+=tabla[i][j] + " ";
            }
            this.respuesta+="\n";
        }
        this.respuesta+="--------------------------\n";
    }

    public void filear() {
        for(int i = 0; i<tam; i++) {
            if(i == (ni-1)) {
                tabla[0][i]=0;
                tabla[1][i]=1;
            }else {
                tabla[0][i]=inf;
                tabla[1][i]=0;
            }
        }
    }

    public String resolver() {

        int menor = inf;
        int index = 546;
        int aux = 0;

        for(int k = 0; k<tam; k++) {
            aux = 0;
            menor = inf;
            if(!verificar() && tabla[1][nf-1] != 1) {

                for(int n = 0; n<tam; n++) {

                    if(tabla[1][n] == 0 && tabla[1][nf-1] != 1) {
                        aux = minimo(tabla[0][n], (tabla[0][nodoIntermedio] + mr[nodoIntermedio][n]));

                        this.respuesta+="\nL("+(n+1+") = min(");

                        if(tabla[0][n] == inf)
                            this.respuesta+="X,";
                        else
                            this.respuesta+=tabla[0][n]+",";

                        if(tabla[0][nodoIntermedio] == inf)
                            this.respuesta+="X+";
                        else
                            this.respuesta+=tabla[0][nodoIntermedio]+"+";

                        if(mr[nodoIntermedio][n] == inf)
                            this.respuesta+="X) = ";
                        else
                            this.respuesta+=mr[nodoIntermedio][n]+") = ";

                        if(aux == inf)
                            this.respuesta+="X";
                        else
                            this.respuesta+=aux;

                        if(aux<menor) {
                            index = n; menor=aux;
                        }
                        tabla[0][n] = aux;
                    }
                }

                this.respuesta+="\nSE ASIGNA UNA ETIQUETA PERMANENTE AL NODO "+(index+1)+" CON UN VALOR DE: "+menor+"\n";
                tabla[0][index]=menor;
                tabla[1][index]=1;
                nodoIntermedio = index;
                this.respuesta+="\nITERACION: "+(k+1)+"\n";
                imprimir();
            }

        }
        return this.respuesta;
    }

    public int minimo(int a, int b) {
        return (a<=b) ? a : b;
    }

    public boolean verificar() {
        boolean filled = true;

        for(int i = 0; i<tam; i++) {
            if(tabla[1][i] == 0) {
                filled = false;
            }
        }

        return filled;
    }

}
