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
    private Lista lista;//tendra cada caracter de la cadena con su respectiva frecuencia 
    private ArbolB arbol;
    //***Paso 3 
    //Crea el arbol en donde estan los nodos que contienen cada caracter con su debida frecuencia 
    public void CrearArbol(){
        Nodo nodo_nuevo = new Nodo(), nodo_1 = lista.getTope(),nodo_2 = lista.getTope().getSiguiente();
        int sumfre;
        if(lista.getSize()>1){//vemos que la lista tenga mas de un nodo 
            sumfre = nodo_1.getFrecuencia() + nodo_2.getFrecuencia();//sumamos las frecuencias de los primeros dos nodos
            nodo_nuevo.setFrecuencia(sumfre); //le agregamos la suma de las frecuencias al nuevo nodo 
            nodo_1.setPadre(nodo_nuevo); //el padre de los primeros nodos de la lista sera el nuevo nodo 
            nodo_2.setPadre(nodo_nuevo);
            
            nodo_1.setLado(0); //el primer nodo sera el menor de los dos primeros nodos de la lista por eso tendra un cero 
            nodo_2.setLado(1); //el segundo nodo sera el mayor de los dos primeros nodos por eso llevara un uno 
            
            nodo_nuevo.setHijoder(nodo_2); //el nodo_2 por ser mayor ira a la izquierda 
            nodo_nuevo.setHijoizq(nodo_1);//el nodo_1 por ser menor ira a la derecha 
            
            Nodo nodo_conti = nodo_2.getSiguiente();//se obtiene el nodo siguiente al nodo_2 para poder hacer una nueva lista que incluye al nuevo nodo
            NuevaLista(nodo_conti,nodo_nuevo);//se hace la nueva lista 
            CrearArbol();//se vuelve a llamar a la funcion 
            
        }
        else{//si la lista tiene solo un nodo 
            arbol = new ArbolB(); // se inicializa el arbol 
            arbol.setRaiz(lista.getTope());// se pone el tope de la lista de nodos en la raiz del arbol.  
        }
    }
    private void NuevaLista(Nodo nodo_conti,Nodo nodo_nuevo){
        lista = new Lista();
        while(nodo_conti!=null){
            lista.Insertar(nodo_conti);
            nodo_conti = nodo_conti.getSiguiente();
        }
        lista.Insertar(nodo_nuevo);
        
    }
    //***Paso 2 
    //Se crea la lista con los nodos que contienen cada caracter con su frecuencia y que estan de forma ordenada de menor a mayor 
    public void CrearListaFrecuencias(String cadena){
        lista = new Lista();//va a contener cada caracter de la cadena con el numero de veces que se repite 
        char caracter_actual;
        int frecuencia;
        for(int i=0; i<cadena.length();i++){
            
            caracter_actual = cadena.charAt(i); //extrae el caracter
            frecuencia = FrecuenciaCaracter(caracter_actual, cadena);//busca cuantas veces se repite 
            
            Nodo nuevo_nodo = new Nodo(); // se crea un nuevo nodo
            nuevo_nodo.setCaracter(caracter_actual);// se inserta en el nuevo nodo el caracter
            nuevo_nodo.setFrecuencia(frecuencia);// se ingresa en el nuevo nodo la fercuencia del caracter 
            
            if(lista.getTope() == null){ // esta primera condicion es cuando la lista esta vacia 
                lista.Insertar(nuevo_nodo);//lo inserta en la lista 
            }
            else{
                if(!lista.Buscar(caracter_actual)){//si el caracter no esta en la lista lo insertamos 
                    lista.Insertar(nuevo_nodo);// se inserta en la lista 
                }
                //si el caracter ya esta en la lista ya no se inserta
            }
        }
    }
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
    //***Paso 1 
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

    public Lista getLista() {
        return lista;
    }
    
}
