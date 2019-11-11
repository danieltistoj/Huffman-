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
   //***Paso 4 
    //encontrar la clave binaria de 
    public void ClavesParaLetras(){
        CrearListaFrecuencias(cadena); //se crea una lista para tener cada letra para evaluarla en el arbol
        Nodo nodo_actual = lista.getTope();
        String clave;
        char caracter;
        String cadena1;
        while(nodo_actual!=null){// se recorre la lista 
            caracter = nodo_actual.getCaracter(); // se obtiene el caracter del nodo actual
            Nodo nodo_caracter = arbol.Buscar(caracter);// se obtiene el nodo del caracter actual
            clave = RecorridoAscendente(nodo_caracter);// se obtiene la clave recorriendo el arbol desde el nodo_caracter hasta la raiz 
            clave = RotarClave(clave); // se rota la clave
            nodo_caracter.setClave(clave);// la clave se agrega al nodo que tiene el caracter 
            nodo_actual = nodo_actual.getSiguiente();
        }
        
    }
    private String RotarClave(String clave){
        String clave_rotada="";
        for(int i=clave.length()-1;i>=0; i--){
            clave_rotada+=clave.charAt(i);
        }
       // System.out.println("clave rotada: "+clave_rotada+" clave: "+clave);
        return clave_rotada;
    }
    private String RecorridoAscendente(Nodo nodo){
        String cadena = "";
        Nodo nodo_padre = nodo.getPadre();
        int lado = nodo.getLado();
        char caracter = nodo.getCaracter();
        while(nodo.getPadre()!= null){
            cadena += nodo.getLado();
            nodo = nodo.getPadre();
        }
        /*
        System.out.println("caracter: "+caracter+" clave: "+cadena+" Lado: "+lado);
        System.out.println("caracter padre: "+nodo_padre.getCaracter()+" Lado: "+nodo_padre.getLado()+" Frecuencia: "+nodo_padre.getFrecuencia());
        System.out.println("");
*/
        return cadena;
    }
    //***Paso 3 
    //Crea el arbol en donde estan los nodos que contienen cada caracter con su debida frecuencia 
    public void CrearArbol(){
        if(lista.getSize()>1){
        Lista lista_aux = new Lista();//creamos una lista auxiliar 
        Nodo nodo_nuevo = new Nodo(), nodo_1 = new Nodo(),nodo_2 = new Nodo(),nodo_conti = null;//creamos cuatro nodos 
       //pasamos los datos de los dos primeros nodos a dos nuevos nodos 
        //nodo_1 = lista.getTope();
       nodo_1 = lista.getTope();
        nodo_1.setLado(0);//como es el menor de los dos lleva un 0
        
        nodo_2 = lista.getTope().getSiguiente();
        nodo_2.setLado(1);
        //ponemos los datos del nuevo nodo, que tendra como caracter basio o 0, y como frecuencia las la suma de las frecuencias de los dos primeros nodos de la lista 
        nodo_nuevo.setFrecuencia(nodo_1.getFrecuencia()+nodo_2.getFrecuencia());
        nodo_nuevo.setHijoder(nodo_2);
        nodo_nuevo.setHijoizq(nodo_1);
        
        //asignamos el padre a los dos primeros nodos
        nodo_1.setPadre(nodo_nuevo);
        nodo_2.setPadre(nodo_nuevo);
         //obtenesmos el nodo que le le sigue al nodo_2 que seria el nodo 3 si este es distinto de nulo
        if(lista.getTope().getSiguiente().getSiguiente()!=null){
            nodo_conti = lista.getTope().getSiguiente().getSiguiente();
        }
          NuevaLista(lista_aux, nodo_conti);//ponemos todos los nodos que siguen del nodo dos en una lista auxiliar 
          lista_aux.Insertar(nodo_nuevo);//y por ultimo insertamos el nuevo nodo. 
          
          lista = lista_aux;
          System.out.println("");
          lista.Mostrar();
          CrearArbol();
          
        }
        else{
            arbol = new ArbolB();
            arbol.setRaiz(lista.getTope());
            arbol.Organizar();
            lista.setTope(null);
            
        }
        
    }
    //hacemos una nueva lista con los nodos que le siguen a los dos primeros que agarramos para formar los seudo arboles
    private void NuevaLista(Lista lista_aux,Nodo nodo_conti){
      while(nodo_conti!=null){
          
             Nodo nuevo_nodo = new Nodo();
             nuevo_nodo.setCaracter(nodo_conti.getCaracter());
             nuevo_nodo.setFrecuencia(nodo_conti.getFrecuencia());
             Nodo hijo_izq = nodo_conti.getHijoizq(), hijo_der = nodo_conti.getHijoder();        
             nuevo_nodo.setHijoder(hijo_der);
             nuevo_nodo.setHijoizq(hijo_izq);
             
             lista_aux.Insertar(nuevo_nodo);
             nodo_conti = nodo_conti.getSiguiente();
         }
         lista = lista_aux;
   
    }
    //***Paso 2 
    //Se crea la lista con los nodos que contienen cada caracter con su frecuencia y que estan de forma ordenada de menor a mayor 
    public void CrearListaFrecuencias(String cadena){
        this.cadena = cadena;
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
    private int FrecuenciaCaracter(char caracter, String cadena){
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

    public ArbolB getArbol() {
        return arbol;
    }

    public void setArbol(ArbolB arbol) {
        this.arbol = arbol;
    }
    
}
