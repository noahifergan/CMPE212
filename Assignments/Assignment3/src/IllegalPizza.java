/**
 * An exception thrown by Pizza object if the parameters are not legal
 * @author Noah Ifergan - 20024375
 *
 */

public class IllegalPizza extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Supplies a default message.
	 */
	public IllegalPizza() {
		super("Illegal parameter value supplied to Pizza object.");
	}
	
	/**
	 * Passes along the supplied message to the exception.
	 * @param A more specific message.
	 */
	public IllegalPizza(String message) {
		super(message);
	}
}