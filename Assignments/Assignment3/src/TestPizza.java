/*
 * Your Pizza class must pass all the tests contained here.  You may
 * certainly add more tests if you wish.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

class TestPizza {

	// Some legal argument tests:
	// Default constructor.
	// Also tests for toString and getCost.
	@Test
	void testPizza() throws Exception {
		Pizza pizza1 = new Pizza();
		assertEquals("small pizza, single cheese, no mushrooms, single pepperoni. Cost: $8.50 each.", pizza1.toString());
		assertEquals(8.50, pizza1.getCost(), 0.01);
	}

	@Test
	void testPizzaStringStringStringString() throws Exception {
		Pizza pizza1 = new Pizza("small", "single", "none", "none");
		assertEquals("small pizza, single cheese, no mushrooms, no pepperoni. Cost: $7.00 each.", pizza1.toString());
		assertEquals(7.00, pizza1.getCost(), 0.01);		
	}

	@Test
	void testPizzaStringStringStringString1() throws Exception {
		Pizza pizza1 = new Pizza("medium", "triple", "none", "none");
		assertEquals("medium pizza, triple cheese, no mushrooms, no pepperoni. Cost: $12.00 each.", pizza1.toString());
		assertEquals(12.00, pizza1.getCost(), 0.01);		
	}

	@Test
	void testPizzaStringStringStringString2() throws Exception {
		Pizza pizza1 = new Pizza("large", "double", "single", "single");
		assertEquals("large pizza, double cheese, single mushrooms, single pepperoni. Cost: $15.50 each.", pizza1.toString());
		assertEquals(15.50, pizza1.getCost(), 0.01);		
	}

	@Test
	void testPizzaStringStringStringString3() throws Exception {
		Pizza pizza1 = new Pizza("Large", "Single", "Double", "Single");
		assertEquals("large pizza, single cheese, double mushrooms, single pepperoni. Cost: $15.50 each.", pizza1.toString());
		assertEquals(15.50, pizza1.getCost(), 0.01);		
	}

	// Some illegal argument tests
	// Four parameter constructor
	@Test
	void testPizzaStringStringStringString4() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("bork", "single", "single", "single"));
	}

	@Test
	void testPizzaStringStringStringString5() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("", "single", "single", "single"));
	}

	@Test
	void testPizzaStringStringStringString6() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza(null, "single", "single", "single"));
	}

	@Test
	void testPizzaStringStringStringString7() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "bork", "single", "single"));
	}

	@Test
	void testPizzaStringStringStringString8() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "", "single", "single"));
	}

	@Test
	void testPizzaStringStringStringString9() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", null, "single", "single"));
	}

	@Test
	void testPizzaStringStringStringString10() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "bork", "single"));
	}

	@Test
	void testPizzaStringStringStringString11() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "", "single"));
	}

	@Test
	void testPizzaStringStringStringString12() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", null, "single"));
	}

	@Test
	void testPizzaStringStringStringString13() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "single", "bork"));
	}

	@Test
	void testPizzaStringStringStringString14() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "single", ""));
	}

	@Test
	void testPizzaStringStringStringString15() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "single", null));
	}

	// Cannot have mushrooms without pepperoni
	@Test
	void testPizzaStringStringStringString16() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "single", "none"));
	}

	@Test
	void testPizzaStringStringStringString17() throws Exception {
		assertThrows(IllegalPizza.class, () -> new Pizza("small", "single", "double", "none"));
	}

	@Test
	void testEqualsObject() throws Exception {
		Pizza pizza1 = new Pizza("large", "single", "single", "double");
		Pizza pizza2 = new Pizza("large", "single", "single", "double");
		Pizza pizza3 = new Pizza("medium", "single", "single", "double");
		Pizza pizza4 = new Pizza("large", "double", "single", "double");
		Pizza pizza5 = new Pizza("large", "single", "none", "double");
		assertEquals(pizza1, pizza2);
		assertTrue(pizza1.equals(pizza2));
		assertFalse(pizza1.equals(pizza3));
		assertFalse(pizza1.equals(pizza4));
		assertFalse(pizza1.equals(pizza5));
		Integer test = Integer.valueOf(10);
		assertFalse(pizza1.equals(test));
	}

	@Test
	void testClone() throws Exception {
		Pizza pizza1 = new Pizza("large", "single", "single", "double");
		Pizza pizza2 = pizza1.clone();
		assertEquals(pizza1, pizza2);
	}

	@Test
	public void testFileSave() throws Exception {
    	String testFile = "OnePizza.dat";
		Pizza pizza1 = new Pizza("large", "single", "single", "double");
		Pizza pizza2;
    	try (ObjectOutputStream binFileOut = new ObjectOutputStream(new FileOutputStream(testFile))) {
            binFileOut.writeObject(pizza1);
        }
        try (ObjectInputStream binFileIn = new ObjectInputStream(new FileInputStream(testFile))) {
            pizza2 = (Pizza)binFileIn.readObject();
        }
        assertEquals(pizza1, pizza2, "Comparing object from file to object saved.");
    }

}