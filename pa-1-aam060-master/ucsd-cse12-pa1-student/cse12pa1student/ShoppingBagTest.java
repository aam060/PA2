package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ShoppingBagTest {

	public static Collection<Object[]> BAGNUMS = Arrays
			.asList(new Object[][] { { 0 }, { 1 }, { 2 }, { 3 }, { 4 }, { 5 },
					{ 6 }, { 7 }, { 8 }, { 9 }, { 10 }, { 11 } });
	private int bagType;

	public ShoppingBagTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Bag{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}

	private ShoppingBag makeBag() {
		switch (this.bagType) {
		case 0:
			return new Bag0();
		case 1:
			return new Bag1();
		case 2:
			return new Bag2();
		case 3:
			return new Bag3();
		case 4:
			return new Bag4();
		case 5:
			return new Bag5();
		case 6:
			return new Bag6();
		case 7:
			return new Bag7();
		case 8:
			return new Bag8();
		case 9:
			return new Bag9();
		case 10:
			return new Bag10();
		case 11:
			return new Bag11();
		}
		return null;
	}

	/**
	 * This method adds one item to the bag, and checks that the total count is
	 * correct(should be 1)
	 * 
	 * Wrong only for Bag0
	 */
	@Test
	public void addedHasCount1() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		assertEquals(bagToTest.totalCount(), 1);
	}

	/**
	 * This method adds two of the same items and gets the total price(should be
	 * 10)
	 * 
	 * Wrong result for 0, 11, because 11 fails to actually add a duplicate
	 * item. Null pointer exception for 2, 6 because both use an array of 10
	 * only
	 */
	@Test
	public void addedDupeGetTotal() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);

		assertEquals(bagToTest.totalPrice(), 10);
	}

	/**
	 * This method adds two of the same items and remove it using removeall().
	 * There should be no items in the bag
	 * 
	 * Wrong for 5 because 5 only removes one of the object given as the
	 * parameter then exits the loop
	 */
	@Test
	public void dupeRemoveAll() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);
		bagToTest.removeAll(i);
		assertEquals(bagToTest.totalCount(), 0);
	}

	/**
	 * This method adds eleven items to the bag, and returns the count of
	 * items(should be eleven)
	 * 
	 * Wrong result in 2 because 2 fails to add more items beyond 10. Also uses
	 * an array of 10 items only. Nullpointer exception in 6 because 6 uses an
	 * item array of 10
	 */
	@Test
	public void addElevenGetCount() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		for (int j = 0; j < 11; j++) {
			bagToTest.add(i);
		}

		assertEquals(bagToTest.totalCount(), 11);
	}

	/**
	 * This method adds eleven items to the bag, if it works, this test passes
	 * 
	 * Nullpointer exception in 6 because 6 uses an item array of 10 only
	 */
	@Test
	public void addEleven() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		for (int j = 0; j < 11; j++) {
			bagToTest.add(i);
		}

		assertEquals(true, true);
	}

	/**
	 * This method adds four items, one set of duplicates, and removes the
	 * duplicates using removeAll(). Then, reutrn the totalCount
	 * 
	 * Wrong result for 10, because 10's removeAll() method for the arraylist
	 * essentially clears the list of everything, not just the specified item
	 */
	@Test
	public void emptyThenReturnPrice() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 6);
		Item k = new Item("Shampoo", 7);
		bagToTest.add(i);
		bagToTest.add(j);
		bagToTest.add(k);
		bagToTest.add(i);

		bagToTest.removeAll(i);

		assertEquals(bagToTest.totalCount(), 2);
	}

	/**
	 * This method checks the bag for all instances of null
	 *
	 * Wrong result for bag 3 because bag3 increments its return int whenever it
	 * goes through an item
	 */
	@Test
	public void countOfNull() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 7);
		bagToTest.add(i);
		bagToTest.add(j);

		assertEquals(bagToTest.itemCount(null), 0);
	}

	/**
	 * This method adds a pair of duplicates, and checks the item count of that
	 * specific object
	 * 
	 * Wrong result for 5
	 */
	@Test
	public void countofDupe() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);

		assertEquals(bagToTest.itemCount(i), 2);
	}

	/**
	 * Thie method adds a pair of duplicates, but this time, they have different
	 * references.
	 * 
	 * Wrong result for 0, 1, 2, 6, 7, 9, 10
	 */
	@Test
	public void countofDupeDifferentRefs() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(j);

		assertEquals(bagToTest.itemCount(i), 2);
	}

	/**
	 * This method adds two items to the bag and removeAll with null.
	 * 
	 * Wrong result for 0, 10 Nullpointer exceptionf for 5
	 */
	@Test
	public void removeNull() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);

		bagToTest.removeAll(null);

		assertEquals(bagToTest.totalCount(), 2);
	}

	/**
	 * This method removes all of one object, then returns whether or not it
	 * that item was in the bag to remove
	 * 
	 * Wrong result for 0, 7, 10. Wrong for 7 because it removes the items
	 * first, then returns the boolean value
	 */
	@Test
	public void removeAllReturnBool() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);

		assertEquals(bagToTest.removeAll(i), true);
	}

	/**
	 * This test adds null objects to the bag, then runs removeAll(null). I'm
	 * testing if the boolean that this method returns is false, because you
	 * can't really remove nothing from a bag that contains nothing.
	 * 
	 * Fails for 1 to differentiate from 9
	 */
	@Test
	public void removeNullReturnBool() {
		ShoppingBag bagToTest = makeBag();

		bagToTest.add(null);
		bagToTest.add(null);

		assertEquals(bagToTest.removeAll(null), false);
	}

	/**
	 * This method adds null objects to the bag, then uses the itemCout() method
	 * to count the number of null objects
	 */
	@Test
	public void countNull() {
		ShoppingBag bagToTest = makeBag();

		bagToTest.add(null);
		bagToTest.add(null);
		bagToTest.add(null);

		assertEquals(bagToTest.itemCount(null), 3);
	}

}// end of file
