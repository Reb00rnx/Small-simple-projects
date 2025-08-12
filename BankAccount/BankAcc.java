
import java.util.InputMismatchException;
import java.util.Scanner;

class User {
    private int password;
    private int id;
    private int money;

    private boolean status = true;
    User(int id, int password,int money) {
        this.id = id;
        this.password = password;
        this.money = money;
    }
    User() {
    }
    void menu(){
        while(status) {
            System.out.println("Select action");
            System.out.println("1. Deposit \n" + "2. Pay out\n" + "3. Check balance\n" + "4. Log out");
            Scanner scanner = new Scanner(System.in);
            try {
                int in = scanner.nextInt();

                switch (in) {

                    case 1:

                        System.out.println("enter the amount ");

                        try {
                            int x = scanner.nextInt();
                            deposit(x);
                            System.out.println("Deposited: "+ x);
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input transaction cancelled");
                        }
                        break;
                    case 2:
                        System.out.println("enter the amount ");

                        try {
                            int y = scanner.nextInt();
                            widraw(y);
                            System.out.println("Widrowed: " + y);
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input transaction cancelled");
                        }
                        break;
                    case 3:
                        System.out.println("Balance: " + getMoney() + " euro");
                        break;
                    case 4:
                        status = false;
                        break;

                }
            }catch(InputMismatchException e){
                System.out.println("Wrong input");
            }

        }
    }
    void deposit(int ammount){
        this.money+=ammount;
    }
    void widraw(int ammount){
        if(money>0&&money-ammount>0){
            this.money-=ammount;
        }
    }
    int getMoney(){
        return this.money;
    }
    void logIn() {
        int chance = 3;
        boolean entry = false;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Logging in to account\nEnter password ");
            System.out.println("(You have  " + chance + " chances)");

            int login = scanner.nextInt();
            if (chance == 0) {
                break;

            }
            if (login == this.password) {
                System.out.println("Logged");
                entry = true;
                break;
            }
            System.out.println("Wrong password");
            chance--;

        }
        if (entry == false) {
            System.out.println("Logging denied");
            return;
        }

        menu();
    }
    // ----------------------

}

public class BankAcc {
    public static void main(String[] args) {
        User guest = new User(12345, 1234,100);

        guest.logIn();

    }
}