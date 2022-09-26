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
    private float hpLoss;
    private int level;
    private float exp;
    private float expGain;
    private float dodge;
    private String race;

    public Characters() {
    }

    public Characters(String name, float vitality, float dodge, String race) {
        this.name = name;
        this.vitality = vitality;
        this.hpLoss = vitality;
        this.level = 1;
        this.exp = 10;
        this.dodge = dodge;
        this.expGain = 0;
        this.race = race;
    }
    
    public abstract float attack();
    public abstract float hurt(int dmg);
    public abstract float rest();
    
    public boolean perish(float hpLoss) {
        boolean lifeOrDeath = hpLoss > 0 ? true : false;
        return lifeOrDeath;
    }
    
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

    public float getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public float getExpGain() {
        return expGain;
    }

    public void setExpGain(int expGain) {
        this.expGain = expGain;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public float getHpLoss() {
        return hpLoss;
    }

    public void setHpLoss(float hpLoss) {
        this.hpLoss = hpLoss;
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
