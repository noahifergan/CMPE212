/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class CommonNail extends Nail {

	private static final long serialVersionUID = -4138635337064976470L;
	private String[] sizesList = {"6D", "8D", "10D", "12D", "16D", "60D"};
	private double[] lengthListNail = {2, 2.5, 3, 3.25, 3.5, 6};
	private double[] gaugeList = {2, 8, 9, 10.25, 11.5};

	public CommonNail(String s, double l, double g, String f, double uP, int numP) throws IllegalFastener{
		super(s, l, g, f, uP, numP);
		if (!isIn(s, sizesList) || !isIn(l, lengthListNail) || !isIn(g, gaugeList))
			throw new IllegalFastener("Illegal common nail!");
		checkFinishes("Steel", f);
	} //CommonNail constructor

	public void checkFinishes(String m, String f) throws IllegalFastener {
		if (!f.equalsIgnoreCase("Bright") && !f.equalsIgnoreCase("Hot Dipped Galvanized"))
			throw new IllegalFastener("Illegal finish");
	} // checkFinishes method
	
	@Override
    public String toString() {
        return "Common Nail, " + super.toString();
    } // toString method
}
