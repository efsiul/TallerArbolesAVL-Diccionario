/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;


/**
 *
 * @author 57300
 */
public class Palabra implements Comparable<Palabra> {
    private String cadena;
    private String significado;
    private String sinonimo;
    private String antonimo; 

    public Palabra(String cadena, String significado, String sinonimo, String antonimo) {
        this.significado=significado;
        this.cadena=cadena;
        this.sinonimo=sinonimo; 
        this.antonimo=antonimo;

    }
 
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public String getSignificado() {
        return significado;
    }
    
    public void setSignificado(String significado) {
        this.significado = significado;
    }

    
    
    public String getSinonimo() {
        return sinonimo;
    }

    
    public void setSinonimo(String sinonimo) {
        this.sinonimo = sinonimo;
    }

    public String getAntonimo() {
        return antonimo;
    }

    public void setAntonimo(String antonimo) {
        this.antonimo = antonimo;
    }



    public String getPalabra() {
        return cadena;
    }


    @Override
    public int compareTo(Palabra o) {
        Palabra t = (Palabra) o;
        String pb = t.getPalabra();
        return cadena.compareToIgnoreCase(pb);
    }

    @Override
    public String toString() {
        return "Palabra: "+ cadena + " Significado: " + significado+ " Sinonimo: "+ sinonimo+" Antonimo: "+antonimo;
    }

}
