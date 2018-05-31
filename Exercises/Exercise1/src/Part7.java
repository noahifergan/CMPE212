import java.util.Scanner;

/*
 * This is a class that you may use to test the
 * operation of your IO helper class.  It assumes that the class is
 * called IOHelper, but you can use another name for your helper class
 * and just carry out a "search and replace" in this program.
 */
public class IOHelper {

	private static void testIntInput () {
		
		int low = -100;
		int high = 200;
		int num;
		
		String prompt = "Please supply a number between " + low + " and " + high + ": ";
		num = IOHelper.getInt(low, prompt, high);
		System.out.println("Obtained: " + num);
		
		low = 400;
		prompt = "Please supply a number above " + low + ": ";
		num = IOHelper.getInt(low, prompt);
		System.out.println("Obtained: " + num);

		high = 500;
		prompt = "Please supply a number below " + high + ": ";
		num = IOHelper.getInt(prompt, high);
		System.out.println("Obtained: " + num);

		prompt = "Please supply a number: ";
		num = IOHelper.getInt(prompt);
		System.out.println("Obtained: " + num);

		num = IOHelper.getInt();
		System.out.println("Obtained: " + num);		
		
	} // end testIntInput method
	
	private static void testDoubleInput () {
		
		double low = -100;
		double high = 200;
		double num;
		
		String prompt = "Please supply a number between " + low + " and " + high + ": ";
		num = IOHelper.getDouble(low, prompt, high);
		System.out.println("Obtained: " + num);
		
		low = 400;
		prompt = "Please supply a number above " + low + ": ";
		num = IOHelper.getDouble(low, prompt);
		System.out.println("Obtained: " + num);

		high = 500;
		prompt = "Please supply a number below " + high + ": ";
		num = IOHelper.getDouble(prompt, high);
		System.out.println("Obtained: " + num);

		prompt = "Please supply a number: ";
		num = IOHelper.getDouble(prompt);
		System.out.println("Obtained: " + num);

		num = IOHelper.getDouble();
		System.out.println("Obtained: " + num);		
		
	} // end testDoubleInput method
	
	public static int getInt (int low, String prompt, int high) {
		Scanner screen = new Scanner(System.in);
		return screen.nextDouble();
	}

	public static void main(String[] args) {

		testIntInput();
		testDoubleInput();
				
		System.out.println("\nAll done testing!");
	
	} // end main

} // end TestIOHelper
/* SAMPLE OUTPUT:
Please supply a number between -100 and 200: -200
The number is outside the legal limits.
Please supply a number between -100 and 200: 300
The number is outside the legal limits.
Please supply a number between -100 and 200: AAA
AAA is not an integer!
Please supply a number between -100 and 200: 3.5
3.5 is not an integer!
Please supply a number between -100 and 200: 100
Obtained: 100
Please supply a number above 400: 500
Obtained: 500
Please supply a number below 500: 400
Obtained: 400
Please supply a number: 123456
Obtained: 123456
Please enter any integer: -4567
Obtained: -4567
Please supply a number between -100.0 and 200.0: 300
The number is outside the legal limits.
Please supply a number between -100.0 and 200.0: -200
The number is outside the legal limits.
Please supply a number between -100.0 and 200.0: 1e3
The number is outside the legal limits.
Please supply a number between -100.0 and 200.0: 1e1
Obtained: 10.0
Please supply a number above 400.0: 5e-7
The number is outside the legal limits.
Please supply a number above 400.0: 4e5
Obtained: 400000.0
Please supply a number below 500.0: 3e2
Obtained: 300.0
Please supply a number: 234.7e-67
Obtained: 2.347E-65
Please enter any double: 23.567
Obtained: 23.567

All done testing!
*/