package model;

import java.util.Random;

/** Classe de construção de monstros 
 *
 * @since 23/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Monsters {
    
    private String name;
    private float vitality;
    private float hpLoss;
    private float strength;
    private float exp;
    
    public Monsters() { 
        this.name = "";
        this.vitality = 0;
        this.hpLoss = 0;
        this.strength = 0;
        this.exp = 0;
    }

    public void createMonsters(int round) {
        Random randomMonster = new Random();
        int monster = randomMonster.nextInt(2) + 1;
        
        switch(monster) {
            case 1:
                setName("Goblin");
                setVitality(30);
                setHpLoss(getVitality());
                setStrength(4);
                setExp(8);
                break;
            case 2:
                setName("Orc");
                setVitality(60);
                setHpLoss(getVitality());
                setStrength(5);
                setExp(15);
                break;
        }
        
        if(round != 1) {
            int hpMonsterUp = (int) getVitality() + (round * 2);
            int xpMonsterUp = (int) getExp() + (round * 2);
            int strMonsterUp = (int) (getStrength() + round / 2);
            
            setVitality(hpMonsterUp);
            setHpLoss(hpMonsterUp);
            setExp(xpMonsterUp);
            setStrength(strMonsterUp);
        }
    }
    
    public int monsterAttack(Monsters monster) {
        Random randomAttack = new Random();
        int attack = randomAttack.nextInt(2) + 1;
        int dmgCritic = (int) (monster.getStrength() * 2);

        if(monster.getName().equals("Goblin")) {
            switch (attack) {
                case 1:
                    System.out.println("[Goblin] atacou com porrete, causou [" + (int) monster.getStrength() + "] de dano");
                    return (int) monster.getStrength();
                case 2:
                    System.out.println("[Goblin] pulou e mordeu seu pescoço, causou [" + dmgCritic + "] de dano");
                    return (int) dmgCritic;
                default:
                    throw new AssertionError();
            }
        } else if(monster.getName().equals("Orc")) {
            switch (attack) {
                case 1:
                    System.out.println("[Orc] acertou um gancho de direita, causando [" + (int) monster.getStrength() + "] de dano");
                    return (int) monster.getStrength();
                case 2:
                    System.out.println("[Orc] acertou um chute nas costelas, causou [" + dmgCritic + "] de dano");
                    return (int) dmgCritic;
                default:
                    throw new AssertionError();
            }
        }
        return 0;
    }
    
    public void monsterUp() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVitality() {
        return vitality;
    }

    public void setVitality(float vitality) {
        this.vitality = vitality;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public float getHpLoss() {
        return hpLoss;
    }

    public void setHpLoss(float hpLoss) {
        this.hpLoss = hpLoss;
    }

    @Override
    public String toString() {
        return "Monsters{" + 
                "\nname = " + this.name + 
                "\nvitality = " + this.vitality + 
                "\nstrength = " + this.strength + 
                "\nexp = " + this.exp + 
                "\n}";
    }
}