package RockPaperScisors;

import java.util.Random;

public class Enemy extends Game {
    int score = 0;
    int choice;
    int randd;

    Enemy(){
        this.score = score;
        this.randd = randd;
    }
    //randomizing enemy choice
    void play(){
        Random random = new Random();
       randd = random.nextInt(3)+1;
    }
    //returning random choice
    int enemyChoice() {
        return randd;
    }
    //adding score if round is won
    void addScore(int add){
        this.score = score +add;
    }
    //returning score
    int retScore(){
        return this.score;
    }

}
