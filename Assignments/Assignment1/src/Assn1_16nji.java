/*
 * CMPE212 Assignment 1
 * Created by Noah Ifergan (16nji - 20024375) , submitted on February 1st
 * This program is a simulation of a dice game called 'Pig'
 * The user rolls two dice and plays against a computer player
 * The program implements methods, loops, conditionals and console I/O
 */

import java.util.Random;
import java.util.Scanner;

public class Assn1_16nji {
	static Random generator = new Random(System.currentTimeMillis());
	static Scanner scanner = new Scanner(System.in);
	static boolean playOK = false; //boolean that alternates with the change between the computer's and player's turns
	
	//The main method loops through the computer's turn and the player's turn until one of their scores is above 100, at which point the winner is declared
	public static void main (String[] args) {
		System.out.println("Welcome to Pig! Press <enter> to start the game.");
		scanner.nextLine();
		int playerScore = 0, computerScore = 0, counter = 1;
		while(true) {
			counter += 1; //round counter
			playerScore += playerTurn(playerScore);
			if (playerScore >= 100) {
				System.out.println("Player's score is " + playerScore + ". ***PLAYER WINS***");
				break;
			}
			System.out.println("Player's score is: " + playerScore + ", Computer's score is: " + computerScore + ".\nPress <enter> to start Computer's turn.");
			scanner.nextLine();
			computerScore += computerTurn(computerScore);
			if (computerScore >= 100) {
				System.out.println("Computer's score is " + computerScore + ". ***COMPUTER WINS***");
				break;
			}
			System.out.println("Player's score is: " + playerScore + ", Computer's score is: " + computerScore + ".\nPress <enter> to start round " + counter + ".");
			scanner.nextLine();
		}	
	}
	
	//Simulates the player's turn.
	//The dice is rolled and the turn loops based on the numbers rolled, the player's choice to roll again, and the rules of the game.
	public static int playerTurn(int gameScore) {
		int rollScore = 0, turnScorePlayer = 0;
		Boolean tempOK = true;
		System.out.println("Player's Turn:");
		System.out.println("Press <enter> to roll.");
		scanner.nextLine();
		while (!playOK) {
			int[] dice = diceRoll(); //rolls the dice
			String[] diceWords = convertNumbers(dice); //converts dice numbers into words
			System.out.println("Player rolled a " + diceWords[0] + " + " + diceWords[1] + ".");
			rollScore = scoring(dice); //calculate the score of the roll based on what has been rolled
			if (rollScore == 0) { //when a 1 is rolled, the turn score becomes zero and the turn is ended
				playOK = true; //changing this boolean ends the player's turn
				turnScorePlayer = 0;
			} else { 
				turnScorePlayer += rollScore; //add the rollScore to the total score of the turn
			}
			System.out.println("Player's turn sum is: " + turnScorePlayer + "\n");
			if ((gameScore + turnScorePlayer) >=100) { //if the player's total score from the game and turn is above 100 then end the turn
				return turnScorePlayer;
			}
			if (playOK) { //end turn if boolean has changed
				System.out.println("TURN OVER! Player's turn sum is: " + turnScorePlayer + "\n");
				break;
			}
			Boolean doubles = checkDoubles(dice);
			if (doubles == false) { //ask the player if they want to roll again if doubles weren't rolled
				tempOK = rollAgain(); 
			} else {
				if ((gameScore + turnScorePlayer) >=100) { //if the player's total score from the game and turn is above 100 then end the turn
					return turnScorePlayer;
				}
				System.out.println("Player must roll again.");
				System.out.println("Press <enter> to roll.");
				scanner.nextLine();
			}
			if (!tempOK) { //end the turn if the player does not want to roll again
				playOK = true;
				System.out.println();
			} 
		}
		return turnScorePlayer;
	}
	
	//Simulates the computer's turn.
	//The dice is rolled and the turn loops based on the numbers rolled and the rules of the game.
	//The computer will choose to end its turn if its turn score surpasses 30 (value chosen to make things more interesting)
	public static int computerTurn(int gameScore) {
		int rollScore = 0, turnScoreComputer = 0;
		System.out.println("Computer's Turn:");
		while (playOK) {
			int[] dice = diceRoll();
			String[] diceWords = convertNumbers(dice);
			System.out.println("Computer rolled a " + diceWords[0] + " + " + diceWords[1] + ".");
			rollScore = scoring(dice);
			if (rollScore == 0) {
				playOK = false;
				turnScoreComputer = 0;
				break;
			} else { 
				turnScoreComputer += rollScore;
				System.out.println("Computer's turn sum is: " + turnScoreComputer);
			}
			Boolean doubles = checkDoubles(dice);
			if (doubles == false && turnScoreComputer >= 30) { //computer ends turn if its turn score is above 30
				playOK = false;
				return turnScoreComputer;
			} else if (doubles == true) {
				if ((gameScore + turnScoreComputer) >=100) { //if the player's total score from the game and turn is above 100 then end the turn
					return turnScoreComputer;
				}
				System.out.println("Computer must roll again.");
			}
			if ((gameScore + turnScoreComputer) >= 100) {
				playOK = false;
				return turnScoreComputer;
			}
			System.out.println("Press <enter> to continue.");
			scanner.nextLine(); //press enter to continue
		}
		System.out.println("TURN OVER! Computer's turn sum is: " + turnScoreComputer + "\n");
		return turnScoreComputer;
	}
	
	//Calculates the score returned to the turn based on the dice that were rolled
	public static int scoring(int[] a) {
		int ret = 0;
		if (a[0] == a[1]) { //if doubles are rolled then return double the value of what was rolled (or 25 for snake eyes)
			if (a[0] == 1) {
			ret = 25;
			System.out.println("DOUBLES ONES!");
			} else {
				System.out.println("DOUBLES!");
				ret = 2 * (a[0] + a[1]); //return twice the sum of the double
			}
		} else if (a[0] == 1 || a[1] == 1) { //when a 1 is rolled then return a score of 0
			ret = 0;	
		} else {
			ret = a[0] + a[1]; //otherwise return the sum of the two rolled numbers
		}
		return ret;
	}
	
	//ask the player if they want to roll again and return a boolean based on their answer
	public static boolean rollAgain() {
		Boolean check = true;
		System.out.print("Roll again? (Enter 'y' or 'n'): ");
		while (true) {
			String answer = scanner.nextLine();
			switch(answer) {
			case "y":
				check = true;
				return check;
			case "n":
				check = false;
				return check;
			default:
				System.out.print("Roll again? (Enter 'y' or 'n'): ");
			}
		}
	}
	
	//creates an array to be used as the rolled dice
	public static int[] diceRoll() {
		int[] dice = {random(), random()};//calls the random method to generate a number from 1-6 for the array
		return dice;
	}
	
	//convert the dice numbers that were rolled to words
	public static String[] convertNumbers(int[] a) {
		String[] numbers = {"one", "two", "three", "four", "five", "six"}; //create string with numbers 1 to 6 written in words
		String[] diceWords = {numbers[a[0] - 1], numbers[a[1]-1]};
		return diceWords; //return the words as a string array
	}
	
	//generate random number between 1 and 6
	public static int random () {
		int randTemp = generator.nextInt(6); //generate number between 0 and 5
		int rand = randTemp + 1; //add 1 to adjust range of random number from 1 to 6
		return rand;
		}
	
	//check if the two rolled dice have the same value and return a boolean based on it
	public static boolean checkDoubles(int dice[]) {
		Boolean doubles = false;
		if (dice[0] == dice[1]) {
			doubles = true;
		}
		return doubles;
	}
}