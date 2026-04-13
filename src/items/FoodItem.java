package items;

public class FoodItem extends Item {

    private int calories;
    private int sugarGrams;
    private int proteinGrams;
    private int sodiumGrams;

    public FoodItem(String name, float price, float weightKilograms,
                    int calories, int sugarGrams, int proteinGrams, int sodiumGrams) {
        super(name, price, weightKilograms);
        this.calories = Math.max(0, calories);
        this.sugarGrams = Math.max(0, sugarGrams);
        this.proteinGrams = Math.max(0, proteinGrams);
        this.sodiumGrams = Math.max(0, sodiumGrams);

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

    public int getSodiumGrams() {
        return sodiumGrams;
    }

}
