/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class Nut extends InnerThreaded {

	private static final long serialVersionUID = -7393287151244404356L;

	public Nut(String d, String m, String f, double uP, int numP) throws IllegalFastener {
		super(d, m, f, uP, numP);
	} // Nut constructor

	@Override
	public String toString() {
		return super.toString();
	}

}
