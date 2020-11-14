/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package arbol.binario.listaligada.normal;

import arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario.Diccionario;
import arbol.binario.listaligada.busqueda.avl.ejemplos.diccionario.Palabra;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 *
 * @author Alejandro
 * @param <T>
 */
public class NodoBinarioGenerico<T> {

    protected  T dato;
    private NodoBinarioGenerico<T> li;
    private NodoBinarioGenerico<T> ld;
    // En casos avanzados
    private int ancho;

    public NodoBinarioGenerico(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }
    
    public void setDato(T dato){
        this.dato=dato;
    }

    public NodoBinarioGenerico<T> getLi() {
        return li;
    }

    public void setLi(NodoBinarioGenerico<T> li) {
        this.li = li;
    }

    public NodoBinarioGenerico<T> getLd() {
        return ld;
    }

    public void setLd(NodoBinarioGenerico<T> ld) {
        this.ld = ld;
    }

    public int getAncho() {
        return ancho;
    }

    /**
     * Este método es util para realizar grafica
     *
     * @return
     */
    public int recalcularAncho() {
        System.out.println("recalcular ancho");
        ancho = 1;
        if (this.getLi() != null) {
            ancho = ancho + this.getLi().recalcularAncho();
        }
        if (this.getLd() != null) {
            ancho = ancho + this.getLd().recalcularAncho();
        }
        return ancho;
    }
    
    public void generarArchivo() throws IOException{
        if(ld != null){
            ld.generarArchivo();
        }
        escribirArchivo();              
        if(li != null){
            li.generarArchivo();
        }
    }

    @Override
    public String toString() {
        return dato.toString();
    }

    private void escribirArchivo() throws IOException {
    String fileName = "export.txt";
    
    try {
      FileWriter myWriter = new FileWriter(fileName,true);
      Palabra palabra = (Palabra) dato;
        System.out.println(palabra);
      myWriter.write(palabra.getCadena()+"/"+palabra.getSignificado()+"/"+palabra.getSinonimo()+"/"+palabra.getAntonimo()+"\r \n");
      myWriter.close();
    } 
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
   /* Palabra palabra = (Palabra) dato;
    String textToAppend = "\r\n"+palabra.getCadena()+"/"+palabra.getSignificado()+"/"+palabra.getSinonimo()+"/"+palabra.getAntonimo(); //new line in content
    Path path = Paths.get("fil.txt");
    Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND); 
    
    /*BufferedWriter out = new BufferedWriter(
        new BufferedWriter(
            new FileWriter("file.txt", true) // true to append
                                // Set encoding
        )
    );*/
//    Palabra palabra = (Palabra) dato;
    //out.write(palabra.getCadena()+"/"+palabra.getSignificado()+"/"+palabra.getSinonimo()+"/"+palabra.getAntonimo());
    }

}
