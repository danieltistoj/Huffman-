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
    private Nodo raiz, nodo_aux;
    private int size,conta;
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
    
    public void Buscar(char caracter){
       conta =0;
        Nodo aux = raiz;
        BuscarNodo(aux,caracter);
        System.out.println("");
        System.out.println("conta: "+conta);
        
    }
       private void BuscarNodo(Nodo nodo_raiz, char caracter){
        if(nodo_raiz!=null){
            conta++;
            if(caracter == nodo_raiz.getCaracter()){
                nodo_aux = nodo_raiz;
            }
            System.out.println("caracter: "+nodo_raiz.getCaracter()+" frecunecia: "+nodo_raiz.getFrecuencia());
            BuscarNodo(nodo_raiz.getHijoizq(),caracter);
            BuscarNodo(nodo_raiz.getHijoder(),caracter);
        }
        
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getNodo_aux() {
        return nodo_aux;
    }
    
    
    
}
