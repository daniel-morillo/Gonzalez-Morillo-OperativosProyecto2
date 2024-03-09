/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class SO extends Thread  {
    
    private Company Company1;
    private int Company1CharCounter;
    private Company Company2;
    private int Company2CharCounter;
    private int countCycle;
    private Semaphore mutex;
    
    
    public  SO(Company Company1 , Company Company2, Semaphore mutex){
        
        this.Company1 = Company1;
        this.Company2 = Company2;
        this.countCycle = 0;
        this.mutex = mutex;
        this.Company1CharCounter = 0;
        this.Company2CharCounter = 0;
    }
    
    public Character[] combatientes() throws InterruptedException{
        
        Character[] CharactersArray = new Character[2];
        Character rsCharacter = null;
        Character avCharacter = null;
        
        if(!Company1.getPriority1().esVacia()){
        
            rsCharacter = getCompany1().getPriority1().leerCabeza();
        
        }else{
            
            if(!Company1.getPriority2().esVacia()){
                
                rsCharacter = getCompany1().getPriority2().leerCabeza();
                getCompany1().getPriority2().desencolar();
                getCompany1().getPriority1().encolar(rsCharacter);
            
            }else{
            
                if(!Company1.getPriority3().esVacia()){
                
                rsCharacter = getCompany1().getPriority3().leerCabeza();
                    getCompany1().getPriority3().desencolar();
                    getCompany1().getPriority1().encolar(rsCharacter);
                
                }else{
                    
                    if(!Company1.getReinforcements().esVacia()){
                
                        rsCharacter = getCompany1().getReinforcements().leerCabeza();
                        getCompany1().getReinforcements().desencolar();
                        getCompany1().getPriority1().encolar(rsCharacter);
                    
                }else{
                        
                        System.out.println("No hay mas luchadores disponibles");
                        return null;
                    }
                
                }
            
            }
        
        }
        
        
        
        if(!Company2.getPriority1().esVacia()){
        
            avCharacter = getCompany2().getPriority1().leerCabeza();
        
        }else{
            
            if(!Company2.getPriority2().esVacia()){
                
                avCharacter = getCompany2().getPriority2().leerCabeza();
                getCompany2().getPriority2().desencolar();
                getCompany2().getPriority1().encolar(avCharacter);
            
            }else{
            
                if(!Company2.getPriority3().esVacia()){
                
                avCharacter = getCompany2().getPriority3().leerCabeza();
                    getCompany2().getPriority3().desencolar();
                    getCompany2().getPriority1().encolar(avCharacter);
                
                }else{
                    
                    if(!Company2.getReinforcements().esVacia()){
                
                        avCharacter = getCompany2().getReinforcements().leerCabeza();
                        getCompany2().getReinforcements().desencolar();
                        getCompany2().getPriority1().encolar(avCharacter);
                    
                }else{
                        
                        System.out.println("No hay mas luchadores disponibles");
                        return null;
                    }
                
                }
            
            }
        
        }
        
        CharactersArray[0] = rsCharacter;
        CharactersArray[1] = avCharacter;
        
        return CharactersArray;
        
    }
    
    
    
    public void actualizarColas(){
        
        Nodo pAux;
        
        
        if(!Company1.getPriority1().esVacia()){
            pAux = getCompany1().getPriority1().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority1().esVacia()){
            pAux = getCompany2().getPriority1().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        
        
        if(!Company1.getPriority2().esVacia()){
            pAux = getCompany1().getPriority2().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany1().getPriority1().encolar(pAux.getElemento());
                    getCompany1().getPriority2().borrar(pAux.getElemento());
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority2().esVacia()){
            pAux = getCompany2().getPriority2().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany2().getPriority1().encolar(pAux.getElemento());
                    getCompany2().getPriority2().borrar(pAux.getElemento());
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        
        
        
        
        if(!Company1.getPriority3().esVacia()){
            pAux = getCompany1().getPriority3().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany1().getPriority2().encolar(pAux.getElemento());
                    getCompany1().getPriority3().borrar(pAux.getElemento());
                    pAux = pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux= pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority3().esVacia()){
            pAux = getCompany2().getPriority3().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany2().getPriority2().encolar(pAux.getElemento());
                    getCompany2().getPriority3().borrar(pAux.getElemento());
                    pAux= pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux= pAux.getpNext();
                }
            }
        }
        
        this.setCountCycle(+ 1);
        
        if (getCountCycle() >= 2){
            
            if (Math.random() >= 0.2) {
                
                getCompany1().CreateCharacter();
                getCompany2().CreateCharacter();
            }
        }
        
    }

    /**
     * @return the Company1
     */
    public Company getCompany1() {
        return Company1;
    }

    /**
     * @param Company1 the Company1 to set
     */
    public void setCompany1(Company Company1) {
        this.Company1 = Company1;
    }

    /**
     * @return the Company2
     */
    public Company getCompany2() {
        return Company2;
    }

    /**
     * @param Company2 the Company2 to set
     */
    public void setCompany2(Company Company2) {
        this.Company2 = Company2;
    }

    /**
     * @return the countCycle
     */
    public int getCountCycle() {
        return countCycle;
    }

    /**
     * @param countCycle the countCycle to set
     */
    public void setCountCycle(int countCycle) {
        this.countCycle = countCycle;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param mutex the mutex to set
     */
    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    /**
     * @return the Company1CharCounter
     */
    public int getCompany1CharCounter() {
        return Company1CharCounter;
    }

    /**
     * @param Company1CharCounter the Company1CharCounter to set
     */
    public void setCompany1CharCounter(int Company1CharCounter) {
        this.Company1CharCounter = Company1CharCounter;
    }

    /**
     * @return the Company2CharCounter
     */
    public int getCompany2CharCounter() {
        return Company2CharCounter;
    }

    /**
     * @param Company2CharCounter the Company2CharCounter to set
     */
    public void setCompany2CharCounter(int Company2CharCounter) {
        this.Company2CharCounter = Company2CharCounter;
    }
}
