import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    // class level references and variables
    private static Scanner scan = new Scanner(System.in);
    public static DecimalFormat fmt = new DecimalFormat("#,##0.00");
    private static ArrayList<Stock> stockList = new ArrayList<Stock>();

    public static void main(String[] args) {
        int choice;
        final int EXIT_VALUE = 5;

        do {
            //show menu
            System.out.println("Menu\n");
            System.out.println("1) Add Stock");
            System.out.println("2) Remove Stock");
            System.out.println("3) Display Single Stock");
            System.out.println("4) Show Stock Portfolio");
            System.out.println("5) Exit");

            //get users choice
            System.out.println("\nEnter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    scan.nextLine();
                    addStock();
                    scan.nextLine();
                    break;
                case 2:
                    scan.nextLine();
                    removeStock();
                    scan.nextLine();
                    break;
                case 3:
                    scan.nextLine();
                    displaySingleStock();
                    scan.nextLine();
                    break;
                case 4:
                    scan.nextLine();
                    showStockPortfolio();
                    scan.nextLine();
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:        //Normally for error checking
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != EXIT_VALUE);
    }
    public static void addStock() {
        System.out.println("Enter stock name:");
        String name = scan.nextLine();
        System.out.println("Enter stock price:");
        double price = scan.nextDouble();
        System.out.println("Enter stock quantity:");
        int quantity = scan.nextInt();

        Stock stock = new Stock(name,quantity,price,price);

        stockList.add(stock);

        showStockPortfolio();
    }

    public static void removeStock() {
        System.out.println("removeStock() called");
    }

    public static void displaySingleStock() {
        System.out.println("displaySingleStock() called");
    }

    public static void showStockPortfolio() {
        System.out.println("showStockPortfolio() called");
    }
}