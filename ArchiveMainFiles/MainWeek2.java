import java.text.DecimalFormat;
import java.util.Scanner;


public class Main
{
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        String name = "";
        final String EXIT_VALUE = "X";

        do
        {
            // get user's choice
            System.out.print("\nEnter name or X to quit: ");
            name = scan.nextLine();

            // run code based on choice
            if (!name.equals(EXIT_VALUE))
            {
                System.out.print("Enter age: ");
                int age = Integer.parseInt(scan.nextLine());
                System.out.print("Enter weight: ");
                int weight = Integer.parseInt(scan.nextLine());
                System.out.print("Enter height - feet: ");
                int feet = Integer.parseInt(scan.nextLine());
                System.out.print("Enter height - inches: ");
                int inches = Integer.parseInt(scan.nextLine());

                HealthProfile client = new HealthProfile();
                client.setName(name);
                client.setAge(age);
                client.setWeight(weight);
                client.setHeight(feet, inches);
                healthProfileOutput(client);
            }
            else{
                System.out.println("\nGoodbye!");
                break;
            }
        }
        while (!name.equals(EXIT_VALUE));
    }

    private static void healthProfileOutput(HealthProfile user)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println("\nHealth Profile for " + user.getName());
        System.out.println("BMI: " + df.format(user.calculateBMI()));
        System.out.println("BMI Category: " + user.calculateCategory());
        System.out.println("Max heart rate: " + user.calculateMaxHR());
    }

}
