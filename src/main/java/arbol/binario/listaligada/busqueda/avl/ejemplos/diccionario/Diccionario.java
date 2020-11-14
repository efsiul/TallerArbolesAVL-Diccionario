/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;
/**
 *
 * @author Usuario
 */
public class Diccionario extends ArbolAVL {
    

    public VentanaBuscarPalabra busquePal = new VentanaBuscarPalabra();
    public static int iteraciones = 0;

    public static int cantidad;
    public  boolean bandera;
    private final JTextArea TextAreaResultado;
    private final JTextArea TextAreaSignificado;
    private final JTextArea TextAreaSinonimo;
    private final JTextArea TextAreaAntonimo;

    public Diccionario(JTextArea jTextAreaResultado,JTextArea jTextAreaSignificado, JTextArea jTextAreaSinonimo, JTextArea jTextAreaAntonimo ) throws IOException, Exception {
        this.cantidad = 0;
        this.TextAreaResultado = jTextAreaResultado;
        this.TextAreaSignificado=jTextAreaSignificado;
        this.TextAreaSinonimo=jTextAreaSinonimo;
        this.TextAreaAntonimo =jTextAreaAntonimo;
        this.bandera=false;
        load();
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    
    
    public final void load() throws FileNotFoundException, IOException, Exception {
        BufferedReader in = new BufferedReader(new FileReader("Spanish.dic"));
        String linea;
        while ((linea = in.readLine()) != null) {
            linea = (linea.split("\\/"))[0];
            Palabra pala=new Palabra(linea,"","","");
            InsertarPalabra(pala);
        }
    }
    
  
                   
    public  void InsertarPalabra(Palabra dato) throws Exception {
        if (super.buscar(dato) == null) {
            if( super.insertarDato(dato) == null){
                throw new Exception("Error al insertar la palabra " + dato);
            }
            
        }
        
    }
    public int getCantidad() {
        return cantidad;
    }


    public Palabra BuscarPalabra(Palabra dato) {
        NodoAVL miDato = super.buscar((Comparable) dato);
        if (miDato == null) {
            
            setBandera(false);
            TextAreaResultado.setText("La palabra no se encuentra");
        } else {
            setBandera(true);
            TextAreaResultado.setText("Palabra encontrada"+miDato.getDato());
            System.out.println(miDato.getDato());
            
            return (Palabra) miDato.getDato();
        }
        return null;
    }

    public void ModificarPalabra(Palabra actual, Palabra nueva){
        super.Modificar(actual, nueva);
    }
}
