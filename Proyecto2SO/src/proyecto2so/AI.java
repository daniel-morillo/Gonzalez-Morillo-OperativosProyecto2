/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AI extends Thread{
    
    private Integer battleDuration;
    private Company rsCompany;
    private Company avCompany;
    private Cola ganadores; //Cola provisional
    private Integer avWins;
    private Integer rsWins;
    
    public AI(Integer battleDuration, Company rsCompany, Company avCompany){
        
        this.battleDuration = battleDuration;
        this.rsCompany = rsCompany;
        this.avCompany = avCompany;
        this.avWins = 0;
        this.rsWins = 0;
    
    }
    
    /*Character1 = Regular show, Character2 = Avatar*/
    public void starBattle(Character character1, Character character2){
        
        Random random = new Random();
        int result = random.nextInt(101);
        
        try {
            sleep(this.getBattleDuration());
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*Como los personajes seleccionados para la pelea estan al tope de la cola de prioridad 1,
        Se desencolan ambas colas de proridad 1 para extraer a los personajes de la cola de espera*/
        this.rsCompany.getPriority1().desencolar();
        this.avCompany.getPriority1().desencolar();
        
        
        if( 0 <= result && result <= 40){
            
            System.out.println("Empieza la batalla entre: " +  character1.getName() +  " y "  + character2.getName());
            
            Integer statsCharacter1 = character1.getAbility() + character1.getAgility() + character1.getStrength() + character1.getVitality();
            Integer statsCharacter2 = character2.getAbility() + character2.getAgility() + character2.getStrength() + character2.getVitality();
            
            /*El personaje que gane es encolado a la cola de ganadores 
            y el personaje que perdio no es encolado a ningun sitio (Se pierde el rastro de su nodo y de esa forma se elimina)*/
            
            if(statsCharacter1 == statsCharacter2){
                
                int finalBlow = random.nextInt(2);
                
                if(finalBlow == 0){
                    System.out.println( character1.getName() + " logro acertar un golpe de gracia y se lleva la victoria");
                    
                    this.rsWins =+1;
                    
                    this.ganadores.encolar(character1);
                    
                }else{
                    System.out.println( character2.getName() + " logro acertar un golpe de gracia y se lleva la victoria");
                    
                    this.avWins =+1;
                    
                    this.ganadores.encolar(character2);
                }
                
            }else if(statsCharacter1 > statsCharacter2){
                System.out.println(character1.getName() + " es el ganador");
                
                this.rsWins =+1;
                
                this.ganadores.encolar(character1);
                
            }else{
                System.out.println(character2.getName() + " es el ganador");
                
                this.avWins =+1;
                    
                this.ganadores.encolar(character2);
                
            }
            
        }else if (40 < result && result <= 67){
            
            System.out.println("Empieza la batalla entre: " +  character1.getName() +  " y "  + character2.getName());
            System.out.println("...");
            System.out.println("Ambos los luchadores no pueden continuar. La pelea termina en empate");
            
            
            //Ambos personajes vuelven a ser encolados en sus respectivas colas
            
            this.rsCompany.getPriority1().encolar(character1);
            this.avCompany.getPriority1().encolar(character2);
            
        }else{
            System.out.println("Empieza la batalla entre: " +  character1.getName() +  " y "  + character2.getName());
            System.out.println("Los partipantes no se enceuntran listos. La pelea se cancela");
            
            //Se encolan en la cola de refuerzos
            
            
            this.rsCompany.getReinforcements().encolar(character1);
            this.avCompany.getReinforcements().encolar(character2);
        }
        
    }

    public Integer getBattleDuration() {
        return battleDuration;
    }

    public void setBattleDuration(Integer battleDuration) {
        this.battleDuration = battleDuration;
    }

    public Integer getAvWins() {
        return avWins;
    }

    public void setAvWins(Integer avWins) {
        this.avWins = avWins;
    }

    public Integer getRsWins() {
        return rsWins;
    }

    public void setRsWins(Integer rsWins) {
        this.rsWins = rsWins;
    }

    public Company getRsCompany() {
        return rsCompany;
    }

    public void setRsCompany(Company rsCompany) {
        this.rsCompany = rsCompany;
    }

    public Company getAvCompany() {
        return avCompany;
    }

    public void setAvCompany(Company avCompany) {
        this.avCompany = avCompany;
    }

    public Cola getGanadores() {
        return ganadores;
    }

    public void setGanadores(Cola ganadores) {
        this.ganadores = ganadores;
    }
    
    
    
}
