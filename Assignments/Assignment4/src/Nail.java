/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class Nail extends Fastener {

	private static final long serialVersionUID = -4148762975257780291L;
	private String size;
	private double length;
	private double gauge;

	public Nail(String s, double l, double g, String f, double uP, int numP) throws IllegalFastener {
		super("Steel", f, uP, numP);
		size = s;
		length = l;
		gauge = g;
	} // Nail constructor

	@Override
	public String toString() {
		return size + " size, " + length + "\" long, " + gauge + " gauge, " + super.toString();
	} //toString method

}
