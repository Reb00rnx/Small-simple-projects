package RockPaperScisors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        Enemy enemy = new Enemy();

        Boolean winner = true;

        while(winner){
            //  delete to see what computer choses
          //  System.out.println("enem: "+enemy.enemyChoice());
            player.play();
            enemy.play();
            //game logic----------------------------------------------------------------------
        if (player.playerChoice() == 1 && enemy.enemyChoice() == 1) {
            System.out.println("tie");
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 1 && enemy.enemyChoice() == 2) {
            enemy.addScore(1);
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 1 && enemy.enemyChoice() == 3) {
            player.addScore(1);
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 2 && enemy.enemyChoice() == 1) {
            player.addScore(1);
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 2 && enemy.enemyChoice() == 2) {
            System.out.println("tie");
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 2 && enemy.enemyChoice() == 3) {
            enemy.addScore(1);
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 3 && enemy.enemyChoice() == 1) {
            enemy.addScore(1);
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 3 && enemy.enemyChoice() == 2) {
            player.addScore(1);
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        if (player.playerChoice() == 3 && enemy.enemyChoice() == 3) {
            System.out.println("tie");
            System.out.println("player: " + player.retScore() + " enemy: " + enemy.retScore());
        }
        //Win condition----------------------------------------------------------------------------------
        if(player.retScore()==3){
            System.out.println("YOU WIN!\nPlayer: "+ player.retScore()+"\nComputer: "+enemy.retScore());
            winner=false;
        }if(enemy.retScore()==3) {
            System.out.println("YOU LOSE!\nPlayer: "+ player.retScore()+"\nComputer: "+enemy.retScore());
            winner=false;
        }
    }
    }
}
