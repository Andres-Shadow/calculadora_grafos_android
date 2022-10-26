package org.uniquindio.edu.co.calculadoragrafos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.uniquindio.edu.co.calculadoragrafos.Logica.Calculadora;

public class MainActivity extends AppCompatActivity {

    //WEAS LOGICA

    private Calculadora calculadora = new Calculadora();

    //WEAS
    private TextView  editTextResultado;
    private EditText editTextMultiLineMatriz, txtCantNodos, editTextNodoInicial, editTextNodoFinal;
    private Button buttonConexidad, buttonProducto ,buttonFloydWarshall ,buttonDeijkstra , buttonShumbell ,buttonWarshall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cantidad de nodos
        txtCantNodos = (EditText) findViewById(R.id.txtCantNodos);
        //edit text
        editTextMultiLineMatriz = (EditText) findViewById((R.id.editTextMultiLineMatriz));
        editTextResultado = (TextView) findViewById(R.id.editTextResultado);
        editTextNodoFinal = (EditText) findViewById(R.id.editTextNodoFinal);
        editTextNodoInicial = (EditText) findViewById(R.id.editTextNodoInicial);
        //botones
        buttonConexidad = (Button) findViewById(R.id.buttonConexidad);
        buttonProducto = (Button) findViewById(R.id.buttonProducto);
        buttonFloydWarshall = (Button) findViewById(R.id.buttonFloydWarshall);
        buttonDeijkstra = (Button) findViewById(R.id.buttonDeijkstra);
        buttonShumbell = (Button) findViewById(R.id.buttonShumbell);
        buttonWarshall = (Button) findViewById(R.id.buttonWarshall);

        buttonConexidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolverConexidad();
            }
        });

        buttonWarshall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolverWarshall();
            }
        });

        buttonProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolverProducto();
            }
        });

        buttonShumbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolverShumbell();
            }
        });

        buttonFloydWarshall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolverFloydWarshall();
            }
        });

        buttonDeijkstra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resolverDeijkstra();
            }
        });
    }


    //Metodos botones

    public void resolverConexidad(){

        int cantNodos = Integer.parseInt(txtCantNodos.getText().toString());
        editTextNodoInicial.setText("");
        editTextNodoFinal.setText("");
        String matriz = editTextMultiLineMatriz.getText().toString();
        matriz = matriz.replaceAll("\n","");
        String[] arreglo = matriz.split(",");

        if(arreglo.length == (cantNodos*cantNodos) ){
            int[] array = transformar(arreglo, cantNodos);
            if(verificar(array, 1)) {
                int[][] matrizRelaciones = toMatriz(array, cantNodos);
                String resultado = calculadora.resolverConexidad(cantNodos, matrizRelaciones);
                editTextResultado.setText(resultado);
            }
        }

    }

    public void resolverWarshall(){
        int cantNodos = Integer.parseInt(txtCantNodos.getText().toString());
        editTextNodoInicial.setText("");
        editTextNodoFinal.setText("");
        String matriz = editTextMultiLineMatriz.getText().toString();
        matriz = matriz.replaceAll("\n","");
        String[] arreglo = matriz.split(",");

        if(arreglo.length == (cantNodos*cantNodos)){
            int[] array = transformar(arreglo, cantNodos);
            if(verificar(array, 1)) {
                int[][] matrizRelaciones = toMatriz(array, cantNodos);
                String resultado = calculadora.resolverWarshal(cantNodos, matrizRelaciones);
                editTextResultado.setText(resultado);
            }
        }

    }

    public void resolverProducto(){
        int cantNodos = Integer.parseInt(txtCantNodos.getText().toString());
        editTextNodoInicial.setText("");
        editTextNodoFinal.setText("");
        String matriz = editTextMultiLineMatriz.getText().toString();
        matriz = matriz.replaceAll("\n","");
        String[] arreglo = matriz.split(",");

        if(arreglo.length == (cantNodos*cantNodos)){
            int[] array = transformar(arreglo, cantNodos);
            if(verificar(array, 1)) {
                int[][] matrizRelaciones = toMatriz(array, cantNodos);
                String resultado = calculadora.resolverProductoLogico(cantNodos, matrizRelaciones);
                editTextResultado.setText(resultado);
            }
        }


    }

    public void resolverShumbell(){
        int cantNodos = Integer.parseInt(txtCantNodos.getText().toString());
        editTextNodoInicial.setText("");
        editTextNodoFinal.setText("");
        String matriz = editTextMultiLineMatriz.getText().toString();
        matriz = matriz.replaceAll("\n","");
        String[] arreglo = matriz.split(",");

        if(arreglo.length == (cantNodos*cantNodos)){
            int[] array = transformar(arreglo, cantNodos);
            if(verificar(array, 1)) {
                int[][] matrizRelaciones = toMatriz(array, cantNodos);
                String resultado = calculadora.resolverShumbell(cantNodos, matrizRelaciones);
                editTextResultado.setText(resultado);
            }
        }
    }

    public void resolverFloydWarshall(){
        int cantNodos = Integer.parseInt(txtCantNodos.getText().toString());
        editTextNodoInicial.setText("");
        editTextNodoFinal.setText("");
        String matriz = editTextMultiLineMatriz.getText().toString();
        matriz = matriz.replaceAll("\n","");
        String[] arreglo = matriz.split(",");

        if(arreglo.length == (cantNodos*cantNodos)){
            int[] array = transformar(arreglo, cantNodos);
            if(verificar(array, 2)) {
                int[][] matrizRelaciones = toMatriz(array, cantNodos);
                String resultado = calculadora.resolverFloydWarshall(cantNodos, matrizRelaciones);
                editTextResultado.setText(resultado);
            }
        }

    }

    public void resolverDeijkstra(){
        int cantNodos = Integer.parseInt(txtCantNodos.getText().toString());
        int nodoInicial = Integer.parseInt(editTextNodoInicial.getText().toString());
        int nodoFinal = Integer.parseInt(editTextNodoFinal.getText().toString());
        String matriz = editTextMultiLineMatriz.getText().toString();
        matriz = matriz.replaceAll("\n","");
        String[] arreglo = matriz.split(",");

        if(arreglo.length == (cantNodos*cantNodos) && nodoFinal<=cantNodos && nodoInicial>0){
            int[] array = transformar(arreglo, cantNodos);
            if(verificar(array, 2)) {
                int[][] matrizRelaciones = toMatriz(array, cantNodos);
                String resultado = calculadora.resolverDeijkstra(cantNodos, matrizRelaciones,nodoInicial, nodoFinal);
                editTextResultado.setText(resultado);
            }
        }
    }





    // Metodos auxiliares
    public boolean verificar(int[] arreglo, int opcion){
        boolean resultado = true;

        switch (opcion){
            case 1:
                    for(int i: arreglo){
                        if(i!= 1 && i!= 0){
                            resultado=false;
                        }
                    }
                break;
            case 2:
                    for(int i: arreglo){
                        if(i<0){
                            resultado = false;
                        }
                    }
                    break;
            default:
                resultado = false;
        }


        return resultado;
    }

    public int[] transformar(String [] array, int tam){
        int [] array2 = new int[tam*tam];
        for(int i = 0; i<array.length; i++){
            array2[i] = Integer.parseInt(array[i]);
        }
        return array2;
    }

    public int[][] toMatriz(int[] array, int tam){
        int[][] matriz = new int[tam][tam];
        int contador = 0;
        for(int i = 0; i<tam; i++){
            for(int j = 0; j<tam; j++){
                matriz[i][j] = array[contador];
                contador++;
            }
        }
        return matriz;
    }


}