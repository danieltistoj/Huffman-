/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Usuario
 */
public class Huffman {
    private String cadena = "";
    
    
    
    
    public String LeerArchivo(String direccion){
        cadena = "";
        File archivo;
        FileReader fr;
        BufferedReader br;
        
        try {
            archivo = new File(direccion);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                cadena+=linea;
            }
        } catch (Exception e) {
        }
        return cadena;
    }
    
}
