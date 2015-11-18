/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

public class NodoDelArbol {
    
    
    private int valorDelNodo;
    private NodoDelArbol nodoIzquierdo;
    private NodoDelArbol nodoDerecho;

    public NodoDelArbol(int valorDelNodo) {
        this.valorDelNodo = valorDelNodo;
        this.nodoDerecho = null;
        this.nodoIzquierdo = null;
    }

    public void setValorDelNodo(int valorDelNodo) {
        this.valorDelNodo = valorDelNodo;
    }

    public int getValorDelNodo() {
        return this.valorDelNodo;
    }

    public void setNodoDerecho(NodoDelArbol derecho) {
        this.nodoDerecho = derecho;
    }

    public NodoDelArbol getNodoDerecho() {
        return this.nodoDerecho;
    }

    public void setNodoIzquierdo(NodoDelArbol izquierdo) {
        this.nodoIzquierdo = izquierdo;
    }

    public NodoDelArbol getNodoIzquierdo() {
        return this.nodoIzquierdo;
    }
    
    
}
