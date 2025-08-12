

import java.util.Scanner;
public class Cinema {

    private int numberOfSeats;
    private int numberOfRows;
    private int row;
    private int seat;
    private String[][] sitsTab;
    private  int customerChoice;

    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }

    private int inc;

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    private  int income;

    public int getPurchedTickets() {
        return purchedTickets;
    }


    public void setPurchedTickets(int purchedTickets) {
        this.purchedTickets = purchedTickets;
    }

    private  int purchedTickets;
    Cinema(){
    }

    public void setCustomerChoice(int customerChoice) {
        this.customerChoice = customerChoice;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public int getNumberOfRows() {
        return numberOfRows;
    }
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    //---------------------------------------------
    void setTab(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        setNumberOfRows(scanner.nextInt());
        System.out.println("Enter the number of seats in each row: ");
        setNumberOfSeats(scanner.nextInt());
        sitsTab = new String[getNumberOfRows()][getNumberOfSeats()];
        for (int i = 1; i <= getNumberOfRows(); i++) {

            for (int j = 1; j <= getNumberOfSeats(); j++) {
                sitsTab[i-1][j-1] = "S" ;
            }
            System.out.println();
        }
        int sos = getNumberOfRows() * getNumberOfSeats();
        int fullPrice = 0;
        if(sos<=60){
            fullPrice = sos*10;
        }else {
            int half = ((int)(getNumberOfRows()/2))*getNumberOfSeats();
            fullPrice = (half*10) + (sos-half)*8;
        }


        setIncome(fullPrice);
    }
    void showTheSeats() {
        System.out.print("Cinema:\n  ");
        for (int i = 1; i <= getNumberOfSeats(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= getNumberOfRows(); i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= getNumberOfSeats(); j++) {
                System.out.print(sitsTab[i-1][j-1]+" ");
            }
            System.out.println();
        }
    }

    void buyTicket(){

        Scanner scanner = new Scanner(System.in);
        boolean freeSeat =true;
        do {
            int price = 0 ;
            System.out.println("Enter a row number: ");
            setRow(scanner.nextInt());
            System.out.println("Enter a seat number in that row: ");
            setSeat(scanner.nextInt());
            if(getRow()>getNumberOfRows()||getSeat()>getNumberOfSeats()){
                System.out.println("Wrong input!");
                continue;
            }
            int sos = getNumberOfRows() * getNumberOfSeats();
            int frontPrice = 10;
            int backPrice = 8;
            int half = (int) (getNumberOfRows() / 2);




            if (sos <= 60) {
                price = (int) frontPrice;


            } else if (sos > 60 && getRow() <= half) {
                price = frontPrice;

            } else if (sos > 60 && getRow() > half) {
                price = backPrice;

            }
            if (sitsTab[getRow() - 1][getSeat() - 1].equals("S")) {
                sitsTab[getRow() - 1][getSeat() - 1] = "B";
                System.out.println("Ticket price: $" + price);
                setInc(getInc()+price);
                setPurchedTickets(getPurchedTickets()+1);
                freeSeat = false;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        }while(freeSeat);
    }
    void statistics(){
        float percent = ((float)getPurchedTickets() / (getNumberOfRows() * getNumberOfSeats())) * 100;

        System.out.println("Number of purchased tickets: "+getPurchedTickets());
        System.out.printf("Percentage: %.2f%%\n", percent);
        System.out.println("Current income: $" + getInc());
        System.out.println("Total income: $"+ getIncome());
    }
    void logic(){
        try {
            if (customerChoice == 1) {
                showTheSeats();
            }
            if (customerChoice == 2) {
                buyTicket();
            }
            if (customerChoice == 3) {
                statistics();
            }


        } catch (IndexOutOfBoundsException e) {
        }
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        setTab();

        do {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n"+
                    "0. Exit");
            setCustomerChoice(scanner.nextInt());
            logic();
        } while (customerChoice!=0);
    }



    public static void main(String[] args) {
        // Write your code here
        Cinema cinema = new Cinema();
        cinema.menu();


    }
}