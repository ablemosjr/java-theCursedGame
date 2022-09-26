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
    private float inteligence;

    public Mage(String name) {
        super(name, 20, 5, "Mago");
        this.wisdom = 30;
        this.inteligence = 10;
    }

    public float getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public float getInteligence() {
        return inteligence;
    }

    public void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }

    @Override
    public String toString() {
        return "Mage {" + 
        "\nname = " + getName() +
        "\nvitality = " + getVitality() +
        "\nlevel = " + getLevel() +
        "\nrace = " + getRace() +
        "\nexp = " + getExp() +
        "\nexp gain = " + getExpGain() +
        "\nwisdom = " + this.wisdom +
        "\nhealing = " + this.inteligence +
        "\ndodge = " + getDodge() +
        "\n}";
    }

    @Override
    public float attack() {
        return (int) ((this.wisdom * 0.60) + (this.inteligence * 0.20));
    }

    @Override
    public float hurt(int dmg) {  
        int dodge = (int) (getDodge() * 0.50);
        
        if(hitCalculation() < dodge) {
            System.out.println("Errou.");
        }
        
        float def = (float) ((this.wisdom * 0.10) + (getDodge() * 0.50));
        float lifeCalculation = dmg - def;
        
        return lifeCalculation;
    }

    @Override
    public float rest() {
        return (float) (this.inteligence + (getDodge() * 0.10));
    }
}