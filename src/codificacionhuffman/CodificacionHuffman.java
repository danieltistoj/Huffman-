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
      
        //***Funcionamiento de la clase de lectura de archivo txt de la clase huffman
        
        
        Huffman compresion = new Huffman();
        /*
        char c = '8';
        int num = c;
        System.out.println("***"+num);
        String  secuencia_binaria = Integer.toBinaryString(8);//
        System.out.println(secuencia_binaria); 
        String cadena ="";
        cadena+='3';
        cadena+='0';
        int numEntero = Integer.parseInt(cadena);
        System.out.println(numEntero+1);
       */ 
       /*
        char c = 'a';
        int num = c;
        if(Character.isDigit(c)){
            System.out.println("es un digito");
        }
        else{
            System.out.println("no es un digito");
        }
        
       */
        
        //***Funcionamiento de la lista con los caracteres con su frecuencia de la cadena 
        //compresion.tablatxt("C:\\Users\\Usuario\\Documents\\prueva.txt","sfasdfa");
       
        String cadena = compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\hola.txt");
        long inicio = System.currentTimeMillis();
        System.out.println("cadena: "+cadena);
        compresion.CrearListaFrecuencias(cadena);
        compresion.getLista().Mostrar();
    
        compresion.CrearArbol();
        compresion.ClavesParaLetras();
        System.out.println("Caracter con la clave");
        compresion.getLista().Mostrar();
        compresion.ClaveBinario();
        String cadena_bin=compresion.getCadena_binaria();
        System.out.println("cadena binaria: "+cadena_bin);
         compresion.BinarioAascii(cadena_bin);
         System.out.println("cadena ascii: "+compresion.getCadenaAscii());
         
        compresion.CrearArchivoTabla("C:\\Users\\Usuario\\Documents\\tabla2.txt");
        compresion.CrearArchivoCadebaAscii("C:\\Users\\Usuario\\Documents\\cadenaAscii2.txt");
        
       //long inicio = System.currentTimeMillis();
        String cadena_ascii = compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\cadenaAscii2.txt");
        String cadena_tabla = compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\tabla2.txt");
        compresion.Descomprimir(cadena_ascii,cadena_tabla);
        
       
        long fin =  System.currentTimeMillis();
        BigDecimal inicio1 = new BigDecimal(inicio);
        BigDecimal fin1 = new BigDecimal(fin);
        BigDecimal mil = new BigDecimal(1000);
        fin1 = fin1.subtract(inicio1);
        fin1 = fin1.divide(mil);
        System.out.println("timepo de compresion: "+fin1+" segundos");
          
    }
    
}
