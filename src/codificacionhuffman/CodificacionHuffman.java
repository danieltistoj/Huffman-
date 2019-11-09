/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

/**
 *
 * @author Usuario
 */
public class CodificacionHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //***Funcionamiento de la clase de lectura de archivo txt de la clase huffman
        Huffman compresion = new Huffman();
        //***Funcionamiento de la lista con los caracteres con su frecuencia de la cadena 
        String cadena = "hola mama";
        System.out.println("cadena: "+cadena);
        compresion.CrearListaFrecuencias(cadena);
        compresion.getLista().Mostrar();
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
