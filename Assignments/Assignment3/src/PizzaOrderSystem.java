import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This code is supplied as part of assignment 3. You will also need to use a version of your
 * IOHelper class from Exercise 1. You will only need the getInt and getString methods from the
 * IOHelper class, the rest can be deleted.
 * 
 * <p>This class is a pizza ordering system. It obtains information from the user and puts a pizza 
 * order together. It is driven by a command line menu, which is quite ugly, but it works, and 
 * is sufficient to test the operation of your three classes: Pizza, LineItem and IllegalPizza.
 * 
 * <p>You will obtain some information on how your classes need to behave, particularly on how they
 * can be sorted and saved to a file by examining this class. You are advised to make sure you 
 * understand how this code works, particularly the use of the ArrayList<LineItem> object.
 * 
 * <p>You have also been provided with unit testing classes and it would make sense to have your
 * Pizza and LineItem classes pass all of these unit tests before using them with this order
 * system.
 * 
 * @author Alan McLeod
 * @version 1.2
 */
public class PizzaOrderSystem {

	private static ArrayList<LineItem> orders = new ArrayList<>();
	private static boolean orderSavedFlag = true;
	
	// A sequential search of the orders collection for a particular Pizza. The index
	// number of the located Pizza is returned or -1 if the Pizza is not in the orders.
	private static int searchOrders(Pizza pizza) {
		for (int line = 0; line < orders.size(); line++)
			if (orders.get(line).getPizza().equals(pizza))
				return line;
		return -1;
	} // end searchOrders

	// Adds a new LineItem to the order. The method must look to see if the particular
	// Pizza is already in the orders collection before adding a new LineItem to the orders.
	// If the Pizza is already there it just increases the order size for that item. If either
	// operation fails the method returns false. It returns true if it works OK.
	private static boolean addItem (int number, Pizza pizza) {
		int orderLocation = searchOrders(pizza);
		if (orderLocation < 0)
			try {
				orders.add(new LineItem(number, pizza));
			} catch (IllegalPizza ip) {
				System.out.println(ip.getMessage());
				return false;
			}
		else {
			LineItem item = orders.get(orderLocation);
			try {
				item.setNumber(item.getNumber() + number);
			} catch (IllegalPizza ip) {
				System.out.println(ip.getMessage());
				return false;				
			}
		}
		orderSavedFlag = false;
		return true;
	} // end addItem
	
	// This rather ugly interface obtains a pizza order from the user. He selects a size,
	// the amount of cheese, mushrooms and pepperoni.
	// If the order parameters are not legal, the method returns a false.
	private static boolean getPizzaOrder() {
		char selection = '\0';
		String prompt = "Enter letter for size: (s)mall, (m)edium or (l)arge: ";
		String result = IOHelper.getString(prompt);
		if (result.length() > 0)
			selection = result.toLowerCase().charAt(0);
		String size = "small";
		if (selection == 'm')
			size = "medium";
		else if (selection == 'l')
			size = "large";
		prompt = "(s)ingle, (d)ouble or (t)riple cheese: ";
		result = IOHelper.getString(prompt);
		String cheese = "single";
		if (result.length() > 0) {
			selection = result.toLowerCase().charAt(0);
			if (selection == 'd')
				cheese = "double";
			else if (selection == 't')
				cheese = "triple";
		}
		prompt = "Mushroom topping: (n)one, (s)ingle or (d)ouble: ";
		result = IOHelper.getString(prompt);
		String mushrooms = "none";
		if (result.length() > 0) {
			selection = result.toLowerCase().charAt(0);
			if (selection == 's')
				mushrooms = "single";
			else if (selection == 'd')
				mushrooms = "double";
		}
		prompt = "Pepperoni topping: (n)one, (s)ingle or (d)ouble: ";
		result = IOHelper.getString(prompt);
		String pepperoni = "none";
		if (result.length() > 0) {
			selection = result.toLowerCase().charAt(0);
			if (selection == 's')
				pepperoni = "single";
			else if (selection == 'd')
				pepperoni = "double";
		}
		Pizza pizza = null;
		try {
			pizza = new Pizza(size, cheese, mushrooms, pepperoni);
		} catch (IllegalPizza ip) {
			System.out.println(ip.getMessage());
			return false;
		}
		System.out.println("So far: " + pizza);
		int orderSize = IOHelper.getInt(1, "How many of these pizzas: ", 100);
		return addItem(orderSize, pizza);
	} // end getPizzaOrder

	// This method allows the user to modify the order. He can remove an entire line in the order
	// or reduce the order size. If the operation fails, the method returns a false or a true if it
	// works OK.
	private static boolean removeOrReduceItem (int itemNumber, int numberPizzas) {
		if (numberPizzas < 1)
			return false;
		if (numberPizzas >= orders.get(itemNumber).getNumber())
			orders.remove(itemNumber);
		else {
			LineItem item = orders.get(itemNumber);
			try {
				item.setNumber(item.getNumber() - numberPizzas);
			} catch (IllegalPizza ip) {
				System.out.println(ip.getMessage());
				return false;				
			}
		}
		orderSavedFlag = false;
		return true;
	} // end removeOrReduceItem
	
