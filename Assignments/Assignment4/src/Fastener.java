/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

import java.io.Serializable;

public abstract class Fastener implements Serializable {

	private static final long serialVersionUID = -904701694758982260L;
	private String[] materialList = {"Brass", "Stainless Steel", "Steel" };
	private String material;
	private String finish;
	private double unitPrice;
	private int numberPerUnit;

	public Fastener(String m, String f, double uP, int numP) throws IllegalFastener {
		if (!isIn(m, materialList))
			throw new IllegalFastener("Illegal material!");
		if (numP < 1 || numP > 10000)
			throw new IllegalFastener("Illegal number per unit!");
		if (!m.equalsIgnoreCase("Steel") && !f.equalsIgnoreCase("Plain"))
			throw new IllegalFastener("Illegal finish!");
		checkFinishes(m, f);
		material = m;
		finish = f;
		unitPrice = uP;
		numberPerUnit = numP;
	} // Fastener constructor

	@Override
	public String toString() {
		return  material + ", with a " + finish + " finish. " + String.valueOf(numberPerUnit) + " in a unit, $"
				+ unitPrice + " per unit.";
	} //toString method

	//void method that throws exception if finishes are not valid
	public void checkFinishes(String m, String f) throws IllegalFastener {
		String finishesForSteel[] = { "Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc" };
		if (m.equalsIgnoreCase("Steel") && !isIn(f, finishesForSteel)) {
			throw new IllegalFastener("Illegal finish!");
		}
	} // checkFinishes method

	//Calculates the cost of the order
	public String getOrderCost(int orderSize) {
		return String.valueOf(orderSize * numberPerUnit * unitPrice);
	} // getOrderCost method

	//Boolean that checks whether a string can be found in an array of strings
	public boolean isIn(String test, String[] array) {
		for (String str : array) {
			if (str.equals(test))
				return true;
		}
		return false;
	} //isIn method

	//Boolean that checks whether a double can be found in an array of doubles
	public boolean isIn(double test, double[] array) {
		for (double dbl : array) {
			if (dbl == test)
				return true;
		}
		return false;
	}
}
