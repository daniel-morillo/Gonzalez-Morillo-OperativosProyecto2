/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

import static java.lang.Thread.sleep;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class AI extends Thread {

    private Integer battleDuration;
    private Company rsCompany;
    private Company avCompany;
    private Cola ganadores; //Cola provisional
    private Integer avWins;
    private Integer rsWins;
    private Semaphore mutex;
    private JLabel[] RSLabels;
    private JLabel[] AVLabels;
    public JLabel status;
    private JLabel[] Scorelabels;

    public AI(Integer battleDuration, Company rsCompany, Company avCompany, Semaphore mutex) {

        this.battleDuration = battleDuration;
        this.rsCompany = rsCompany;
        this.avCompany = avCompany;
        this.avWins = 0;
        this.rsWins = 0;
        this.mutex = mutex;
        this.ganadores = new Cola();

    }

    /*Character1 = Regular show, Character2 = Avatar*/
    public void starBattle(Character character1, Character character2) throws InterruptedException {
        
        ActLabels();
        status.setText("Simulando Combate");
        
        Random random = new Random();
        int result = random.nextInt(101);

        try {
            sleep(this.getBattleDuration());
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Como los personajes seleccionados para la pelea estan al tope de la cola de prioridad 1,
        Se desencolan ambas colas de proridad 1 para extraer a los personajes de la cola de espera*/
        ActLabels();
        this.rsCompany.getPriority1().desencolar();
        this.avCompany.getPriority1().desencolar();
        
        if (0 <= result && result <= 47) {

            System.out.println("Empieza la batalla entre: " + character1.getName() + " y " + character2.getName());

            Integer statsCharacter1 = character1.getAbility() + character1.getAgility() + character1.getStrength() + character1.getVitality();
            Integer statsCharacter2 = character2.getAbility() + character2.getAgility() + character2.getStrength() + character2.getVitality();

            /*El personaje que gane es encolado a la cola de ganadores 
            y el personaje que perdio no es encolado a ningun sitio (Se pierde el rastro de su nodo y de esa forma se elimina)*/
            if (Objects.equals(statsCharacter1, statsCharacter2)) {

                int finalBlow = random.nextInt(2);

                if (finalBlow == 0) {
                    System.out.println(character1.getName() + " logro acertar un golpe de gracia y se lleva la victoria");

                    this.rsWins  ++;

                    this.ganadores.encolar(character1);

                } else {
                    System.out.println(character2.getName() + " logro acertar un golpe de gracia y se lleva la victoria");

                    this.avWins  ++;

                    this.ganadores.encolar(character2);
                }

            } else if (statsCharacter1 > statsCharacter2) {
                System.out.println(character1.getName() + " es el ganador");

                this.rsWins ++;

                this.ganadores.encolar(character1);

            } else {
                System.out.println(character2.getName() + " es el ganador");

                this.avWins ++;

                this.ganadores.encolar(character2);

            }

        } else if (47 < result && result <= 67) {

            System.out.println("Empieza la batalla entre: " + character1.getName() + " y " + character2.getName());
            System.out.println("...");
            System.out.println("Ambos los luchadores no pueden continuar. La pelea termina en empate");

            //Ambos personajes vuelven a ser encolados en sus respectivas colas
            this.rsCompany.getPriority1().encolar(character1);
            this.avCompany.getPriority1().encolar(character2);

        } else {
            System.out.println("Empieza la batalla entre: " + character1.getName() + " y " + character2.getName());
            System.out.println("Los partipantes no se enceuntran listos. La pelea se cancela");

            //Se encolan en la cola de refuerzos
            this.rsCompany.getReinforcements().encolar(character1);
            this.avCompany.getReinforcements().encolar(character2);
        }

    }

    public void ActLabels() throws InterruptedException {
        
        status.setText("Anunciando resultados");
        sleep(300);
        getScorelabels()[0].setText(String.valueOf(getRsWins()));
        getScorelabels()[1].setText(String.valueOf(getAvWins()));
        getRSLabels()[0].setText(getRsCompany().getPriority1().leerCabeza().getID());
        setImageLabel(getRSLabels()[1], getRsCompany().getPriority1().leerCabeza().getPath());
        getRSLabels()[2].setText(String.valueOf(getRsCompany().getPriority1().leerCabeza().getVitality()));
        getRSLabels()[3].setText(String.valueOf(getRsCompany().getPriority1().leerCabeza().getAbility()));
        getRSLabels()[4].setText(String.valueOf(getRsCompany().getPriority1().leerCabeza().getStrength()));
        getRSLabels()[5].setText(String.valueOf(getRsCompany().getPriority1().leerCabeza().getAbility()));
        
        getAVLabels()[0].setText(getAvCompany().getPriority1().leerCabeza().getID());
        setImageLabel(getAVLabels()[1], getAvCompany().getPriority1().leerCabeza().getPath());
        getAVLabels()[2].setText(String.valueOf(getAvCompany().getPriority1().leerCabeza().getVitality()));
        getAVLabels()[3].setText(String.valueOf(getAvCompany().getPriority1().leerCabeza().getAbility()));
        getAVLabels()[4].setText(String.valueOf(getAvCompany().getPriority1().leerCabeza().getStrength()));
        getAVLabels()[5].setText(String.valueOf(getAvCompany().getPriority1().leerCabeza().getAbility()));
    }

    public void setImageLabel(JLabel nombrelabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(nombrelabel.getWidth(), nombrelabel.getHeight(), nombrelabel.getWidth()));
        nombrelabel.setIcon(icon);
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
     * @return the RSLabels
     */
    public JLabel[] getRSLabels() {
        return RSLabels;
    }

    /**
     * @param RSLabels the RSLabels to set
     */
    public void setRSLabels(JLabel[] RSLabels) {
        this.RSLabels = RSLabels;
    }

    /**
     * @return the AVLabels
     */
    public JLabel[] getAVLabels() {
        return AVLabels;
    }

    /**
     * @param AVLabels the AVLabels to set
     */
    public void setAVLabels(JLabel[] AVLabels) {
        this.AVLabels = AVLabels;
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    /**
     * @return the Scorelabels
     */
    public JLabel[] getScorelabels() {
        return Scorelabels;
    }

    /**
     * @param Scorelabels the Scorelabels to set
     */
    public void setScorelabels(JLabel[] Scorelabels) {
        this.Scorelabels = Scorelabels;
    }
    
    

}
