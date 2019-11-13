/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class CodificacionHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InterruptedException, IOException {
       Ventana ventana = new Ventana();
       ventana.setVisible(true);
        


//***Funcionamiento de la clase de lectura de archivo txt de la clase huffman
        
      
      
        //***Funcionamiento de la lista con los caracteres con su frecuencia de la cadena 
        //compresion.tablatxt("C:\\Users\\Usuario\\Documents\\prueva.txt","sfasdfa");
        
       /*
       
       Huffman compresion = new Huffman();
        String cadena = compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\hola.txt");
        long inicio = System.currentTimeMillis();
        System.out.println("cadena: "+cadena);
        compresion.CrearListaFrecuencias(cadena);
        System.out.println(compresion.getLista().Mostrar());
       
        compresion.CrearArbol();
        compresion.ClavesParaLetras();
        System.out.println("Caracter con la clave");
        System.out.println( compresion.getLista().Mostrar());
       
        compresion.ClaveBinario();
        String cadena_bin=compresion.getCadena_binaria();
        System.out.println("cadena binaria: "+cadena_bin);
         compresion.BinarioAascii(cadena_bin);
         System.out.println(compresion.getCadena_ascii_entero());
         System.out.println("cadena ascii: "+compresion.getCadenaAscii());
         
        compresion.CrearArchivoTabla("C:\\Users\\Usuario\\Documents\\tabla2.txt");
        compresion.CrearArchivoCadebaAscii("C:\\Users\\Usuario\\Documents\\cadenaAscii2.txt");
       
        
        
       // long inicio = System.currentTimeMillis();
        //Huffman compresion = new Huffman();
        
        String cadena_ascii = compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\cadenaAscii2.txt");
        String cadena_tabla = compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\tabla2.txt");
        System.out.println("cadena ascii: "+cadena_ascii);
        compresion.Descomprimir(cadena_ascii,cadena_tabla);
        System.out.println(compresion.getTabla_descompresio());
        System.out.println(compresion.getCadena_des());
        System.out.println(compresion.getCadena_binaria());
       
        long fin =  System.currentTimeMillis();
        BigDecimal inicio1 = new BigDecimal(inicio);
        BigDecimal fin1 = new BigDecimal(fin);
        BigDecimal mil = new BigDecimal(1000);
        fin1 = fin1.subtract(inicio1);
        fin1 = fin1.divide(mil);
        System.out.println("timepo de compresion: "+fin1+" segundos");
     
       */  
    }
    
}
