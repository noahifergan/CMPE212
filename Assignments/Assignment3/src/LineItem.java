/**
 * The LineItem class is designed to describe a single line item from the pizza order.
 * This includes the type of pizza ordered designated by the Pizza object and the number of
 * pizzas ordered. 
 * @author Noah Ifergan - 20024375
 */

import java.io.Serializable;

public class LineItem implements Comparable<LineItem>, Serializable {

	private static final long serialVersionUID = 1L;
	Pizza pizza;
	int number;
	
	/**
	 * Constructor that sets the number of pizzas ordered and a pointer to the Pizza object.
	 * @param num The number of pizzas ordered.
	 * @param pizza Pointer to the Pizza object.
	 * @throws IllegalPizza if the pizza object is null.
	 */
	public LineItem(int num, Pizza pizza) throws IllegalPizza {
		if (pizza == null)
			throw new IllegalPizza("Invalid Pizza!");
		this.pizza = pizza;
		setNumber(num);
	}
	
	/**
	 * Constructor that defaults to a single pizza order.
	 * @param pizza Pointer to the pizza object.
	 * @throws IllegalPizza if the pizza object is null.
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		if (pizza == null)
			throw new IllegalPizza("Invalid Pizza!");
		this.pizza = pizza;
		number = 1;
	}
	
	/**
	 * Sets the number of pizzas ordered.
	 * @param num The number of pizzas ordered.
	 * @throws IllegalPizza if the number of pizzas ordered is less than 1 or greater than 100.
	 */
	public void setNumber(int num) throws IllegalPizza {
		if (num < 1 || num > 100)
			throw new IllegalPizza("Illegal number of pizzas: " + number);
		number = num;
	}
	
	/**
	 * An accessor for the pizza object.
	 * @return The pizza object.
	 */
	public Pizza getPizza() {
		return pizza;
	}
	
	/**
	 * An accessor for the number of pizzas ordered.
	 * @return The number of pizzas ordered.
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * An accessor of the discounted cost of the pizzas. If 10-20 pizzas are ordered,
	 * then the customer receives a 10% discount. If more than 20 pizzas ordered, then
	 * the customer receives a 15% discount.
	 * @return
	 */
	public double getCost() {
		double cost = pizza.getCost();
		if (number >= 10 && number <= 20) {
			cost *= 0.9;
		} else if (number >= 20) {
			cost *= 0.85;
		}
		return cost*number;
	}
	
	/**
	 * Returns a string representation of the Line Item including the number of pizzas
	 * and the pizza type.
	 * @return A string representation of the Line Item.
	 */
	public String toString() {
		String s;
		if (number < 10) {
			s = " " + number + " " + pizza;
		} else {
			s = number + " " + pizza;
		}
		return s;
	}
	
	/**
	 * Compares the total cost of the line item with the pizza cost.
	 * @return An integer indicating the difference in the line item and pizza cost.
	 */
	public int compareTo(LineItem lineitem) {
		return (int) (lineitem.getCost() - getCost());
	}
}
