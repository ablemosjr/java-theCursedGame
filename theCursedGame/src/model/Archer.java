package model;

/** Classe de construção de personagem: Arqueiro
 * 
 * Atributos:
 * - Velocidade
 * 
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Archer extends Characters {
    
    private float agility;

    public Archer(String name) {
        super(name, 30, 20, "Arqueiro");
        this.agility = 30;
    }

    public float getAgility() {
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
        "\nrace = " + getRace() +
        "\nexp = " + getExp() +
        "\nexp gain = " + getExpGain() +
        "\nagility = " + this.agility +
        "\ndodge = " + getDodge() +
        "\n}";
}

    @Override
    public float attack() {
        return (int) (this.agility * 0.60);
    }

    @Override
    public float hurt(int dmg) {
        int dodge = (int) ((this.agility * 0.40) + (getDodge() + 0.10));
        
        if(hitCalculation() < dodge) {
            System.out.println("Errou.");
        }
        
        float def = (float) ((this.agility * 0.30) + (getDodge() * 0.10));
        float lifeCalculation = dmg - def;
        
        return lifeCalculation;
    }

    @Override
    public float rest() {
        return (float) ((this.agility * 0.2) + (getDodge() * 0.30));
    }
}