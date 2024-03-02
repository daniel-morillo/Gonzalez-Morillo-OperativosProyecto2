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
    
    public void borrar(Character C) {
        if (esVacia()) {
            System.out.println("Cola vacia");
            return;
        }

        
        if (leerCabeza() == C) {
            pFirst = pFirst.getpNext();
            if (pFirst == null) {
                pLast = null;
            }
            System.out.println("Luchador " + C.getName() + " eliminado");
            size--;
            return;
        }

        Nodo actual = pFirst;
        Nodo anterior = null;

        while (actual != null && actual.getElemento() != C) {
            anterior = actual;
            actual = actual.getpNext();
        }

        if (actual != null) {
            anterior.setpNext(actual.getpNext());
            if (actual == pLast) {
                pLast = anterior;
            }
            System.out.println("Luchador " + C.getName() + " eliminado");
            size--;
        } else {
            System.out.println("Elemento no encontrado");
        }
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

