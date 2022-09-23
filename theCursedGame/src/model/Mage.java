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
    
    private double wisdom;
    private double healing;

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
        "\nvitality = " + getVitality()+
        "\nlevel = " + getLevel()+
        "\nwisdom = " + this.wisdom +
        "\nhealing = " + this.healing +
        "\ndodge = " + getDodge() +
        "\n}";
    }
}
