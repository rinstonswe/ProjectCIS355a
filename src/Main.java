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
                    System.out.println("Case 1");
                    scan.nextLine();
                    break;
                case 2:
                    scan.nextLine();
                    System.out.println("Case 2");
                    scan.nextLine();
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Case 3");
                    scan.nextLine();
                    break;
                case 4:
                    scan.nextLine();
                    System.out.println("Case 4");
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
}