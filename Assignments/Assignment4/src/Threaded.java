/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class Threaded extends Fastener {

	private static final long serialVersionUID = -5035804609765345991L;
	private String diameter;
	private String diameterList[] = { "#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18",
			"3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10" };

	public Threaded(String d, String m, String f, double uP, int numP) throws IllegalFastener {
		super(m, f, uP, numP);
		if (!isIn(d, diameterList))
			throw new IllegalFastener("Illegal parameter!");
		diameter = d;
	} //Threaded constructor

	@Override
	public String toString() {
		return diameter + " thread, " + super.toString();
	} //toString method
}