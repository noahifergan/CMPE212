import javax.swing.JOptionPane;

public class Part6 {

	public static void main(String[] args) {
		String userInput;
		userInput = JOptionPane.showInputDialog("Enter a number");
		try { 
			int userNum = Integer.parseInt(userInput);
			userNum = userNum + 20;
			JOptionPane.showMessageDialog(null, "Your number plus 20 is " + userNum);
		} catch(NumberFormatException e) {
		System.out.println("Invalid");
		
	}
		
	} // end main method
	
} // end Part6 class
