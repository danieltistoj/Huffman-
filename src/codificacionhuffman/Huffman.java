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
    
    
    // ve cuantas veces se repite un caracter en una cadena
    public int FrecuenciaCaracter(char caracter, String cadena){
        int frecuencia = 0;
        for(int i=0; i<cadena.length();i++){
            if(caracter == cadena.charAt(i)){
                frecuencia++;
            }
            
        }
        return frecuencia;
    }
     //lee un archi txt y retorna lo que tenga el archivo en una cadean un string        
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
