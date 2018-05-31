/*
 * Author: Noah Ifergan
 * CMPE212 Assignment 4
 * This program implements inheritance, polymorphism and hierarchies
 */

public class Screw extends OuterThreaded {

	private static final long serialVersionUID = -895689128713510617L;
	private String head;
	private String drive;
	private String[] headList = { "Bugle", "Flat", "Oval", "Pan", "Round" };
	private String[] driveList = { "6-Lobe", "Philips", "Slotted", "Square" };

	public Screw(double l, String d, String m, String f, String h, String dr, double uP, int numP)
			throws IllegalFastener {
		super(l, d, m, f, uP, numP);
		if (!isIn(h, headList) || !isIn(dr, driveList))
			throw new IllegalFastener("Illegal screw!");
		checkFinishes(f, m);
		head = h;
		drive = dr;
	} //Screw constructor

	@Override
	public String toString() {
		return head + " head, " + drive + " drive, " + super.toString();
	} //toString method
	
	//Method that checks if te finish is valid
	@Override
	public void checkFinishes(String f, String m) throws IllegalFastener {
		String finishesForScrews[] = { "Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc", "Black Phosphate",
				"ACQ 1000 Hour", "Lubricated" };
		if (m.equalsIgnoreCase("Steel") && !isIn(f, finishesForScrews))
			throw new IllegalFastener("Illegal finish!");
	}
	
}
