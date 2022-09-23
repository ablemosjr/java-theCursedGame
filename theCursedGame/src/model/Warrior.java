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
    
    private double strength;

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
        "\nvitality = " + getVitality()+
        "\nlevel = " + getLevel()+
        "\nstrength = " + this.strength +
        "\ndodge = " + getDodge() +
        "\n}";
    }
}
