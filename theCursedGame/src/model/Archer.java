package model;

/** Classe de construção de personagem: Arqueiro
 * 
 * Atributos:
 * - Poder de magia
 * - Poder de cura
 * 
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Archer extends Characters {
    
    private double agility;

    public Archer(String name) {
        super(name, 30, 20);
        this.agility = 30;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "Archer {" + 
        "\nname = " + getName() +
        "\nvitality = " + getVitality()+
        "\nlevel = " + getLevel()+
        "\nagility = " + this.agility +
        "\ndodge = " + getDodge() +
        "\n}";
}
}
