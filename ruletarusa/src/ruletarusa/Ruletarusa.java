/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ruletarusa;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ruletarusa {
    public class Nodo {
    private int valor;
    private Nodo siguiente;
    public void Nodo(int w){
        this.valor = w;
        this.siguiente = null;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }   
}
    public class ListaCircular {
    private Nodo inicio;
    private Nodo ultimo;
    private int tamanio;
    public void Lista(){
        inicio = null;
        ultimo = null;
        tamanio = 0;//tamaño del archivo de texto//
    }
     public boolean esVacia(){ //pa ver si es vacia//
        return inicio == null;
    }
     public int getTamanio(){/*muestra el tamaño (que lo usaremos mas adelante 
         para el contador de jugadores)*/
        return tamanio;
    }
    }

    public class Revolver {
        private int posicionBala;
        private int posicionBalaActual;
        public Revolver(){
            posicionBalaActual = aleatorio(1,6);
            posicionBala = aleatorio(1, 6);
        }
        public boolean disparar(){
            boolean exito = false;
            if (posicionBalaActual == posicionBala){
                exito = true;
            }
            siguienteBala();
            
            return exito;
        }
        public void siguienteBala(){
            if(posicionBalaActual==6){
                posicionBalaActual = 1;
            }else{
                posicionBalaActual++;
            }
        }
        public String toString(){
            return "posicion bala actual: "+posicionBalaActual + ". Posicion bala: "+ posicionBala;
        }
    }
    public class Jugador {
        private int id;
        private String name;
        private boolean vivo;
        public Jugador (int id){
            this.id = id;
            this.name = name;
            this.vivo = true;
        }
        public void accionarRevolver(Revolver r){
            if(r.disparar()){
               this.vivo=false;
                System.out.println(name+" ha muerto...");
                
            }else {
                System.out.println(name+" ha sobrevivido");
            }
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
        public boolean isVivo(){
            return vivo;
        }
        public void setvivo(boolean vivo){
            this.vivo=vivo;
        }
    }
    public class Juego{
        private Jugador[] jugadores;
        private Revolver[] revolver;
           public Juego(int numJugadores){
               jugadores = new Jugador[numJugadores];
               crearJugadores();
               revolver = new Revolver[numJugadores];
               crearRevolver();
               }
           public void crearJugadores(){
               for(int i=0;i<jugadores.length;i++){
                   jugadores[i]= new Jugador(i+1);
                   
               }
           }
           public void crearRevolver(){
              for(int i=0;i<jugadores.length;i++){
               revolver[i]=new Revolver();
           } 
           }
          
           public boolean finRonda(){
               
               
               for(int i=0;i<jugadores.length;i++){
                   if(!jugadores[i].isVivo()){
                   return true;
               }
               }
               return false;
           }
        public void rondas(){
         for(int i=0;i<jugadores.length;i++){
             
             jugadores[i].accionarRevolver(revolver[i+1]);
         } 
         
        }
    }
    
        public int aleatorio(int minimo, int maximo){
            int num = (int) Math.floor(Math.random()* (maximo - minimo +1)+(minimo));
            return num;
        }
    
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner sc= new Scanner(System.in);/*por poner un juego, necesito sacar 
       el num de jugadores del archivo y tal pero no se como*/
      
       System.out.println("num jugadores:");
       int x= sc.nextInt();
       Juego a= new Juego(x); //error
       //aqui faltara un while para gestionar que solo quede uno en pie al final de las tondas
       while (!Juego.finRonda() ){//error
           Juego.ronda();//error
       } 
        System.out.println("juego terminado");
        
        
    }
    
}
