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
        super(name, 70, 10, "Guerreiro");
        this.strength = 10;
    }
    
    public float getStrength() {
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
        "\nrace = " + getRace() +
        "\nexp = " + getExp() +
        "\nexp gain = " + getExpGain() +
        "\nstrength = " + this.strength +
        "\ndodge = " + getDodge() +
        "\n}";
    }

    @Override
    public float attack() {
        return (int) this.strength;
    }

    @Override
    public void hurt(Monsters monster) {
        int dodge = (int) (getDodge() * 0.40);
        
        if(hitCalculation() < dodge) {
            System.out.println("O [" + monster.getName() + "] errou o ataque.");
        } else {
            int dmg = monster.monsterAttack(monster);
            setHpLoss(getHpLoss() - dmg);
        }
    }

    @Override
    public float rest() {
        return (float) (this.strength * 0.80);
    }

    @Override
    public void levelUp(int xp, int round) {
        int upLv = (getLevel() + 1);
        int dodgeUp = (int) (round / 2 + getDodge());
        int strengthUp = (int) (round / 2 + getStrength());
        int hpUp = (int) (round + 6 + getVitality());
        int xpUp = (int) (round / 2 + 10 + getExp());
        
        if(getExpGain() > getExp()) {
            int xpRemain  = (int) (getExpGain() - getExp());
            
            setExpGain(xpRemain);
            setExp(xpUp);
            setLevel(upLv);
            setDodge(dodgeUp);
            setStrength(strengthUp);
            setVitality(hpUp);
            setHpLoss(getVitality());
            
            System.out.println("***********************************************************");
            System.out.println("\t\tSeu [" + getRace() + "] avançou de level");
            System.out.println("***********************************************************");
            
        } else if(getExpGain() == getExp()) {
            setExpGain(0);
            setExp(xpUp);
            setLevel(upLv);
            setDodge(dodgeUp);
            setStrength(strengthUp);
            setVitality(hpUp);
            setHpLoss(getVitality());
            
            System.out.println("***********************************************************");
            System.out.println("\t\tSeu [" + getRace() + "] avançou de level");
            System.out.println("***********************************************************");
        }
    }  
    
}