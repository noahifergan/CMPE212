/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class IllegalFastener extends Exception {

	private static final long serialVersionUID = -6710281488489204911L;
	
	// An exception thrown by Fastener object if the parameters are not legal
	public IllegalFastener(String message) {
		super(message);
	} // IllegalFastener constructor
	
}
