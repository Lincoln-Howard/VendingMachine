

import java.io.Serializable;

/**
 * A dispenser for snack/drink items.
 * @author Lincoln Howard
 */
@SuppressWarnings("serial")
public class Dispenser implements Serializable {
	/**
	 * The capacity of a single dispenser.
	 */
	public static final int capacity = 20;
	/**
	 * The food or drink we are dispensing.
	 */
	private FoodInfo info;
	/**
	 * The number of items currently in the dispenser.
	 */
	private int count;
	/**
	 * The log for all transactions in this dispenser.
	 */
	private TransactionLog log;
	/**
	 * Create a new dispenser.
	 * @param info The food/drink to dispense.
	 * @param log Log transactions to this log.
	 */
	public Dispenser (FoodInfo info, TransactionLog log) {
		this.info = info;
		count = capacity;
		this.log = log;
	}
	/**
	 * Check whether there are items in the dispenser.
	 * @return True if the dispenser is empty. Otherwise false.
	 */
	public boolean isEmpty () {
		return count == 0;
	}
	/**
	 * Get the type food/drink item being dispensed.
	 * @return The food/drink item being dispensed.
	 */
	public FoodInfo info () {
		return info;
	}
	/**
	 * The current number of items in the dispenser.
	 * @return Item count in the dispenser.
	 */
	public int count () {
		return count;
	}
	/**
	 * Purchase an item from the dispenser. Adjust count accordingly.
	 * @return The type of item in the dispenser.
	 * @throws IndexOutOfBoundsException If empty.
	 */
	public FoodInfo purchase () throws IndexOutOfBoundsException  {
		if (isEmpty ()) throw new IndexOutOfBoundsException ();
		count--;
		log.log (info);
		return info;
	}
}