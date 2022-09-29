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
        super(name, 40, 5, "Mago");
        this.wisdom = 25;
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
        return (int) ((this.wisdom * 0.50) + (this.inteligence * 0.20));
    }

    @Override
    public void hurt(Monsters monster) {
        int dodge = (int) (getDodge() * 0.30);
        
        if(hitCalculation() < dodge) {
            System.out.println("O [" + monster.getName() + "] errou o ataque.");
        } else {
            int dmg = monster.monsterAttack(monster);
            setHpLoss(getHpLoss() - dmg);
        }
    }

    @Override
    public float rest() {
        return (float) (this.inteligence + (getDodge() * 0.10));
    }

    @Override
    public void levelUp(int xp, int round) {
        int upLv = (getLevel() + 1);
        int dodgeUp = (int) (round / 2 + getDodge());
        int wisdomUp = (int) (round / 2 + 2 + getWisdom());
        int inteligenceUp = (int) (round / 2 + 1 + getInteligence());
        int hpUp = (int) (round + 3 + getVitality());
        int xpUp = (int) (round / 2 + 10 + getExp());
        
        if(xp > getExp()) {
            int xpRemain  = (int) (getExpGain() - getExp());
            
            setExpGain(xpRemain);
            setExp(xpUp);
            setLevel(upLv);
            setDodge(dodgeUp);
            setWisdom(wisdomUp);
            setInteligence(inteligenceUp);
            setVitality(hpUp);
            setHpLoss(getVitality());
            
            System.out.println("***********************************************************");
            System.out.println("\t\tSeu [" + getRace() + "] avançou de level");
            System.out.println("***********************************************************");
            
        } else if(xp == getExp()) {
            setExpGain(0);
            setExp(xpUp);
            setLevel(upLv);
            setDodge(dodgeUp);
            setWisdom(wisdomUp);
            setInteligence(inteligenceUp);
            setVitality(hpUp);
            setHpLoss(getVitality());
            
            System.out.println("***********************************************************");
            System.out.println("\t\tSeu [" + getRace() + "] avançou de level");
            System.out.println("***********************************************************");
        }
    }
    
}