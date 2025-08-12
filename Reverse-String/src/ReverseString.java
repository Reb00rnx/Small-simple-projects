import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write string to reverse:");
        String word = scanner.nextLine();
        System.out.println();
        reverse(word);
    }

    public static void reverse(String toreverse){
        String reversed = "";
        int position = toreverse.length()-1;
        for(int i =0;i<toreverse.length();i++){
            reversed+= toreverse.charAt(position);
            position--;

        }
        System.out.println(reversed);

    }
}
