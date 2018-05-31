import java.util.Scanner;
import java.util.InputMismatchException;

public class Part4 {

	public static void main(String[] args) {
		double userNum = 0;
		double result;
		Scanner screen = new Scanner(System.in);
		boolean inputOK = false;
		String dump;
		while (!inputOK) {
			System.out.print("Enter a number: ");
			try {
				userNum = screen.nextDouble();
				dump = screen.nextLine();
				inputOK = true;
			} catch (InputMismatchException e) {
				dump = screen.nextLine();
				System.out.println("\"" + dump + "\" is not a legal double, " +
						"please try again!");
			} // end try-catch block
		} // end input loop
		screen.close();
		result = userNum / 20;
		System.out.printf("\nYour number, %f, divided by 20 is %6.2f", userNum, result);
	} // end main method
	
} // end Part4 class