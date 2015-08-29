

import java.io.Serializable;
import java.util.ArrayList;
/**
 * A virtual vending machine.
 * @author Lincoln Howard
 */
@SuppressWarnings("serial")
public class VendingMachine implements Serializable {
	/**
	 * The list of costs for associated dispensers.
	 */
	private ArrayList <Double> costs;
	/**
	 * The list of dispensers for associated costs.
	 */
	private ArrayList <Dispenser> dispensers;
	/**
	 * The log for all transactions.
	 */
	private TransactionLog log;
	/**
	 * Default constructor initializes everything.
	 */
	public VendingMachine () {
		costs = new ArrayList <Double> ();
		dispensers = new ArrayList <Dispenser> ();
		log = new TransactionLog ();
	}
	/**
	 * Check if the vending machine is empty.
	 * @return True if the vending machine has no dispensers.
	 */
	public boolean isEmpty () {
		return costs.size () == 0;
	}
	/**
	 * Get the number of dispensers in the vending machine.
	 * @return The number of dispensers.
	 */
	public int size () {
		return costs.size ();
	}
	/**
	 * Add a dispenser to the vending machine.
	 * @param cost The cost of the item.
	 * @param dispenser The dispenser.
	 */
	public void addItem (double cost, FoodInfo info) {
		costs.add (cost);
		dispensers.add (new Dispenser (info, log));
	}
	/**
	 * Remove the item at the provided location.
	 * @param location The location to remove.
	 */
	public void removeItem (int location) {
	  costs.remove (location);
	  dispensers.remove (location);
	}
	/**
	 * Get the cost for the dispenser at a given location.
	 * @param dispenser The location of the dispenser to check the cost of.
	 * @return The cost of an item.
	 */
	public double cost (int dispenser) {
		return costs.get (dispenser);
	}
	/**
	 * Get the food info for a dispenser at a given location.
	 * @param dispenser The location of the dispenser.
	 * @return The information of the item.
	 */
	public FoodInfo info (int dispenser) {
		return dispensers.get (dispenser).info ();
	}
	/**
	 * Check the stock of a dispenser in the vending machine.
	 * @param dispenser The location of the dispenser to check.
	 * @return The number of items available in a dispenser.
	 */
	public int stock (int dispenser) {
		return dispensers.get (dispenser).count ();
	}
	/**
	 * Purchase an item out of the located dispenser.
	 * @param dispenser The location of the dispenser to purchase from.
	 * @param funds The amount of money fed to the machine.
	 * @return The info of the dispensed item.
	 * @throws InsufficientFundsException If the user didn't provide the monies..
	 */
	public FoodInfo purchase (int dispenser, double funds)
			throws InsufficientFundsException {
		if (funds < costs.get (dispenser))
			throw new InsufficientFundsException ();
		return dispensers.get (dispenser).purchase ();
	}
	/**
	 * Run the total report for the vending machine.
	 * @return The report for the machine
	 */
	public String report () {
	  return log.print ();
	}
}