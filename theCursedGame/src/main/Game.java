package main;

import java.util.Scanner;
import model.Archer;
import model.Mage;
import model.Monsters;
import model.Warrior;

/** Métodos para construção do jogo
 *
 * @since 24/09/2022
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 */

public class Game {
    
    private static int choiceView() { 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===========================================================");
        System.out.println("|                     The Cursed Game                     |");
        System.out.println("===========================================================\n");
        
        System.out.println("Escolha seu personagem:\n");
        System.out.println("[1] - Guerreiro [70 HP / 10 STR / 10 DODGE]");
        System.out.println("[2] - Mago      [40 HP / 30 WIS / 5 DODGE / 10 HEALING]");
        System.out.println("[3] - Arqueiro  [45 HP / 30 AGI / 20 DODGE]");
        System.out.println("Opção: ");
        
        return sc.nextInt();
    }
    
    protected static int gameView() {
        Scanner sc = new Scanner(System.in);

        int choice = choiceView();
        
        System.out.println("\nAgora, escolha o nome do seu personagem:");
        String name = sc.next();

        Warrior warrior = new Warrior(name);
        Mage mage = new Mage(name);
        Archer archer = new Archer(name);

        int score = battle(warrior, mage, archer, choice);
        
        return score;
    }
    
    private static int battle(Warrior warrior, Mage mage, Archer archer, int choice) {
        int round = 1;
        
        while(hpDecision(warrior, mage, archer, choice)) {
            
            Monsters monster = new Monsters();
            monster.createMonsters(round);

            while(hpDecision(warrior, mage, archer, choice) && monster.getHpLoss() > 0) {

                monsterStats(monster, round);
                playerStats(warrior, mage, archer, choice);
                
                int chosenSkill = playerSkill(choice);
                
                System.out.println("-----------------------------------------------------------");
                switch (choice) {
                    case 1:
                        switch (chosenSkill) {
                            case 1:
                                System.out.println("" + warrior.getName() + " acertou o " + monster.getName() + " com [Ataque básico], causando [" + (int) warrior.attack() + "] dano");
                                
                                int hpPresent1c1 = (int) (monster.getHpLoss() - warrior.attack());
                                monster.setHpLoss(hpPresent1c1);
                                break;
                            case 2:
                                int dmgCritic = (int) (warrior.attack() * 1.5);
                                System.out.println("" + warrior.getName() + " acertou o " + monster.getName() + " com [Golpe Fulminante], causando [" + dmgCritic + "] dano");
                                
                                int hpPresent1c2 = (int) (monster.getHpLoss() - dmgCritic);
                                monster.setHpLoss(hpPresent1c2);
                                break;
                            case 3:
                                int heal = (int) warrior.rest();
                                System.out.println("" + warrior.getName() + " esta descansando e curou [" + heal + "] de HP");
                                
                                int heal1c1 = (int) (warrior.getHpLoss() + heal);
                                warrior.setHpLoss(heal1c1);
                                
                                if(warrior.getHpLoss() >= warrior.getVitality()) {
                                    warrior.setHpLoss(warrior.getVitality());
                                }
                                break;
                            default:
                                throw new AssertionError();
                        }   break;
                    case 2:
                        switch (chosenSkill) {
                            case 1:
                                System.out.println("" + mage.getName() + " acertou o " + monster.getName() + "com [Ataque básico mágico], causando [" + (int) mage.attack() + "] dano");
                                
                                int hpPresent2c1 = (int) (monster.getHpLoss() - mage.attack());
                                monster.setHpLoss(hpPresent2c1);
                                break;
                            case 2:
                                int dmgCritic = (int) (mage.attack() * 1.5);
                                System.out.println("" + mage.getName() + " acertou o " + monster.getName() + " com [Bola de Fogo], causando [" + dmgCritic + "] dano");
                                
                                int hpPresent2c2 = (int) (monster.getHpLoss() - dmgCritic);
                                monster.setHpLoss(hpPresent2c2);
                                break;
                            case 3:
                                int heal = (int) (mage.rest() * 0.5);
                                System.out.println("" + mage.getName() + " esta descansando e curou [" + heal + "] de HP");
                                
                                int recover = (int) (mage.getHpLoss() + heal);
                                mage.setHpLoss(recover);
                                
                                if(mage.getHpLoss() >= mage.getVitality()) {
                                    mage.setHpLoss(mage.getVitality());
                                }
                                break;
                            case 4:
                                int healSkill =  (int) (mage.rest() * 1.5);
                                System.out.println("" + mage.getName() + ", o [" + mage.getRace()+ "] esta usando [Cura], recuperou [" + healSkill + "] de HP");
                                
                                int recoverSkill = (int) (mage.getHpLoss() + healSkill);
                                mage.setHpLoss(recoverSkill);
                                
                                if(mage.getHpLoss() >= mage.getVitality()) {
                                    mage.setHpLoss(mage.getVitality());
                                }
                                break;
                            default:
                                throw new AssertionError();
                        }   break;
                    case 3:
                        switch (chosenSkill) {
                            case 1:
                                System.out.println("" + archer.getName() + " acertou o " + monster.getName() + " com uma [Flechada], causando [" + (int) archer.attack() + "] dano");
                                
                                int hpPresent3c1 = (int) (monster.getHpLoss() - archer.attack());
                                monster.setHpLoss(hpPresent3c1);
                                break;
                            case 2:
                                int dmgCritic = (int) (archer.attack() * 1.5);
                                System.out.println("" + archer.getName() + " acertou o " + monster.getName() + " com uma [Tiro Preciso], causando [" + dmgCritic + "] dano");
                                
                                int hpPresent3c2 = (int) (monster.getHpLoss() - dmgCritic);
                                monster.setHpLoss(hpPresent3c2);
                                break;
                            case 3:
                                int heal = (int) archer.rest();
                                System.out.println("" + archer.getName() + " esta descansando e curou [" + heal + "] de HP");
                                
                                int recover = (int) (archer.getHpLoss() + heal);
                                archer.setHpLoss(recover);
                                
                                if(archer.getHpLoss() >= archer.getVitality()) {
                                    archer.setHpLoss(archer.getVitality());
                                }
                                break;
                            default:
                                throw new AssertionError();
                        }   break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                
            if(monster.getHpLoss() > 0) {
                int dmg = monster.monsterAttack(monster);
                switch (choice) {
                    case 1:
                        warrior.setHpLoss(warrior.getHpLoss() - warrior.hurt(dmg, monster.getName()));
                        break;
                    case 2:
                        mage.setHpLoss(mage.getHpLoss() - (int) mage.hurt(dmg, monster.getName()));
                        break;
                    case 3:
                        archer.setHpLoss(archer.getHpLoss() - (int) archer.hurt(dmg, monster.getName()));
                        break;
                    default:
                        throw new AssertionError();
                    }
                } else {
                    switch (choice) {
                        case 1:
                            int warriorXp = (int) (warrior.getExpGain() + monster.getExp());
                            warrior.setExpGain(warriorXp);
                            break;
                        case 2:
                            int mageXp = (int) (mage.getExpGain() + monster.getExp());
                            mage.setExpGain(mageXp);
                            break;
                        case 3:
                            int archerXp = (int) (archer.getExpGain() + monster.getExp());
                            archer.setExpGain(archerXp);
                            break;
                        default:
                            throw new AssertionError();
                    }

                    System.out.println("[" + monster.getName() + "] derrotado!");

                    playerUp(warrior, mage, archer, choice, round);
                }
            
                System.out.println("-----------------------------------------------------------");
            }
            round++;
        }
        return round;
    }
    
    private static boolean hpDecision(Warrior warrior, Mage mage, Archer archer, int choice) {
        switch (choice) {
            case 1:
                return warrior.perish(warrior.getHpLoss());
            case 2:
                return mage.perish(mage.getHpLoss());
            case 3:
                return archer.perish(archer.getHpLoss());
            default:
                throw new AssertionError();
        }
    }
    
    private static void playerStats(Warrior warrior, Mage mage, Archer archer, int choice) {
        switch (choice) {
            case 1:
                System.out.println("========================JOGADOR============================");
                System.out.println("Nome: " + warrior.getName() + "\t\t Raça: " + warrior.getRace() +
                        "\nHP: " + warrior.getHpLoss() + " / " + warrior.getVitality() +
                        "\nLevel: " + warrior.getLevel() + "\t XP: " + warrior.getExpGain() + " / "+ warrior.getExp() +
                        "\nEsquiva: " + warrior.getDodge() +
                        "\nFor: " + warrior.getStrength());
                break;
            case 2:
                System.out.println("========================JOGADOR============================");
                System.out.println("Nome: " + mage.getName() + "\t\t Raça: " + mage.getRace() +
                        "\nHP: " + mage.getHpLoss() + " / " + mage.getVitality() +
                        "\nLevel: " + mage.getLevel() + "\t XP: " + mage.getExpGain() + " / "+ mage.getExp() +
                        "\nEsquiva: " + mage.getDodge() +
                        "\nWis: " + mage.getWisdom() + 
                        "\nInt: " + mage.getInteligence());
                break;
            case 3:
                System.out.println("========================JOGADOR============================");
                System.out.println("Nome: " + archer.getName() + "\t\t Raça: " + archer.getRace() +
                        "\nHP: " + archer.getHpLoss() + " / " + archer.getVitality() +
                        "\nLevel: " + archer.getLevel() + "\t XP: " + archer.getExpGain() + " / "+ archer.getExp() +
                        "\nEsquiva: " + archer.getDodge() +
                        "\nFor: " + archer.getAgility());
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private static void monsterStats(Monsters monster, int round) {
        System.out.println("========================INIMIGO============================");
        System.out.println("\t\t\t Round: " + round);
        System.out.println("Monstro: " + monster.getName() +
                "\nHP: " + monster.getHpLoss() + " / " + monster.getVitality() + 
                "\nXP Obtida: " + monster.getExp());
    }
    
    private static int playerSkill(int choice) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========================ATAQUE=============================");
        
        switch (choice) {
            case 1:
                System.out.println("[1] - Ataque básico");
                System.out.println("[2] - Golpe fulminante");
                System.out.println("[3] - Descansar");
                System.out.println("Opção: ");
                return sc.nextInt();
            case 2:
                System.out.println("[1] - Ataque básico mágico");
                System.out.println("[2] - Bola de Fogo");
                System.out.println("[3] - Descansar");
                System.out.println("[4] - Cura");
                System.out.println("Opção: ");
                return sc.nextInt();
            case 3:
                System.out.println("[1] - Flechada");
                System.out.println("[2] - Tiro Preciso");
                System.out.println("[3] - Descansar");
                System.out.println("Opção: ");
                return sc.nextInt();
            default:
                System.out.println("Algum erro ocorreu aqui!!");
                break;
        }
        return 0;
    }
 
    private static void playerUp(Warrior warrior, Mage mage, Archer archer, int choice, int round) {
        System.out.println("***********************************************************");

        switch (choice) {
            case 1:
                warrior.levelUp((int) warrior.getExpGain(), round);
                System.out.println("\t\tSeu [" + warrior.getRace() + "] avançou de level");
                break;
            case 2:
                mage.levelUp((int) mage.getExpGain(), round);
                System.out.println("\t\tSeu [" + mage.getRace() + "] avançou de level");
                break;
            case 3:
                archer.levelUp((int) archer.getExpGain(), round);
                System.out.println("\t\tSeu [" + archer.getRace() + "] avançou de level");
                break;
            default:
                throw new AssertionError();
        }
        System.out.println("***********************************************************");
    }
    
}