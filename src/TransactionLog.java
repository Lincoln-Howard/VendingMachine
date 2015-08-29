

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Logs transactions of FoodInfo objects in a vending machine.
 * @author Lincoln Howard
 */
@SuppressWarnings("serial")
public class TransactionLog implements Serializable {
	
	private ArrayList <FoodInfo> purchases;
	
	public TransactionLog () {
		purchases = new ArrayList <FoodInfo> ();
	}
	
	public String print () {
	  String ret = "-------- PURCHASES --------\n";
	  for (FoodInfo info : purchases) {
	    ret += info.name () + "\n";
	  }
		return ret + "-------- PURCHASES --------";
	}
	
	public void log (FoodInfo entry) {
		purchases.add (entry);
	}
	
	public int inventory (FoodInfo type) {
		int count = 0;
		for (FoodInfo fi : purchases)
			if (fi == type)
				count++;
		return count;
	}
}