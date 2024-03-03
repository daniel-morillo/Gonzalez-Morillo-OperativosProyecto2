/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author user
 */
public class Simulacion extends Thread{
    
    private Company company1;
    private Company company2;
    private SO so;
    private AI ai;
    
    
    public Simulacion(Company company1, Company company2, SO so, AI ai){
        
        this.company1 = company1;
        this.company2 = company2;
        this.so = so;
        this.ai =  ai;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 13; i++) { //When the simulation is started, it generates the first 20 characters
            company1.CreateCharacter();
            company2.CreateCharacter();
            

        }
    }
}
