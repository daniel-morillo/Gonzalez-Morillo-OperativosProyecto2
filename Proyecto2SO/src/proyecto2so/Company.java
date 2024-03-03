/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author Daniel Morillo
 */
public class Company {
    
    private String[] names;
    private String[] images;
    
    private Cola Priority1;
    private Cola Priority2;
    private Cola Priority3;
    private Cola Reinforcements;
    private char Prefix;
    private int NumCharacter;
    private int Numimg;

    public Company(char prefix, String[] names, String[] images) {
        
        this.Prefix = prefix;
        this.names = names;
        this.images = images;
        this.Priority1 = new Cola();
        this.Priority2 = new Cola();
        this.Priority3 = new Cola();
        this.Reinforcements = new Cola();
        this.NumCharacter = 0;
        
    }
    
    public void CreateCharacter(){
      
                
        int Ability = (int)(Math.floor(Math.random()*100));
        int Agility = (int)(Math.floor(Math.random()*100));
        int Strength = (int)(Math.floor(Math.random()*100));
        int HP = (int)(Math.floor(Math.random()*100));
        
        String ID = getPrefix() + String.valueOf(getNumCharacter());
        
        Character newCharater = new Character(ID, getNames()[getNumimg()], getImages()[getNumimg()], isQuality(0), isQuality(1), isQuality(2), isQuality(3),Ability,HP, Strength, Agility);
        
        givePriority(newCharater);
        
        setNumCharacter(getNumCharacter()+1);
        setNumimg(getNumimg()+1);
        
        if (getNumimg()>= getNames().length) {
            setNumimg(0);
        }
    }
    
    public int isQuality (int item) {
        //0: Habilidad, 1: HP, 2: Fuerza, 3: Agilidad
        int Validation = 0;
        
        switch(item) {
            
            case 0: if (Math.random() >= 0.4) {
                Validation = 1;
            }
            case 1: if (Math.random() >= 0.3) {
                Validation = 1;
            }
            case 2: if (Math.random() >= 0.5) {
                Validation = 1;
            }
            case 3: if (Math.random() >= 0.6) {
                Validation = 1;
            }
            
        }
        
        return Validation;
    }
    
    public void givePriority(Character character) {
        
        int Quality = character.getAbilityQuality() + character.getAgilityQuality() + character.getStrengthQuality() + character.getVitalityQuality();
        
        switch (Quality) {
            
            case 4: getPriority1().encolar(character);
            case 3: getPriority1().encolar(character);
            case 2: getPriority2().encolar(character);
            case 1: getPriority2().encolar(character);
            case 0: getPriority3().encolar(character);
        }
    }
    
    

    /**
     * @return the Priority1
     */
    public Cola getPriority1() {
        return Priority1;
    }

    /**
     * @param Priority1 the Priority1 to set
     */
    public void setPriority1(Cola Priority1) {
        this.Priority1 = Priority1;
    }

    /**
     * @return the Priority2
     */
    public Cola getPriority2() {
        return Priority2;
    }

    /**
     * @param Priority2 the Priority2 to set
     */
    public void setPriority2(Cola Priority2) {
        this.Priority2 = Priority2;
    }

    /**
     * @return the Priority3
     */
    public Cola getPriority3() {
        return Priority3;
    }

    /**
     * @param Priority3 the Priority3 to set
     */
    public void setPriority3(Cola Priority3) {
        this.Priority3 = Priority3;
    }

    /**
     * @return the Reinforcements
     */
    public Cola getReinforcements() {
        return Reinforcements;
    }

    /**
     * @param Reinforcements the Reinforcements to set
     */
    public void setReinforcements(Cola Reinforcements) {
        this.Reinforcements = Reinforcements;
    }

    /**
     * @return the Prefix
     */
    public char getPrefix() {
        return Prefix;
    }

    /**
     * @param Prefix the Prefix to set
     */
    public void setPrefix(char Prefix) {
        this.Prefix = Prefix;
    }

    /**
     * @return the NumCharacter
     */
    public int getNumCharacter() {
        return NumCharacter;
    }

    /**
     * @param NumCharacter the NumCharacter to set
     */
    public void setNumCharacter(int NumCharacter) {
        this.NumCharacter = NumCharacter;
    }

    /**
     * @return the names
     */
    public String[] getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(String[] names) {
        this.names = names;
    }

    /**
     * @return the images
     */
    public String[] getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(String[] images) {
        this.images = images;
    }

    /**
     * @return the Numimg
     */
    public int getNumimg() {
        return Numimg;
    }

    /**
     * @param Numimg the Numimg to set
     */
    public void setNumimg(int Numimg) {
        this.Numimg = Numimg;
    }
    
    
    
    
}
