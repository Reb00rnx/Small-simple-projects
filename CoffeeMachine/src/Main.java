import java.util.Scanner;

class Machine {
    int water = 400;
    int milk = 540;
    int coffeeBeans = 120;
    int cupsleft = 9;
    private int money = 550;

    boolean isClean = true;
    int coffeeProduced = 0;

    Machine(int water, int milk, int coffeeBeans, int cupsleft, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cupsleft = cupsleft;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void buy(String buyChoice) {
        if (!isClean) {
            System.out.println("I need cleaning!");
            return;
        }

        int[] espresso = {250, 0, 16, 1, 4};
        int[] latte = {350, 75, 20, 1, 7};
        int[] cappuccino = {200, 100, 12, 1, 6};
        int[] selectedCoffee = null;

        switch (buyChoice) {
            case "1":
                selectedCoffee = espresso;
                break;
            case "2":
                selectedCoffee = latte;
                break;
            case "3":
                selectedCoffee = cappuccino;
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid selection!");
                return;
        }

        if (selectedCoffee != null) {
            boolean hasEnoughWater = this.water >= selectedCoffee[0];
            boolean hasEnoughMilk = this.milk >= selectedCoffee[1];
            boolean hasEnoughCoffeeBeans = this.coffeeBeans >= selectedCoffee[2];
            boolean hasEnoughCups = this.cupsleft >= selectedCoffee[3];

            if (hasEnoughWater && hasEnoughMilk && hasEnoughCoffeeBeans && hasEnoughCups) {
                this.water -= selectedCoffee[0];
                this.milk -= selectedCoffee[1];
                this.coffeeBeans -= selectedCoffee[2];
                this.cupsleft -= selectedCoffee[3];
                this.money += selectedCoffee[4];
                this.coffeeProduced += 1;
                System.out.println("I have enough resources, making you a coffee!");

                if (coffeeProduced == 10) {
                    isClean = false;
                }
            } else {
                System.out.print("Sorry, not enough ");
                boolean firstMissing = true;

                if (!hasEnoughWater) {
                    System.out.print("water");
                    firstMissing = false;
                }
                if (!hasEnoughMilk) {
                    System.out.print((firstMissing ? "" : ", ") + "milk");
                    firstMissing = false;
                }
                if (!hasEnoughCoffeeBeans) {
                    System.out.print((firstMissing ? "" : ", ") + "coffee beans");
                    firstMissing = false;
                }
                if (!hasEnoughCups) {
                    System.out.print((firstMissing ? "" : ", ") + "cups");
                }

                System.out.println("!");
            }
        }
    }

    public void fill(int scWater, int scMilk, int scCoffee, int scCups) {
        water += scWater;
        milk += scMilk;
        coffeeBeans += scCoffee;
        cupsleft += scCups;
    }

    public void take() {
        System.out.println("I gave you $" + getMoney() + "\n");
        setMoney(0);
    }

    public void remaining() {
        System.out.println("The coffee machine has:\n" +
                this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.coffeeBeans + " g of coffee beans\n" +
                this.cupsleft + " disposable cups\n" +
                "$" + getMoney() + " of money\n");
    }

    public void clean() {
        System.out.println("I have been cleaned!");
        isClean = true;
        coffeeProduced = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine(400, 540, 120, 9, 550);
        boolean flag = true;

        while (flag) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String input = scanner.nextLine();

            switch (input) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String buyChoice = scanner.nextLine();
                    machine.buy(buyChoice);
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int scWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int scMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int scCoffee = scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    int scCups = scanner.nextInt();
                    scanner.nextLine();
                    machine.fill(scWater, scMilk, scCoffee, scCups);
                    break;
                case "take":
                    machine.take();
                    break;
                case "clean":
                    machine.clean();
                    break;
                case "remaining":
                    machine.remaining();
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }


            while (!machine.isClean()) {
                System.out.println("I need cleaning!");
                System.out.println("Write action (clean, exit):");
                String action = scanner.nextLine();
                if (action.equals("clean")) {
                    machine.clean();
                } else if (action.equals("exit")) {
                    flag = false;
                    break;
                } else {
                    System.out.println("Invalid command!");
                }
            }
        }
        scanner.close();
    }
}
