// Elgin Baylor
// May 26, 2025
// CS 142 - M8A2B


import java.util.Locale;
import java.util.Scanner;


/**
 * Helper class to get user input and handle yes/no questions
 * 5/23/2025
 */
public class UserInput {
    private final static Scanner scanner = new Scanner(System.in);

    // Get string
    public static String getLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // boolean to ask yes or no
    public static boolean askYesNo(String prompt) {
        while (true) {
            System.out.println(prompt + " (yes/no): ");    // add the user's requirements
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y"))
                return true;
            if (input.equals("no") || input.equals("n"))
                return false;

            // Neither 'yes' or 'no' was entered, so ask again
            System.out.println("Please answer 'yes' or 'no' or 'y' or 'n'.");
        }
    }
    // test for the code
    public static void main(String[] args) {
        String name = getLine("Name? ");
        boolean likeNoirJazz =  askYesNo("Noir jazz fan?");

        System.out.print("Hey, " + name + "...");
        System.out.println("You like noir based jazz? " + (likeNoirJazz ? "Exquisite taste friend. " : "Huh....sad."));


    }
}