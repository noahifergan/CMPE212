/**
 * The Pizza class is designed to describe a pizza based on 4 pizza attributes:
 * size, cheese, mushrooms, and pepperoni.
 * @author Noah Ifergan - 20024375
 */

import java.io.Serializable;
import java.text.DecimalFormat;

public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;
	private String size, cheese, mushrooms, pepperoni;
	
	/**
	 * Constructor that creates Pizza object based on attributes.
	 * @param size The size of the pizza.
	 * @param cheese The amount of cheese on the pizza.
	 * @param mushrooms The amount of mushrooms on the pizza.
	 * @param pepperoni The amount of pepperoni on the pizza.
	 * @throws IllegalPizza if the input parameters does not contain one of the three options that
	 * they are supposed to, as checked by the contains method.
	 */
	public Pizza(String size, String cheese, String mushrooms, String pepperoni) throws IllegalPizza {
		String[] sizes = { "small", "medium", "large" };
		String[] cheeses = { "single", "double", "triple" };
		String[] toppings = { "none", "single", "double" };
		if (!contains(sizes, size) || !contains(cheeses, cheese) || !contains(toppings, mushrooms)
				|| !contains(toppings, pepperoni))
			throw new IllegalPizza("Invalid Pizza!");
		if (!mushrooms.equals("none") && pepperoni.equals("none"))
			throw new IllegalPizza("Invalid Pizza!");
		this.size = size.toLowerCase();
		this.cheese = cheese.toLowerCase();
		this.mushrooms = mushrooms.toLowerCase();
		this.pepperoni = pepperoni.toLowerCase();
	}
	
	/**
	 * Default pizza constructor.
	 * @throws IllegalPizza will not occur.
	 */
	public Pizza() throws IllegalPizza {
		this.size = "small";
		this.cheese = "single";
		this.mushrooms = "none";
		this.pepperoni = "single";
	}

	/**
	 * Returns true if the supplied object is equal to the current Pizza object. The basis for equality is
	 * all Pizza attributes being identical. 
	 * @param otherObject Another Pizza object.
	 * @return Returns true if the objects are equal and false if they are not.
	 */
	public boolean equals(Object otherObject) {
		boolean equals = false;
		if (otherObject instanceof Pizza) {
			Pizza otherP = (Pizza) otherObject;
			if (otherP.size.equals(size) && otherP.cheese.equals(cheese) && otherP.mushrooms.equals(mushrooms)
					&& otherP.pepperoni.equals(pepperoni)) {
				equals = true;
			} else {
				equals = false;
			}
		}
		return equals;
	}

	/**
	 * Accessor that returns the cost of the Pizza based on its size and toppings.
	 * @return The cost of the pizza in dollars.
	 */
	public double getCost() {
		double cost = 0;
		if (Pizza.this.size.equals("small")) {
			cost = 7;
		} else if (Pizza.this.size.equals("medium")) {
			cost = 9;
		} else if (Pizza.this.size.equals("large")) {
			cost = 11;
		}
		if (Pizza.this.cheese.equals("double")) {
			cost += 1.5;
		}
		if (Pizza.this.cheese.equals("triple")) {
			cost += 3;
		}
		if (Pizza.this.mushrooms.equals("single")) {
			cost += 1.5;
		}
		if (Pizza.this.mushrooms.equals("double")) {
			cost += 3;
		}
		if (Pizza.this.pepperoni.equals("single")) {
			cost += 1.5;
		}
		if (Pizza.this.pepperoni.equals("double")) {
			cost += 3;
		}
		return cost;
	}

	/**
	 * Returns a deep copy of the Pizza object.
	 * @return a deep copy of the pizza object.
	 */
	public Pizza clone() {
		Pizza pcopy = null;
		try {
			pcopy = new Pizza(size, cheese, mushrooms, pepperoni);
		} catch (IllegalPizza e) {
			return null;
		}
		return pcopy;
	}

	/**
	 * Returns a string representation of the Pizza object including its size, attributes, and cost.
	 * @return a string representation of the Pizza object.
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedCost = df.format(getCost());
		String s = size + " pizza, " + cheese + " cheese, ";
		if (Pizza.this.mushrooms.equals("none")) {
			s += "no mushrooms, ";
		} else {
			s += mushrooms + " mushrooms, ";
		}
		if (Pizza.this.pepperoni.equals("none")) {
			s += "no pepperoni. ";
		} else {
			s += pepperoni + " pepperoni. ";
		}
		s += "Cost: $" + formattedCost + " each.";
		return s;
	}

	private boolean contains(String[] array, String value) {
		for (String string : array) {
			if (string.equalsIgnoreCase(value))
				return true;
		}
		return false;
	}
}
