package RockPaperScisors;

import java.util.Scanner;

public class Player extends Game {
    int score = 0;
    int choice;

    Player(){
        this.score = score;
        this.choice = choice;
    }
    //Player choice
    void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select:\n1:Rock\n2:Paper\n3:Scisors\n");
        int a = scanner.nextInt();
        this.choice = a;
    }
    //returning our choice
    int playerChoice(){
        return choice;
    }
    //adding score if round is won
    void addScore(int add){
        this.score = score+add;
    }
    //returning score
    int retScore(){
        return this.score;
    }
}
