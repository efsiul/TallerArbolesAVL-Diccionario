/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Luis Felipe Cadavid
 */
public class Sinonimo extends ArbolAVL {
    
    
    private int cantidad;
    private final JTextArea TextAreaSinonimo;

    

    public Sinonimo (JTextArea TextAreaSinonimo) throws IOException, Exception{
    this.TextAreaSinonimo = TextAreaSinonimo;
    }
    
    public void insertar(Comparable dato) throws Exception {
        if (super.buscar(dato) == null) {
            if( super.insertarDato(dato) == null){
                throw new Exception("Error al insertar la palabra " + dato);
            }
            cantidad++;
            TextAreaSinonimo.setText((String) dato);
        }
    }

    public int getCantidad() {
        return cantidad;
    }
    
        public void buscarSinonimo(String dato) {
        if ( super.buscar((Comparable) dato) == null) {
            TextAreaSinonimo.setText("La palabra " + dato + " No se encuentra");
            
        } else {
            TextAreaSinonimo.setText("Urra!!! Palabra encontrada ");

        }
    }
}    

