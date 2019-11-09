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
        /*
        Huffman compresion = new Huffman();
        System.out.println(compresion.LeerArchivo("C:\\Users\\Usuario\\Documents\\hola.txt"));
*/
        Lista lista = new Lista();
        lista.Insertar(3,'h');
        lista.Insertar(2,'g');
        lista.Insertar(1,'i');
        lista.Insertar(7,'a');
        lista.Mostrar();
    }
    
}
