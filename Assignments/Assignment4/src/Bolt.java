/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class Bolt extends OuterThreaded {

	private static final long serialVersionUID = 7113667577429823723L;

	public Bolt(double l, String d, String m, String f, double uP, int numP) throws IllegalFastener {
		super(l, d, m, f, uP, numP);
	} // bolt constructor

	@Override
	public String toString() {
		return super.toString();
	} // bolt toString

} // bolt class