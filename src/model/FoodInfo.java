package model;
import java.io.Serializable;

/**
 * Contains information defining a food for a vending machine.
 * @author Lincoln Howard
 */
@SuppressWarnings("serial")
public class FoodInfo implements Serializable {
	/**
	 * The name of the food.
	 */
	private String name;
	/**
	 * Number of calories in the food.
	 */
	private String calories;
	/**
	 * Amount of fat in the food.
	 */
	private String fat;
	/**
	 * Amount of carbs in the food.
	 */
	private String carbs;
	/**
	 * Amount of protein in the food.
	 */
	private String protein;
	/**
	 * The only constructor requires all attributes be defined.
	 * @param name The name of the food.
	 * @param calories The number of calories in the food.
	 * @param fat The grams of fat in the food.
	 * @param carbs The grams of carbs in the food.
	 * @param protein The grams of protein in the food.
	 */
	public FoodInfo (String name, String calories, String fat,
			String carbs, String protein) {
		this.name = name;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
	}
	/**
	 * Accessor method for the name of a FoodInfo object.
	 * @return The name of this food.
	 */
	public String name () {
		return name;
	}
	/**
	 * Accessor method for the calories of a FoodInfo object.
	 * @return The number of calories in the food.
	 */
	public String calories () {
		return calories;
	}
	/**
	 * Accessor method for the fat content of a FoodInfo object.
	 * @return Grams of fat in a food.
	 */
	public String fat () {
		return fat;
	}
	/**
	 * Accessor method for the carb content of a FoodInfo object.
	 * @return Grams of carbs in a food.
	 */
	public String carbs () {
		return carbs;
	}
	/**
	 * Accessor method for the protein content of a FoodInfo object.
	 * @return Grams of protein in a food.
	 */
	public String protein () {
		return protein;
	}
}