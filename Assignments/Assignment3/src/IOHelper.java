
/*
 * This is a "helper" utility class originally by Alan McLeod but updated by Noah Ifergan.
 * It contains robust methods that can be used to:
 * 		- obtain an int from the user
 * 		- obtain a double from the user
 * 		- obtain a String from the user
 * The methods to obtain a number from the user can optionally
 * accept the following parameters:
 * 		- the low legal limit
 * 		- the high legal limit
 * 		- a String prompt
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class IOHelper {

    private static Scanner screenInput = new Scanner(System.in);

    public static int getInt(int low, String prompt, int high) {
        int numFromUser = 0;
        String dummy;
        boolean numericEntryOK;
        do {
            System.out.print(prompt);
            numericEntryOK = false;
            try {
                numFromUser = screenInput.nextInt();
                numericEntryOK = true;
            } catch (InputMismatchException e) {
                dummy = screenInput.nextLine();
                System.out.println(dummy + " is not an integer!");
                numFromUser = low;
            } // end try-catch
            // Indicate to the user why he is being prompted again.
            if (numFromUser < low || numFromUser > high) {
                System.out.println("The number is outside the legal limits.");
            }
        } while (!numericEntryOK || numFromUser < low || numFromUser > high);
        return numFromUser;
    } // end full parameter getInt method

    public static int getInt() {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        String prompt = "Please enter any integer: ";
        return getInt(low, prompt, high);
    } // end no parameter getInt method

    public static int getInt(String prompt) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        return getInt(low, prompt, high);
    } // end one parameter getInt method

    public static int getInt(int low, String prompt) {
        int high = Integer.MAX_VALUE;
        return getInt(low, prompt, high);
    } // end two parameter getInt method

    public static int getInt(String prompt, int high) {
        int low = Integer.MIN_VALUE;
        return getInt(low, prompt, high);
    } // end two parameter getInt method

    public static double getDouble(double low, String prompt, double high) {
        double numFromUser = 0;
        String dummy;
        boolean numericEntryOK;
        do {
            System.out.print(prompt);
            numericEntryOK = false;
            try {
                numFromUser = screenInput.nextDouble();
                numericEntryOK = true;
            } catch (InputMismatchException e) {
                dummy = screenInput.nextLine();
                System.out.println(dummy + " is not a double!");
                numFromUser = low;
            } // end try-catch
            // Indicate to the user why he is being prompted again.
            if (numFromUser < low || numFromUser > high) {
                System.out.println("The number is outside the legal limits.");
            }
        } while (!numericEntryOK || numFromUser < low || numFromUser > high);
        return numFromUser;
    } // end full parameter getDouble method

    public static double getDouble() {
        double low = -Double.MAX_VALUE;
        double high = Double.MAX_VALUE;
        String prompt = "Please enter any double: ";
        return getDouble(low, prompt, high);
    } // end no parameter getDouble method

    public static double getDouble(String prompt) {
        double low = -Double.MAX_VALUE;
        double high = Double.MAX_VALUE;
        return getDouble(low, prompt, high);
    } // end one parameter getDouble method

    public static double getDouble(double low, String prompt) {
        double high = Double.MAX_VALUE;
        return getDouble(low, prompt, high);
    } // end two parameter getDouble method

    public static double getDouble(String prompt, double high) {
        double low = -Double.MAX_VALUE;
        return getDouble(low, prompt, high);
    } // end two parameter getDouble method

    public static String getString(String prompt) {
        String userText;
        System.out.print(prompt);
        userText = screenInput.next();
        return userText;
    } // end one parameter getString method
    
} // end IOHelper class
