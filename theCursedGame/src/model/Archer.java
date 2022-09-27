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
        super(name, 45, 20, "Arqueiro");
        this.agility = 20;
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
        return (int) (this.agility * 0.70);
    }

    @Override
    public void hurt(Monsters monster) {
        int dodge = (int) ((this.agility * 0.30) + (getDodge() + 0.10));
        
        if(hitCalculation() < dodge) {
            System.out.println("O [" + monster.getName() + "] errou o ataque.");
        } else {
            int dmg = monster.monsterAttack(monster);
            setHpLoss(getHpLoss() - dmg);
        }
    }

    @Override
    public float rest() {
        return (float) ((this.agility * 0.2) + (getDodge() * 0.30));
    }

    @Override
    public void levelUp(int xp, int round) {
        int upLv = (getLevel() + 1);
        int dodgeUp = (int) (round / 2 + 1 + getDodge());
        int agilityUp = (int) (round / 2 + 2 + getAgility());
        int hpUp = (int) (round + 4 + getVitality());
        int xpUp = (int) (round / 2 + 10 + getExp());
        
        if(xp > getExp()) {
            int xpRemain  = (int) (getExpGain() - getExp());
            
            setExpGain(xpRemain);
            setExp(xpUp);
            setLevel(upLv);
            setDodge(dodgeUp);
            setAgility(agilityUp);
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
            setAgility(agilityUp);
            setVitality(hpUp);
            setHpLoss(getVitality());
            
            System.out.println("***********************************************************");
            System.out.println("\t\tSeu [" + getRace() + "] avançou de level");
            System.out.println("***********************************************************");
        }
    }
    
}