import java.text.DecimalFormat;
import java.util.Scanner;

public class Main
{
    // class level references and variables
    private static Scanner scan = new Scanner(System.in);
    protected static DecimalFormat fmt = new DecimalFormat("0.00");
    private static double total = 0.0;
    private static String order = "";

    public static void main(String[] args)
    {

        int choice;
        final int EXIT_VALUE = 4;

        do {
            //show menu
            System.out.println("Menu\n");
            System.out.println("1) Add to Order");
            System.out.println("2) Show Current Order");
            System.out.println("3) New Order");
            System.out.println("4) Exit");

            //get users choice
            System.out.println("\nEnter your choice: ");
            choice = scan.nextInt();

            switch (choice){
                case 1:
                    addToOrder();
                    showCurrentOrder();
                    scan.nextLine();
                    System.out.println("Press ENTER to continue...\n\n");
                    scan.nextLine();
                    break;
                case 2:
                    showCurrentOrder();
                    scan.nextLine();
                    System.out.println("Press ENTER to continue...\n\n");
                    scan.nextLine();
                    break;
                case 3:
                    total = 0;
                    order = "";
                    showCurrentOrder();
                    scan.nextLine();
                    System.out.println("Press ENTER to continue...\n\n");
                    scan.nextLine();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:        //Normally for error checking
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != EXIT_VALUE);
    }//ends main method
    public static void addToOrder()
    {
        Burger burger = new Burger();
        String option;
        System.out.print("Single or Double burger (single/double)? ");
        option = scan.next();
        if (option.equalsIgnoreCase("Single"))
        {burger.setType("Single");}
        else if  (option.equalsIgnoreCase("Double"))
        {burger.setType("Double");}
        else {System.out.println("\nInvalid burger type");return;}
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("Add cheese (y/n)? ");
        option = scan.next();
        burger.setCheese(option.equalsIgnoreCase("y"));
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("Add bacon (y/n)? ");
        option = scan.next();
        burger.setBacon(option.equalsIgnoreCase("y"));
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()));

        System.out.print("Make it a Meal (y/n)? ");
        option = scan.next();
        burger.setMeal(option.equalsIgnoreCase("y"));
        System.out.println("Item Price: " + fmt.format(burger.calculateItemCost()) + "\n");

        System.out.println("How many of these burgers to add to the order (0 to cancel)? ");
        int quantity = scan.nextInt();
        burger.setQuantity(quantity);

        order = order + burger.toString();
        total = burger.calculateTotalCost();
    }

    public static void showCurrentOrder() {
        System.out.println("Current Order\n" + order + "\nOrder Total: " + fmt.format(total) + "\n");
    }

}//Ends Main class