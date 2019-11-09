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
   
   public void Insertar(int frecuencia,char caracter){
       tope = Agregar(frecuencia,tope,caracter);
       size++;
   }
   
   private Nodo Agregar(int frecuencia, Nodo actual,char caracter){
       if(actual==null){
           actual = new Nodo();
           actual.setFrecuencia(frecuencia);
           actual.setCaracter(caracter);
           actual.setSiguiente(null);
       }else{
           if(actual.getFrecuencia()<frecuencia){
               actual.setSiguiente(Agregar(frecuencia,actual.getSiguiente(),caracter));
           }else{
               Nodo aux = new Nodo();
               aux.setFrecuencia(frecuencia);
               aux.setCaracter(caracter);
               aux.setSiguiente(actual);
               actual = aux;
           }
       }
       return actual;
   }
   public boolean Buscar(char caracter){
       Nodo actual = tope;
       boolean existe = false;
      return BuscarNodo(caracter,actual, existe);
   }
    private boolean BuscarNodo(char caracter,Nodo actual,boolean existe){
        if(actual!=null){
            if(actual.getCaracter() == caracter){
                return true;
            }
            else{
                actual = actual.getSiguiente();
               return  BuscarNodo(caracter, actual, existe);
            }
        }
        else{
            return existe = false;
        }
        
    }
    
    public void Mostrar(){
        Nodo nodo_actual = tope;
        while(nodo_actual!=null){
            System.out.println("Caracter: "+nodo_actual.getCaracter()+" --> Frecuencia: "+nodo_actual.getFrecuencia());
            nodo_actual = nodo_actual.getSiguiente();
        }
    }
    
    
}
