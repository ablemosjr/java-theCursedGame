package model;

/** Classe de construção de personagem: Guerreiro
 * 
 * Atributos:
 * - Força Física
 * 
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Warrior extends Characters {
    
    private float strength;

    public Warrior(String name) {
        super(name, 50, 10);
        this.strength = 10;
    }
    
    public double getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Warrior {" + 
        "\nname = " + getName() +
        "\nvitality = " + getVitality() +
        "\nlevel = " + getLevel() +
        "\nexp = " + getExp() +
        "\nexp gain = " + getExpGain() +
        "\nstrength = " + this.strength +
        "\ndodge = " + getDodge() +
        "\n}";
    }

    @Override
    float attack() {
        return this.strength;
    }

    @Override
    float hurt(int dmg) {
        int dodge = (int) (getDodge() * 0.50);
        
        if(hitCalculation() < dodge) {
            System.out.println("Errou.");
        }

        float def = (float) (this.strength + (getDodge() * 0.50));
        float lifeCalculation = dmg - def;

        return lifeCalculation;
    }

    @Override
    float rest() {
        return this.strength / 2;
    }

    @Override
    boolean perish() {
        return getVitality() == 0 ? true : false;
    }
}
