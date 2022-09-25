package model;

/** Classe de construção de personagem: Mago
 * 
 * Atributos:
 * - Poder de magia
 * - Poder de cura
 * 
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Mage extends Characters {
    
    private float wisdom;
    private float healing;

    public Mage(String name) {
        super(name, 20, 5);
        this.wisdom = 30;
        this.healing = 10;
    }

    public double getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public double getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    @Override
    public String toString() {
        return "Mage {" + 
        "\nname = " + getName() +
        "\nvitality = " + getVitality() +
        "\nlevel = " + getLevel() +
        "\nexp = " + getExp() +
        "\nexp gain = " + getExpGain() +
        "\nwisdom = " + this.wisdom +
        "\nhealing = " + this.healing +
        "\ndodge = " + getDodge() +
        "\n}";
    }

    @Override
    float attack() {
        return (float) (this.wisdom * 0.80);
    }

    @Override
    float hurt(int dmg) {  
        int dodge = (int) (getDodge() * 0.50);
        
        if(hitCalculation() < dodge) {
            System.out.println("Errou.");
        }
        
        float def = (float) ((this.wisdom * 0.10) + (getDodge() * 0.50));
        float lifeCalculation = dmg - def;
        
        return lifeCalculation;
    }

    @Override
    float rest() {
        return (float) (this.healing + (getDodge() * 0.10));
    }

    @Override
    boolean perish() {
        return getVitality() == 0 ? true : false;
    }
}
