/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class CarriageBolt extends Bolt {

	private static final long serialVersionUID = 2661778837025872948L;

	public CarriageBolt(double l, String d, String m, String f, double uP, int numP) throws IllegalFastener {
		super(l, d, m, f, uP, numP);
	} // CarriageBolt Constructor

	@Override
	public String toString() {
		return "Carriage Bolt " + super.toString();
	} // CarriageBolt toString
	
} //CarriageBolt Class
