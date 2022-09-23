package model;

/** Classe de construção dos personagens
 * 
 * Atributos:
 * - Nome
 * - Vida
 * - Nível de experiência
 * 
 * @since 22/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Characters {
    
    private String name;
    private double vitality;
    private double level;
    private double dodge;

    public Characters() {
    }

    public Characters(String name, double vitality, double dodge) {
        this.name = name;
        this.vitality = vitality;
        this.level = 1;
        this.dodge = dodge;
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

    @Override
    public String toString() {
        return "Personagens {" + 
                "\nname= " + name + 
                "\nvitality= " + vitality + 
                "\nlevel= " + level + 
                "\n}";
    }
}
