import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;

public class Nim {

	public static void main(String[] args) {
		int pileSize = 10 + (int)Math.round(Math.random()*90), numberInput;
		int numLeft, power, computerChoice;
		int chooseStarter = Math.round((float)Math.random());
		Scanner scanner = new Scanner(System.in);
		boolean randomMode, playerTurn, inputOK = false; //playerTurn = true -> human, playerTurn = false -> computer
		System.out.println("The pile size is " + pileSize);
		if (chooseStarter == 0) {
			playerTurn = true;
			System.out.println("Human starts!");
		} else {
			playerTurn = false;
			System.out.println("Computer starts!");
		}
		int chooseMode = Math.round((float)Math.random());
		if (chooseMode == 0) {
			randomMode = true;
			System.out.println("Random mode engaged");
		} else {
			System.out.println("Smart mode engaged");
		}
		while (pileSize > 1) {
			if (playerTurn) {
				while(!inputOK) {
					try {
						System.out.print("Pick a number between 1 and " + (pileSize/2) + ": ");
						numberInput = scanner.nextInt();
						if (numberInput < 1 || numberInput > pileSize/2) {
							System.out.println("Please pick a valid input");
						} else {
							pileSize = pileSize - numberInput;
							System.out.println("The pile size is " + pileSize);
							inputOK = true;
							playerTurn = false;
						}
					} catch (Exception e) {
						System.out.println("Invalid input");
						scanner.next();
					}
				}
			} else {
				if (chooseMode == 0) {
					computerChoice = (int)(1 + (float)Math.random()*(pileSize/2));
					pileSize = pileSize - computerChoice;
					System.out.println("The computer has selected " + computerChoice);
					System.out.println("The pile size is " + pileSize);	
				} else {
					power = 6;
					numLeft = (int)Math.pow(2, power) - 1;
					while (numLeft > pileSize) {
						power--;
						numLeft = (int)Math.pow(2, power) - 1;
					}
					computerChoice = pileSize - numLeft;
					if (computerChoice == 0 || computerChoice > pileSize/2) {
						computerChoice = (int)(1 + (float)Math.random()*(pileSize/2));
						pileSize = pileSize - computerChoice;
					} else {
						pileSize = pileSize - computerChoice;
					}
					System.out.println("The computer has selected " + computerChoice);
					System.out.println("The pile size is " + pileSize);	
				}
				playerTurn = true;
				inputOK = false;
				continue;
			}
		}
		if (playerTurn = false) {
			System.out.println("You win!");
		} else {
			System.out.println("You lose :(");
		}
	}
}