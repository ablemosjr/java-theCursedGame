package main;

import java.util.Scanner;

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

public class Menu {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int play = 1;
            int record = 0;

            while(play == 1) {
                int score = Game.gameView();

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t Você chegou a [ " + score + " ] pontos!");

                if(score > record) {
                    record = score;
                }

                System.out.println("\t RECORDE ATUAL: " + record + " pontos");
                System.out.println("\n\t ~~ * * FIM DE JOGO! * * ~ ~");
                System.out.println("    Deseja continuar? [1] - SIM, [2] - NÃO");
                play = in.nextInt();
            }
        } catch(Exception e) {
            System.err.println("[The Cursed Game] está inativo.");
            
            System.out.println("Entrar em contato com equipe de Dev's!" + 
                "\nObrigado pela compreensão.");
        }
    }
}