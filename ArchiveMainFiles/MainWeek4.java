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
        int choice = 0;
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
            System.out.print("\nEnter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    addStock();
                    pause();
                    break;
                case 2:
                    removeStock();
                    pause();
                    break;
                case 3:
                    displaySingleStock();
                    pause();;
                    break;
                case 4:

                    showStockPortfolio();
                    pause();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:        //Normally for error checking
                    System.out.println("\nError. Please select from the menu.");
                    pause();
                    break;
            }

        } while (choice != EXIT_VALUE);
    }
    public static void addStock() {
        System.out.print("Enter stock name: ");
        String name = scan.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter purchase price: ");
        double pPrice = scan.nextDouble();
        scan.nextLine();
        System.out.print("Enter current price: ");
        double cPrice = scan.nextDouble();
        scan.nextLine();

        Stock stock = new Stock(name,quantity,pPrice,cPrice);

        stockList.add(stock);

        showStockPortfolio();

    }

    public static void removeStock() {
        System.out.println("Enter stock name to remove: ");
        String name = scan.nextLine();
        boolean found = false;
        for (Stock stock : stockList) {
            if (stock.getCompanyName().equalsIgnoreCase(name)) {
                stockList.remove(stock);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nStock not found");
        }

        showStockPortfolio();

    }

    public static void displaySingleStock() {
        System.out.println("Enter stock name: ");
        String name = scan.nextLine();
        boolean found = false;
        for (Stock stock : stockList) {
            if (stock.getCompanyName().equalsIgnoreCase(name)) {
                System.out.println("Stock Name: " + stock.getCompanyName());
                System.out.println("Number of Shares: " + stock.getNumberOfShares());
                System.out.println("Purchase Price: " + fmt.format(stock.getPurchasePrice()));
                System.out.println("Current Price: " + fmt.format(stock.getCurrentPrice()));

                if (stock.getProfitLoss() >= 0) {
                    System.out.println("\nProfit/Loss: Profit of " + fmt.format(stock.getProfitLoss()));
                }
                else {
                    System.out.println("\nProfit/Loss: Loss of " + fmt.format(stock.getProfitLoss()));
                }

                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nStock not found");
        }
    }

    public static void showStockPortfolio() {
        System.out.println("Stock Portfolio:\n");
        for (Stock stock : stockList) {
            System.out.println(stock);
        }
    }

    public static void pause() {
        System.out.println("\nPress ENTER to continue...");
        scan.nextLine();
        System.out.print("\n\n");
    }
}