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
    
    public AI(Integer battleDuration){
        
        this.battleDuration = battleDuration;
    
    }
    
    
    public void starBattle(Character character1, Character character2){
        
        Random random = new Random();
        int result = random.nextInt(101);
        
        try {
            sleep(this.getBattleDuration());
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( 0 <= result && result <= 40){
            
            System.out.println("Emieza la batalla entre: " +  character1.getName() +  " y "  + character2.getName());
            
            Integer statsCharacter1 = character1.getAbility() + character1.getAgility() + character1.getStrength() + character1.getVitality();
            Integer statsCharacter2 = character2.getAbility() + character2.getAgility() + character2.getStrength() + character2.getVitality();
            
            if(statsCharacter1 == statsCharacter2){
                int finalBlow = random.nextInt(3);
            }
            
        }
        
    }

    public Integer getBattleDuration() {
        return battleDuration;
    }

    public void setBattleDuration(Integer battleDuration) {
        this.battleDuration = battleDuration;
    }
    
    
    
}
