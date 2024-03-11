/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
    
    private JLabel[] RSPriority1Labels;
    private JLabel[] RSPriority2Labels;
    private JLabel[] RSPriority3Labels;
    
    private JLabel[] AVPriority1Labels;
    private JLabel[] AVPriority2Labels;
    private JLabel[] AVPriority3Labels;
    
    private JTextArea[] ReinforcementLabels;
    
    private JTextArea[] QueueAreas;
    
    
    public  SO(Company Company1 , Company Company2, Semaphore mutex){
        
        this.Company1 = Company1;
        this.Company2 = Company2;
        this.countCycle = 0;
        this.mutex = mutex;
        this.Company1CharCounter = 0;
        this.Company2CharCounter = 0;
    }
    
    public Character[] combatientes() throws InterruptedException{
        
        ActLabels();
        
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
                        
                        System.out.println("pNo hay mas luchadores disponibles");
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
            pAux = getCompany1().getPriority1().getpFirst();
            
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
            pAux = getCompany2().getPriority1().getpFirst();
            
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
            pAux = getCompany1().getPriority2().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany1().getPriority1().encolar(pAux.getElemento());
                    pAux = pAux.getpNext();
                    getCompany1().getPriority2().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority2().esVacia()){
            pAux = getCompany2().getPriority2().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany2().getPriority1().encolar(pAux.getElemento());
                    pAux = pAux.getpNext();
                    getCompany2().getPriority2().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux = pAux.getpNext();
                }
            }
        }
        
        
        
        
        
        if(!Company1.getPriority3().esVacia()){
            pAux = getCompany1().getPriority3().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany1().getPriority2().encolar(pAux.getElemento());
                    pAux = pAux.getpNext();
                    getCompany1().getPriority3().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux= pAux.getpNext();
                }
            }
        }
        
        if(!Company2.getPriority3().esVacia()){
            pAux = getCompany2().getPriority3().getpFirst();
            
            while(pAux != null){
                
                if(pAux.getElemento().getPriorityCounter() == 8){
                    pAux.getElemento().setPriorityCounter(0);
                    getCompany2().getPriority2().encolar(pAux.getElemento());
                    pAux= pAux.getpNext();
                    getCompany2().getPriority3().desencolar();
                }else{
                    pAux.getElemento().setPriorityCounter(pAux.getElemento().getPriorityCounter() + 1);
                    pAux= pAux.getpNext();
                }
            }
        }
        
        this.setCountCycle(getCountCycle()+1);
        
        if (getCountCycle() >= 2){
            
            if (Math.random() >= 0.2) {
                
                getCompany1().CreateCharacter();
                getCompany2().CreateCharacter();
            }
        }
        
        
        checkReinforcements(Company1);
        checkReinforcements(Company2);
       
        
       ActLabels();
    }
    
    public void checkReinforcements(Company company) {
        
        if (!company.getReinforcements().esVacia()) {
        
        Nodo pAux = company.getReinforcements().getpFirst();
        company.getReinforcements().desencolar();
        
        if (Math.random() >= 0.6) {
            company.getPriority1().encolar(pAux.getElemento());
        } else {
            company.getReinforcements().encolar(pAux.getElemento());
        }
        }
    }
    
    public void ActLabels(){
        
        Character[] previewRS1 = getCompany1().getPriority1().ObtenerCola();
        Character[] previewRS2 = getCompany1().getPriority2().ObtenerCola();
        Character[] previewRS3 = getCompany1().getPriority3().ObtenerCola();
        
        Character[] previewAV1 = getCompany2().getPriority1().ObtenerCola();
        Character[] previewAV2 = getCompany2().getPriority2().ObtenerCola();
        Character[] previewAV3 = getCompany2().getPriority3().ObtenerCola();
        
        Refresh(previewRS1,getRSPriority1Labels());
        Refresh(previewRS2,getRSPriority2Labels());
        Refresh(previewRS3,getRSPriority3Labels());
        Refresh(previewAV1,getAVPriority1Labels());
        Refresh(previewAV2,getAVPriority2Labels());
        Refresh(previewAV3,getAVPriority3Labels());
        
        getQueueAreas()[0].setText(Company1.getPriority1().ColaInformation());
        getQueueAreas()[1].setText(Company1.getPriority2().ColaInformation());
        getQueueAreas()[2].setText(Company1.getPriority3().ColaInformation());
        getQueueAreas()[3].setText(Company2.getPriority1().ColaInformation());
        getQueueAreas()[4].setText(Company2.getPriority2().ColaInformation());
        getQueueAreas()[5].setText(Company2.getPriority3().ColaInformation());
        
        getReinforcementLabels()[0].setText(Company1.getReinforcements().ColaInformation());
        getReinforcementLabels()[1].setText(Company2.getReinforcements().ColaInformation());
        
    }
    
    public void Refresh(Character[] preview, JLabel[] labels ) {
        
    int countLabel = 0;
    int countChar = 0;
    
    while (countChar < preview.length && countLabel < labels.length) {
        
        if (preview[countChar] != null) {
            setImageLabel(labels[countLabel], preview[countChar].getPath());
            labels[countLabel+1].setText(preview[countChar].getID()); 
        } else {
            setImageLabel(labels[countLabel], "src/resources/NA.png");
            labels[countLabel+1].setText("NA"); 
            
        }
        
        countChar++;
        countLabel += 2;
    }       
}

    
    public void setImageLabel(JLabel nombrelabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(nombrelabel.getWidth(), nombrelabel.getHeight(), nombrelabel.getWidth()));
        nombrelabel.setIcon(icon);
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

    /**
     * @return the RSPriority1Labels
     */
    public JLabel[] getRSPriority1Labels() {
        return RSPriority1Labels;
    }

    /**
     * @param RSPriority1Labels the RSPriority1Labels to set
     */
    public void setRSPriority1Labels(JLabel[] RSPriority1Labels) {
        this.RSPriority1Labels = RSPriority1Labels;
    }

    /**
     * @return the RSPriority2Labels
     */
    public JLabel[] getRSPriority2Labels() {
        return RSPriority2Labels;
    }

    /**
     * @param RSPriority2Labels the RSPriority2Labels to set
     */
    public void setRSPriority2Labels(JLabel[] RSPriority2Labels) {
        this.RSPriority2Labels = RSPriority2Labels;
    }

    /**
     * @return the RSPriority3Labels
     */
    public JLabel[] getRSPriority3Labels() {
        return RSPriority3Labels;
    }

    /**
     * @param RSPriority3Labels the RSPriority3Labels to set
     */
    public void setRSPriority3Labels(JLabel[] RSPriority3Labels) {
        this.RSPriority3Labels = RSPriority3Labels;
    }

    /**
     * @return the AVPriority1Labels
     */
    public JLabel[] getAVPriority1Labels() {
        return AVPriority1Labels;
    }

    /**
     * @param AVPriority1Labels the AVPriority1Labels to set
     */
    public void setAVPriority1Labels(JLabel[] AVPriority1Labels) {
        this.AVPriority1Labels = AVPriority1Labels;
    }

    /**
     * @return the AVPriority2Labels
     */
    public JLabel[] getAVPriority2Labels() {
        return AVPriority2Labels;
    }

    /**
     * @param AVPriority2Labels the AVPriority2Labels to set
     */
    public void setAVPriority2Labels(JLabel[] AVPriority2Labels) {
        this.AVPriority2Labels = AVPriority2Labels;
    }

    /**
     * @return the AVPriority3Labels
     */
    public JLabel[] getAVPriority3Labels() {
        return AVPriority3Labels;
    }

    /**
     * @param AVPriority3Labels the AVPriority3Labels to set
     */
    public void setAVPriority3Labels(JLabel[] AVPriority3Labels) {
        this.AVPriority3Labels = AVPriority3Labels;
    }

    /**
     * @return the ReinforcementLabels
     */
    public JTextArea[] getReinforcementLabels() {
        return ReinforcementLabels;
    }

    /**
     * @param ReinforcementLabels the ReinforcementLabels to set
     */
    public void setReinforcementLabels(JTextArea[] ReinforcementLabels) {
        this.ReinforcementLabels = ReinforcementLabels;
    }

    /**
     * @return the QueueAreas
     */
    public JTextArea[] getQueueAreas() {
        return QueueAreas;
    }

    /**
     * @param QueueAreas the QueueAreas to set
     */
    public void setQueueAreas(JTextArea[] QueueAreas) {
        this.QueueAreas = QueueAreas;
    }
}
