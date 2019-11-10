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
public class ArbolB {
    private Nodo raiz;
    private int size;
    private String cadena = "";
    
     public void Insertar(int  frecuencia){
        raiz = Agregar(raiz,frecuencia);
    }
    private Nodo Agregar(Nodo nodo, int frecuencia){
        if(nodo==null){
            nodo = new Nodo();
            nodo.setFrecuencia(frecuencia);
            nodo.setClave(cadena);
            nodo.setHijoder(null);
            nodo.setHijoizq(null);
        }
        else{
            if(frecuencia < nodo.getFrecuencia()){
                nodo.setHijoizq(Agregar(nodo.getHijoizq(), frecuencia));
                cadena+="0";
                
            }
            if(frecuencia> nodo.getFrecuencia()){
                nodo.setHijoder(Agregar(nodo.getHijoder(),frecuencia));
                cadena+="1";
            }
            
        }
        return nodo;
    }
    
    public int Ordenar_Pre(Nodo nodo){
        int conta =0;
        Nodo aux = nodo;
        Preorden(aux);
        return conta;
        
    }
       private void Preorden(Nodo nodo_raiz){
        if(nodo_raiz!=null){
           
            Preorden(nodo_raiz.getHijoizq());
            Preorden(nodo_raiz.getHijoder());
        }
        
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    
    
}
