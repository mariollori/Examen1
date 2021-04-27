package Productores_Consumidores;

import java.util.LinkedList;

public class Cola {
    private int MAX_ELEMENTOS;
    LinkedList<Integer> cola;
    public Cola (int max){
            cola=new LinkedList<Integer>();
            this.MAX_ELEMENTOS=max;
    }
    /* En realidad, si estamos seguro de que nadie
    llamar� a este m�todo podriamos ponerla como no
    synchronized*/
    public synchronized boolean estaVacia(){
            int numElementos=cola.size();
            if (numElementos==0){
                    return true;
            }
            return false;
    }
    /* Igual que antes, si estamos seguro de que nadie
    llamar� a este m�todo podriamos ponerla como no
    synchronized*/
    public synchronized boolean estaLlena(){
            int numElementos=cola.size();
            if (numElementos==this.MAX_ELEMENTOS){
                    return true;
            }
            return false;
    }
    /* Devuelve true si se pudo hacer y false si no se pudo*/
    public synchronized boolean encolar(int numero){
            if (estaLlena()){
                    return false;
            }
            cola.addLast(numero);
            return true;
    }
    public synchronized int desencolar(){
            /* Necesitamos un n�mero especial que act�e
            como comprobador de errores*/
            if (estaVacia()){
                    return -1;
            }
            int numero=cola.removeFirst();
            return numero;
    }

}