/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Usuario
 */
public class Huffman {
    private String cadena,cadena_binaria,cadenaAscii, cadena_tabla;
    private Lista lista,lista_tabla;//tendra cada caracter de la cadena con su respectiva frecuencia 
    private ArbolB arbol;
    public Huffman(){
        this.cadena = "";
        this.cadena_binaria = "";
        this.cadena_tabla = "";
        
    }
    
    //***Paso 5
    //se crea el cifrado en binario de la cadena. 
    public void ClaveBinario(){
        char caracter;
        Nodo nodo_aux;
        for(int i=0; i<cadena.length(); i++){
            caracter = cadena.charAt(i);
            nodo_aux = arbol.Buscar(caracter);
            cadena_binaria+=nodo_aux.getClave();
        }
        
        
    }
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
            nodo_actual.setClave(clave);
            nodo_actual = nodo_actual.getSiguiente();
        }
        HacerTabla();
        
    }
    private void HacerTabla(){
        Nodo nodo_aux = lista.getTope();
        while(nodo_aux!=null){
            cadena_tabla+=nodo_aux.getClave()+nodo_aux.getCaracter();
            nodo_aux = nodo_aux.getSiguiente();
        }
        System.out.println("Tabla: "+cadena_tabla);
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
          //lista.Mostrar();
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
        String cadena_aux = "";
        File archivo;
        FileReader fr;
        BufferedReader br;
        
        try {
            archivo = new File(direccion);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                cadena_aux+=linea;
            }
        } catch (Exception e) {
        }
        return cadena_aux;
    }
    
    public int BinarioAEntero(String binario){
        int entero = 0, potencia = 0;
        for(int i=binario.length()-1; i>=0 ;i--){
            if(binario.charAt(i) == '1'){
                entero += (int) Math.pow(2,potencia); 
                //System.out.println("entero: "+entero);
            }
            potencia++;
        }
        return entero;
    }
    //*** Paso 6
    //se pasa a codigo ascii la cadena binaria de la cadena 
    public void BinarioAascii(String cadena_binario){
        String cadena_ascii="", cadena_aux="";
        char caracter_ascii;
        int numero_caracteres,grupos,bits_sobrantes,contador=0,entero;//numro de caracteres - gupos de ocho bits - numero de bits sobrantes
        numero_caracteres = cadena_binario.length(); //se obtiene cuantos caracteres tiene la cadena binaria 
        grupos = numero_caracteres / 8; // se obtiene cuantos grupos de ocho hay
        bits_sobrantes = numero_caracteres - (8*grupos); // se obtienen el numero de bits que sobran, que no entran a un grupo de ocho 
        System.out.println("bits sobrantes: "+bits_sobrantes);
        if(grupos>0){// si al menos un grupo de 8 bits 
           
            for(int i = cadena_binario.length()-1;i>=bits_sobrantes;i--){ // se recorren 8 bits 
             contador++;
             cadena_aux = cadena_binario.charAt(i)+cadena_aux; // se va formando el numero binario 
            if(contador == 8){// si ya se completan los 8 bits 
                entero = BinarioAEntero(cadena_aux);//se convierte el nuemero binario a un numero entero 
                caracter_ascii =(char)entero; // el numero entero se convierte a ascii
                cadena_ascii = caracter_ascii+cadena_ascii;// se agrega el caracter ascii a su cadena 
                contador = 0; // el contador se deja a cero
                cadena_aux="";// se limpia la cadena para formar el numero binario
            }
            
        }
            
        }
        else{//si no hay grupos de ocho 
            for(int i = numero_caracteres-1; i>=0;i--){//se recorre todo la cadena binaria 
                cadena_aux = cadena_binario.charAt(i)+cadena_aux;
            }
            entero = BinarioAEntero(cadena_aux);//se pasa el numero binario a entero 
            caracter_ascii = (char)entero;// se convierte el numero entero a ascii
            cadena_ascii = caracter_ascii+cadena_ascii;// se agrega el caracter a la cadena ascii
        }
        
        //condicion que agrega los bits restantes a la cadena ascii
        if(bits_sobrantes>0 && grupos>0){
            cadena_aux="";
            for(int i = bits_sobrantes-1;i>=0;i--){//se recorre la cadena binaria desde se termina los grupos de ocho hasta que sea cero 
                cadena_aux = cadena_binario.charAt(i)+cadena_aux;
            }
            entero = BinarioAEntero(cadena_aux); // se pasa el numero binario a entero 
            caracter_ascii = (char)entero;//se vuelve el numero entero a ascii
            cadena_ascii = caracter_ascii+cadena_ascii;// se agrega el caracter ascii a la cadena ascii 
        }
        cadenaAscii = cadena_ascii; 
       // return cadenaAscii;
        
    }
    private String CompletarBinario(String cadena_bin){
        int ceros_faltantes = 8-cadena_bin.length(),conta = 0;
        while(conta<ceros_faltantes){
            cadena_bin = '0'+cadena_bin;
            conta++;
        }
        return cadena_bin;
    }
    public void Descomprimir(String cadena,String tabla){
        int num_caracteres = cadena.length(),numero_ascii;
        String secuencia_binaria, cadena_binaria1="";
        for(int i=cadena.length()-1;i>=0;i--){//se recorre la cadena de derecha a izquierda 
           // System.out.println(cadena.charAt(i));
            numero_ascii = cadena.charAt(i);//se obtiene el numero entero del caracter en cuestion
            secuencia_binaria = Integer.toBinaryString(numero_ascii);//se obtiene el numero binario 
            if(i>0 && secuencia_binaria.length()<8){//si el numero binario no tiene 8 bits y el caracter no es el ultimo, se completan los bits restantes con ceros
                secuencia_binaria = CompletarBinario(secuencia_binaria);// se completa el numero binario para que tenga ocho bits 
            }
            cadena_binaria1 = secuencia_binaria+cadena_binaria1;// se agraga este numero binario a la cadena 
        }
        System.out.println("cadena ascii descomprimida a binario: "+cadena_binaria1);
        TablaALista(tabla);
        CadenaOriginal(cadena_binaria1);
    }
    

    public  void CrearArchivoTabla(String ruta) throws IOException {
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(cadena_tabla);
        bw.close();
    }
    
    public  void CrearArchivoCadebaAscii(String ruta) throws IOException {
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(cadenaAscii);
        bw.close();
    }
    //pasa la tabla de valores a una lista 
    private  void TablaALista(String cadena){
        lista_tabla = new Lista();
        String cadena_clave = "";
        for(int i=0; i<cadena.length();i++){
            if(cadena.charAt(i)!='1' && cadena.charAt(i)!='0'){
                Nodo nodo_nuevo = new Nodo();
                nodo_nuevo.setCaracter(cadena.charAt(i));
                nodo_nuevo.setClave(cadena_clave);
                lista_tabla.Insertar(nodo_nuevo);
                cadena_clave = "";
            }
            else{
             
            cadena_clave+=cadena.charAt(i);
            }
        }
        //lista_tabla.Mostrar();
    }
     public char BuscarPorClave(String clave){
       Nodo nodo_actual = lista_tabla.getTope();
       char caracter=0;
       int conta = 0;
         //System.out.println("longitud clave: "+clave.length());
       while(nodo_actual!=null){
           if(nodo_actual.getClave().length() == clave.length()){
              // System.out.println("caracter: "+nodo_actual.getCaracter());
               //System.out.println(nodo_actual.getClave()+" "+clave);
               for(int i=0;i<clave.length();i++){
                   //System.out.println(nodo_actual.getClave().charAt(i)+" "+clave.charAt(i));
                   if(clave.charAt(i)== nodo_actual.getClave().charAt(i)){
                       //System.out.println("entro");
                       conta++;
                   }
               }
             
               if(conta == clave.length()){
                 // System.out.println("Entro");
                   caracter = nodo_actual.getCaracter();
                
               }
               conta = 0;
           }
           nodo_actual = nodo_actual.getSiguiente();
       }
         //System.out.println("contador: "+conta);
         //System.out.println("caracter: "+caracter);
       return caracter;
   }
     
    private void CadenaOriginal(String cadena_bin){
        String cadena_aux ="",cadena_final="";
        char caracter_aux;
        for(int i=0;i<cadena_bin.length();i++){
            cadena_aux+=cadena_bin.charAt(i);
             caracter_aux = BuscarPorClave(cadena_aux);
            if(caracter_aux!=0){
                cadena_final+=caracter_aux;
                cadena_aux="";
            }
        }
        System.out.println("cadena descomprimida: "+cadena_final);
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

    public String getCadena_binaria() {
        return cadena_binaria;
    }

    public Lista getLista_tabla() {
        return lista_tabla;
    }
    
    
}