	// The orders are displayed to the screen.
	// Note the sort of the ArrayList using a built-in sort method and the use of the
	// toString method from the LineItem class.
	private static void showOrders() {
		float totalCost = 0;
		int line = 1;
		System.out.println("\nLine\tOrder:");
		if (orders.size() == 0)
			System.out.println("No items yet!");
		else {
			orders.sort(null);
			for (LineItem order : orders) {
				totalCost += order.getCost();
				System.out.println(line++ + "\t" + order);
			}
			System.out.printf("Total cost $%.2f\n", totalCost);
		}
	} // end showOrders

    // Saves the order to the binary "Orders.dat" file. Note the use of the writeObject method
	// to save the entire ArrayList with a single line of code. For this to work both the LineItem
	// object and the Pizza object must be serializable, which means that these classes must
	// implement the Serializable interface and declare a serialVersionUID constant (let Eclipse
	// do this for you). If the file save works OK the method returns true, false otherwise.
	private static boolean writeOrders() {
    	String outputFile = "Orders.dat";
    	try (ObjectOutputStream binFileOut = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            binFileOut.writeObject(orders);
        } catch (FileNotFoundException err) {
            System.out.println(err.getMessage());
            return false;
        } catch (IOException err) {
            System.out.println(err.getMessage());
            return false;
        } // end try catch
    	orderSavedFlag = true;
        return true;
    } // end writeOrders

    // This method reads the orders ArrayList from the file "Orders.dat". If the operation is
	// successful the method returns true, false is returned if the operation fails.
	@SuppressWarnings("unchecked")
	private static boolean readOrders() {
    	String inputFile = "Orders.dat";
        try (ObjectInputStream binFileIn = new ObjectInputStream(new FileInputStream(inputFile))) {
            orders = (ArrayList<LineItem>)binFileIn.readObject();
        } catch (ClassNotFoundException err) {
            System.out.println(err.getMessage());
            return false;        	
        } catch (FileNotFoundException err) {
            System.out.println(err.getMessage());
            return false;
        } catch (IOException err) {
            System.out.println(err.getMessage());
            return false;
        } // end try catch
        return true;
    } // end readOrders

	// Displays an ugly little menu to the console.
	private static void displayMenu() {
		System.out.println("\nSelect pizza order operation:");
		System.out.println("\t(L)oad order from file.");
		System.out.println("\t(S)ave order to file.");
		System.out.println("\t(A)dd pizzas.");
		System.out.println("\t(R)emove pizzas.");
		System.out.println("\t(D)isplay order.");
		System.out.println("\t(Q)uit.");
	} // end displayMenu
	
	// Obtains a menu choice from the user, checks to make sure it is legal and then
	// carries out the requested operation. If the operation failed or the user did not choose
	// a valid option, the method returns a false.
	private static boolean getMenuOperation() {
		displayMenu();
		char selection = IOHelper.getString("Operation: ").toLowerCase().charAt(0);
		switch (selection) {
			case 'l' : {
				if ( !orderSavedFlag && orders.size() > 0) {
					System.out.println("Your current order will be lost.");
					String okToContinue = IOHelper.getString("Continue? (Enter \'y\'): ");
					if (okToContinue.length() > 0 && okToContinue.toLowerCase().charAt(0) == 'y')
						return readOrders();
					else {
						System.out.println("Read operation aborted!");
						break;
					}
				}
				return readOrders();
			}
			case 's' : {
				return writeOrders();
			}
			case 'a' : {
				System.out.println("Incorrect entry defaults to a small cheese pizza.");
				return getPizzaOrder();
			}
			case 'r' : {
				int itemNumber = IOHelper.getInt(1, "Pizza order line number to shrink or remove: ", orders.size());
				int currentOrderSize = orders.get(itemNumber - 1).getNumber();
				int numToRemove = 0;
				String removeAll = IOHelper.getString("Enter \'y\' to remove all pizzas, or \'n\' to remove some: ");
				if (removeAll.length() > 0 && removeAll.toLowerCase().charAt(0) == 'y')
					numToRemove = currentOrderSize;
				else
					numToRemove = IOHelper.getInt(0, "Number to remove from order line: ", currentOrderSize);
				return removeOrReduceItem(itemNumber - 1, numToRemove);
			}
			case 'd' : {
				showOrders();
				return true;
			}
			case 'q' : {
				if (!orderSavedFlag) {
					System.out.println("\nOrder is not saved!");
					String exitConfirm = IOHelper.getString("Exit anyways? (Enter \'y\'): ");
					if (!(exitConfirm.length() > 0 && exitConfirm.toLowerCase().charAt(0) == 'y'))
						break;
				}
				System.out.println("\nOrder again soon!");
				System.exit(0);
			}
			default : {
				System.out.println("Illegal menu choice!");
			}
		}
		return false;
	} // end getMenuOperation
	
	// main just shows the menu infinitely, until the user chooses the quit option. The user
	// is told if he chose poorly or the operation failed and the menu is re-displayed.
	public static void main(String[] args) {
		while (true)
			if (!getMenuOperation())
				System.out.println("That did not work, please try again.");
	} // end main

} // end PizzaOrderSystem