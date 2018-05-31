
public class OuterThreaded extends Threaded {

	private static final long serialVersionUID = 4732717489677653322L;
	private double length;

	public OuterThreaded(double l, String d, String m, String f, double uP, int numP) throws IllegalFastener {
		super(d, m, f, uP, numP);
		length = l;
		if (!validLength())
			throw new IllegalFastener("Illegal outer threaded!");
	} //OuterThreaded constructor

	// Boolean that is returned true if the length is valid
	private boolean validLength() {
		for (double i = 0.5; i <= 6; i += 0.25) {
			if (length == i)
				return true;
		}
		for (double i = 6; i <= 11; i += 0.5) {
			if (length == i)
				return true;
		}
		for (int i = 11; i <= 20; i++) {
			if (length == i)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return length + " \" long, " + super.toString();
	} // toString method

}