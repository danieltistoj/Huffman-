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
        //System.out.println("binario a entero: "+compresion.BinarioAEntero("10001110"));
         compresion.BinarioAascii(cadena_bin);
        compresion.CrearArchivoTabla("C:\\Users\\Usuario\\Documents\\tabla2.txt");
        compresion.CrearArchivoCadebaAscii("C:\\Users\\Usuario\\Documents\\cadenaAscii2.txt");
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
        
       // compresion.getArbol().Mostrar();
        //compresion.ClavesParaLetras();
        //compresion.ClavesParaLetras();
        //compresion.getLista().Mostrar();
       //Nodo nodo = compresion.getLista().getTope();
       // System.out.println("clave: "+nodo.getClave()+" caracter: "+nodo.getCaracter());
       // Nodo nodo_aux = compresion.getArbol().Buscar('o');
        //System.out.println(nodo_aux.getCaracter()+" "+nodo_aux.getFrecuencia());
        
        
//         compresion.getArbol().setRaiz(nodo);
       // Nodo raiz = compresion.getArbol().getRaiz();
  
        
     //    compresion.getArbol().Buscar('l');
         
         //System.out.println(compresion.getArbol().getNodo_aux().getCaracter());
        
       
       //compresion.getArbol().Buscar(compresion.getArbol().getRaiz(),'o');
       
       
      
       
       
        /*
       // System.out.println(compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\hola.txt"));
       //***Funcionamiento de la frecuencia de cada caracter
        String cadena = "hola como esta";
        System.out.println("cadena a evaluar: "+cadena);
        System.out.println("Frecuencia de h: " +compresion.FrecuenciaCaracter('h',cadena));
        System.out.println("Frecuencia de o: " +compresion.FrecuenciaCaracter('o',cadena));
        System.out.println("Frecuencia de l: " +compresion.FrecuenciaCaracter('l',cadena));
        System.out.println("Frecuencia de a: " +compresion.FrecuenciaCaracter('a',cadena));
        System.out.println("Frecuencia de _: " +compresion.FrecuenciaCaracter(' ',cadena));
        System.out.println("Frecuencia de c: " +compresion.FrecuenciaCaracter('c',cadena));
        System.out.println("Frecuencia de t: " +compresion.FrecuenciaCaracter('t',cadena));
         System.out.println("Frecuencia de m: " +compresion.FrecuenciaCaracter('t',cadena));
                
*/
     /*   
        //**Funcionamiento de la lista 
        Lista lista = new Lista();
        lista.Insertar(3,'h');
        lista.Insertar(2,'g');
        lista.Insertar(1,'i');
        lista.Insertar(7,'a');
        lista.Mostrar();
        System.out.println("Existe h: "+lista.Buscar('h'));
        System.out.println("Existe g: "+lista.Buscar('g'));
        System.out.println("Existe i: "+lista.Buscar('i'));
        System.out.println("Existe a: "+lista.Buscar('a'));
        System.out.println("Existe m: "+lista.Buscar('m'));
        System.out.println("Existe j: "+lista.Buscar('j'));
*/
     
    }
    
}
