import java.util.Scanner;

public class RomToInt {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Input Roman number: ");
            String a = scanner.next();
            String rom = "IVXLCDM";
            int []tab = {1,5,10,50,100,500,1000};
            int value = 0;

            for (int i = 0; i < a.length(); i++) {
                int current = tab[rom.indexOf(a.charAt(i))];
                int next = 0;

                if (i < a.length() - 1) {
                    next = tab[rom.indexOf(a.charAt(i + 1))];
                }

                if (current < next) {
                    value -= current;
                } else {
                    value += current;
                }
            }

            System.out.println(value);

        }
    }


