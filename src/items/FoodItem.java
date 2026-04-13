package items;

import javax.swing.*;

public class FoodItem extends Item {

    private int calories;
    private int sugarGrams;
    private int proteinGrams;
    private int sodiumMilligrams;

    public FoodItem(ImageIcon img, String name, float price, float weightKilograms,
                    int calories, int sugarGrams, int proteinGrams, int sodiumMilligrams) {
        super(img, name, price, weightKilograms);
        this.calories = Math.max(0, calories);
        this.sugarGrams = Math.max(0, sugarGrams);
        this.proteinGrams = Math.max(0, proteinGrams);
        this.sodiumMilligrams = Math.max(0, sodiumMilligrams);

        category = "Food";
    }

    public int getCalories() {
        return calories;
    }

    public int getSugarGrams() {
        return sugarGrams;
    }

    public int getProteinGrams() {
        return proteinGrams;
    }

    public int getSodiumMilligrams() {
        return sodiumMilligrams;
    }

}
