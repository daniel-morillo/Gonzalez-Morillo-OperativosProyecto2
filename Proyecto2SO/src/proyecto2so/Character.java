/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author Daniel Morillo
 */
public class Character {
    
    private String Name;
    private String Path;
    private int Priority;
    
    //Si son true, son de calidad
    private boolean AbilityQuality;
    private boolean VitalityQuality;
    private boolean StrengthQuality;
    private boolean AgilityQuality;
    
    //Valores de los atributos
    private int Ability;
    private int Vitality;
    private int Strength;
    private int Agility;

    public Character(String Name, String Path, int Priority, boolean AbilityQuality, boolean VitalityQuality, boolean StrengthQuality, boolean AgilityQuality, int Ability, int Vitality, int Strength, int Agility) {
        this.Name = Name;
        this.Path = Path;
        this.Priority = Priority;
        this.AbilityQuality = AbilityQuality;
        this.VitalityQuality = VitalityQuality;
        this.StrengthQuality = StrengthQuality;
        this.AgilityQuality = AgilityQuality;
        this.Ability = Ability;
        this.Vitality = Vitality;
        this.Strength = Strength;
        this.Agility = Agility;
    }
    
    

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Path
     */
    public String getPath() {
        return Path;
    }

    /**
     * @param Path the Path to set
     */
    public void setPath(String Path) {
        this.Path = Path;
    }

    /**
     * @return the Priority
     */
    public int getPriority() {
        return Priority;
    }

    /**
     * @param Priority the Priority to set
     */
    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    /**
     * @return the AbilityQuality
     */
    public boolean isAbilityQuality() {
        return AbilityQuality;
    }

    /**
     * @param AbilityQuality the AbilityQuality to set
     */
    public void setAbilityQuality(boolean AbilityQuality) {
        this.AbilityQuality = AbilityQuality;
    }

    /**
     * @return the VitalityQuality
     */
    public boolean isVitalityQuality() {
        return VitalityQuality;
    }

    /**
     * @param VitalityQuality the VitalityQuality to set
     */
    public void setVitalityQuality(boolean VitalityQuality) {
        this.VitalityQuality = VitalityQuality;
    }

    /**
     * @return the StrengthQuality
     */
    public boolean isStrengthQuality() {
        return StrengthQuality;
    }

    /**
     * @param StrengthQuality the StrengthQuality to set
     */
    public void setStrengthQuality(boolean StrengthQuality) {
        this.StrengthQuality = StrengthQuality;
    }

    /**
     * @return the AgilityQuality
     */
    public boolean isAgilityQuality() {
        return AgilityQuality;
    }

    /**
     * @param AgilityQuality the AgilityQuality to set
     */
    public void setAgilityQuality(boolean AgilityQuality) {
        this.AgilityQuality = AgilityQuality;
    }

    /**
     * @return the Ability
     */
    public int getAbility() {
        return Ability;
    }

    /**
     * @param Ability the Ability to set
     */
    public void setAbility(int Ability) {
        this.Ability = Ability;
    }

    /**
     * @return the Vitality
     */
    public int getVitality() {
        return Vitality;
    }

    /**
     * @param Vitality the Vitality to set
     */
    public void setVitality(int Vitality) {
        this.Vitality = Vitality;
    }

    /**
     * @return the Strength
     */
    public int getStrength() {
        return Strength;
    }

    /**
     * @param Strength the Strength to set
     */
    public void setStrength(int Strength) {
        this.Strength = Strength;
    }

    /**
     * @return the Agility
     */
    public int getAgility() {
        return Agility;
    }

    /**
     * @param Agility the Agility to set
     */
    public void setAgility(int Agility) {
        this.Agility = Agility;
    }
    
    
}
