package model;

import java.util.Random;

/** Classe de construção dos personagens
 * 
 * Atributos:
 * - Nome
 * - Vida
 * - Nível
 * - Quantidade de experiência
 * - Esquiva
 * 
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public abstract class Characters {
    
    private String name;
    private float vitality;
    private int level;
    private float exp;
    private float expGain;
    private float dodge;

    public Characters() {
    }

    public Characters(String name, float vitality, float dodge) {
        this.name = name;
        this.vitality = vitality;
        this.level = 1;
        this.exp = 10;
        this.dodge = dodge;
        this.expGain = 0;
    }
    
    abstract float attack();
    abstract float hurt(int dmg);
    abstract float rest();
    abstract boolean perish();
    
    protected int hitCalculation() {
        Random hitCalculation = new Random();
        
        int hit = hitCalculation.nextInt(50) + 1;
        return hit;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public float getExpGain() {
        return expGain;
    }

    public void setExpGain(float expGain) {
        this.expGain = expGain;
    }

    @Override
    public String toString() {
        return "Personagens {" + 
                "\nname = " + this.name + 
                "\nvitality = " + this.vitality + 
                "\nlevel = " + this.level + 
                "\nexp = " + this.exp + 
                "\nexp gain = " + this.expGain + 
                "\ndodge = " + this.dodge + 
                "\n}";
    }
}
