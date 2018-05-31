/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class WingNut extends Nut {

	private static final long serialVersionUID = 3744863551235647028L;

	public WingNut(String d, String m, String f, double uP, int numP) throws IllegalFastener {
		super(d, m, f, uP, numP);
		// TODO Auto-generated constructor stub
	} //WingNut constructor

	@Override
	public String toString() {
		return "Wing Nut " + super.toString();
	} //toString method
	
}
