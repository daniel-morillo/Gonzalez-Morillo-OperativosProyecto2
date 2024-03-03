/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author user
 */
public class SO {
    
    private Company Company1;
    private Company Company2;
    private int countCycle;
    
    
    public  SO(Company Company1 , Company Company2){
        
        this.Company1 = Company1;
        this.Company2 = Company2;
        this.countCycle = 0;
    }
    
    public Character[] combatientes(){
        
        Character[] CharactersArray = new Character[2];
        Character rsCharacter = null;
        Character avCharacter = null;
        
        if(!Company1.getPriority1().esVacia()){
        
            rsCharacter = Company1.getPriority1().leerCabeza();
        
        }else{
            
            if(!Company1.getPriority2().esVacia()){
                
                rsCharacter = Company1.getPriority2().leerCabeza();
                Company1.getPriority2().desencolar();
                Company1.getPriority1().encolar(rsCharacter);
            
            }else{
            
                if(!Company1.getPriority3().esVacia()){
                
                rsCharacter = Company1.getPriority3().leerCabeza();
                Company1.getPriority3().desencolar();
                Company1.getPriority1().encolar(rsCharacter);
                
                }else{
                    
                    if(!Company1.getReinforcements().esVacia()){
                
                        rsCharacter = Company1.getReinforcements().leerCabeza();
                        Company1.getReinforcements().desencolar();
                        Company1.getPriority1().encolar(rsCharacter);
                    
                }else{
                        
                        System.out.println("pNo hay mas luchadores disponibles");
                        return null;
                    }
                
                }
            
            }
        
        }
        
        
        
        if(!Company2.getPriority1().esVacia()){
        
            avCharacter = Company2.getPriority1().leerCabeza();
        
        }else{
            
            if(!Company2.getPriority2().esVacia()){
                
                avCharacter = Company2.getPriority2().leerCabeza();
                Company2.getPriority2().desencolar();
                Company2.getPriority1().encolar(avCharacter);
            
            }else{
            
                if(!Company2.getPriority3().esVacia()){
                
                avCharacter = Company2.getPriority3().leerCabeza();
                Company2.getPriority3().desencolar();
                Company2.getPriority1().encolar(avCharacter);
                
                }else{
                    
                    if(!Company2.getReinforcements().esVacia()){
                
                        avCharacter = Company2.getReinforcements().leerCabeza();
                        Company2.getReinforcements().desencolar();
                        Company2.getPriority1().encolar(avCharacter);
                    
                }else{
                        
                        System.out.println("pNo hay mas luchadores disponibles");
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
            pAux = Company1.getPriority1().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority1().esVacia()){
            pAux = Company2.getPriority1().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux.getpNext();
                }
            }
        }
        
        
        
        if(!Company1.getPriority2().esVacia()){
            pAux = Company1.getPriority2().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    Company1.getPriority1().encolar(pAux.getElemento());
                    pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority2().esVacia()){
            pAux = Company2.getPriority2().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    Company2.getPriority1().encolar(pAux.getElemento());
                    pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux.getpNext();
                }
            }
        }
        
        
        
        
        
        if(!Company1.getPriority3().esVacia()){
            pAux = Company1.getPriority3().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    Company1.getPriority2().encolar(pAux.getElemento());
                    pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority3().esVacia()){
            pAux = Company2.getPriority3().getpLast();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    Company2.getPriority2().encolar(pAux.getElemento());
                    pAux.getpNext();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux.getpNext();
                }
            }
        }
        
        this.countCycle =+ 1;
        
    }
}
