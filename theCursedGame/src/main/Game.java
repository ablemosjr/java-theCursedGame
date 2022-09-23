package main;

import model.Archer;
import model.Mage;
import model.Warrior;

/** AS014TSN1 - Programação Orientada à Objetos
 * AC1 (Lista) - Personagens
 * Uma desenvolvedora da games está trabalhando em um jogo de RPG. 
 * Nesse jogo há vários personagens, por exemplo, o mago tem um nome, vida, nível de experiência, poder de magia e poder de cura. 
 * Já o guerreiro tem nome, vida, nível de experiência e força física. O arqueiro tem nome, nível de experiência e vida e velocidade.
 *
 * 
 * Todas as classes de personagens devem ter: 
 * 
 * (1.0) Um método construtor que inicia seus atributos.
 * (1.0) O método ataque(), de acordo com suas armas e habilidades. 
 * No game, quando um personagem ataca, o jogador vê uma narrativa do ataque. Por exemplo:
 *      "O mago Merlin atacou o inimigo com sua magia."
 *      "O guerreiro Arthur atacou o inimigo com sua espada."
 * (1.0) O método sofrerAtaque(float dano) que retira uma determinada porção de vida.
 * (1.0) O método restaurarVida(float ganho) que restaura uma determinada porção de vida.
 * (1.0) O método morrer() que é executado toda vez que a vida diminui a zero, mostrando uma mensagem indicando a morte.
 * (1.0) A cada ataque o personagem incrementa seu nível de experiência. 
 * (1.0) O método toString() que imprime os dados do personagem.
 * (1.0) Classes e heranças bem feitas.
 * (1.0) Encapsulamento bem feito.
 * (0.5) Crie instancias dessas classes e altere seus dados e teste seus métodos.
 * (0.5) Validações quando necessárias.
 * (Opcional) Faça um personagem atacar outro.
 * 
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 * @since 22/09/2022
 */

public class Game {
    public static void main(String[] args) {
        Warrior wr = new Warrior("Fred");
        Mage mg = new Mage("Joy");
        Archer ar = new Archer("Edu");
        
        System.out.println(wr.toString());      
        System.out.println("-------------");
        System.out.println(mg.toString());
        System.out.println("-------------");
        System.out.println(ar.toString());
    }
}
