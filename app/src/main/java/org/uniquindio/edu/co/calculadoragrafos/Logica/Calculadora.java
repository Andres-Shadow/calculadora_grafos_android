package org.uniquindio.edu.co.calculadoragrafos.Logica;

public class Calculadora {
    //INSTANCIAS DIFERENTES METODOS
    private Warshall warshall;
    private Conexidad conexidad;
    private Producto_Logico producto_logico;
    private Shumbell shumbell;
    private Floyd_Warshall floyd_warshall;
    private Deijkstra deijkstra;

    public Calculadora(){};

    public String resolverWarshal(int cantNodos, int[][] matriz){
        String respuesta = "";
        warshall = new Warshall(cantNodos, matriz);
        respuesta = warshall.resolver();
        return respuesta;
    }

    public String resolverConexidad(int cantNodos, int[][] matriz){
        String respuesta = "";
        conexidad = new Conexidad(cantNodos, matriz);
        respuesta = conexidad.resolver();
        return  respuesta;
    }

    public String resolverProductoLogico(int cantNodos, int[][] matriz){
        String respuesta = "";
        producto_logico = new Producto_Logico(cantNodos,matriz);
        respuesta=producto_logico.resolver();
        return respuesta;
    }

    public String resolverShumbell(int cantNodos, int[][] matriz){
        String respuesta="";
        shumbell = new Shumbell(cantNodos,matriz);
        respuesta=shumbell.resolver();
        return respuesta;
    }

    public String resolverFloydWarshall(int cantNodos, int[][] matriz){
        String respuesta = "";
        floyd_warshall = new Floyd_Warshall(cantNodos, matriz);
        respuesta=floyd_warshall.resolver();
        return respuesta;
    }

    public String resolverDeijkstra(int cantNodos, int[][] matriz, int nodoInicial, int nodoFinal){
        String respuesta = "";
        deijkstra = new Deijkstra(cantNodos, matriz, nodoInicial, nodoFinal);
        respuesta = deijkstra.resolver();
        return respuesta;
    }

}
