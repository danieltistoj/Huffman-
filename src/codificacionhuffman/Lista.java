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
public class Lista {
   private Nodo tope=null;
   private int size=0;
   
   public void Insertar(int dato,char caracter){
       tope = Agregar(dato,tope,caracter);
       size++;
   }
   
   public Nodo Agregar(int dato, Nodo actual,char caracter){
       if(actual==null){
           actual = new Nodo();
           actual.setFrecuencia(dato);
           actual.setCaracter(caracter);
           actual.setSiguiente(null);
       }else{
           if(actual.getFrecuencia()<dato){
               actual.setSiguiente(Agregar(dato,actual.getSiguiente(),caracter));
           }else{
               Nodo aux = new Nodo();
               aux.setFrecuencia(dato);
               aux.setSiguiente(actual);
               actual = aux;
           }
       }
       return actual;
   }
    
}
