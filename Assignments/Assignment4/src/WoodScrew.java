/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class WoodScrew extends Screw {

	private static final long serialVersionUID = 9010535331703836568L;
	private String point;
	private String[] pointList = {"Double Cut", "Sharp", "Type 17"};
	
	public WoodScrew(double l, String d, String m, String f, String h, String dr, String p, double uP, int numP)
			throws IllegalFastener {
		super(l, d, m, f, h, dr, uP, numP);
		if(!isIn(p, pointList))
			throw new IllegalFastener("Illegal wood screw!");
		point = p;
	} //WoodScrew constructor
	
	@Override
	public String toString() {
		return "Wood Screw, " + point + " point, " + super.toString();
	} //toString method
	
}
