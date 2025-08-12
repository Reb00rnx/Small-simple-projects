import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        int[] tab = new int[100];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i ;
        }
        Random rn = new Random();
        int count = 1;
        boolean ans = true;
        int min = tab[0];
        int max = tab.length;
        int answer = rn.nextInt(100)+1 ;

//to see the number
//        System.out.println(answer);


        System.out.println("Guess the number between 1-100");
        Scanner scanner = new Scanner(System.in);
        try {
            while (ans) {
                int x = scanner.nextInt();
                if(x>max){
                    System.out.println("your number is out of range!");
                    continue;
                }
                if(x<min){
                    System.out.println("your number is out of range!");
                    continue;
                }
                if (x == answer) {
                    System.out.println("You win!");
                    System.out.println("Score: " + count);

                }
                if (answer > x) {
                    min = x;
                    System.out.println("number is between " + min + "-" + max);
                }
                if (answer < x) {
                    max = x;
                    System.out.println("number is between " + min + "-" + max);

                }
                count++;
            }
        } catch(InputMismatchException e){
            System.out.println("Wrong input!");

        }
//
    }
}
