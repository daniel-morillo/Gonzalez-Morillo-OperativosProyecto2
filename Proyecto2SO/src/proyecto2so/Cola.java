/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author Daniel Morillo
 */
public class Cola<T> {
    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int size;

    public Cola(){
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    public boolean esVacia() {
        return size == 0;
    }
    

    public void destructor() {
        while(pFirst!= null) {
            pFirst = pFirst.getpNext();
        }
    }
    

    public void encolar(T valor) {
        Nodo<T> pNew = new Nodo(valor);
        if (pFirst == null) {
            pFirst = pNew;
        } else {
            pLast.setpNext(pNew);
        }
        pLast = pNew;
        size ++; 
    }

    public void desencolar() {
        pFirst = pFirst.getpNext();
        size --;
        if (pFirst == null) {
            pLast = null;
        }
    }
    

    public T leerCabeza() {
        return pFirst.getElemento();
    }
    

    public Nodo<T> getpFirst() {
        return pFirst;
    }

    
    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }


    public Nodo<T> getpLast() {
        return pLast;
    }


    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}

