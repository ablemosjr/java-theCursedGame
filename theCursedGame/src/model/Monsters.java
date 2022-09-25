package model;

import java.util.Random;

/** Classe de construção de monstros 
 *
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Monsters {
    
    private String name;
    private float vitality;
    private float strength;
    private float exp;
    
    public Monsters() {       
    }
    
    public void createMonsters() {
        Random randomMonster = new Random();
        int monster = randomMonster.nextInt(2) + 1;
        
        switch(monster) {
            case 1:
                setName("Goblin");
                setVitality(30);
                setStrength(4);
                setExp(8);
                break;
            case 2:
                setName("Orc");
                setVitality(80);
                setStrength(5);
                setExp(15);
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVitality() {
        return vitality;
    }

    public void setVitality(float vitality) {
        this.vitality = vitality;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Monsters{" + 
                "\nname = " + this.name + 
                "\nvitality = " + this.vitality + 
                "\nstrength = " + this.strength + 
                "\nexp = " + this.exp + 
                "\n}";
    }
}