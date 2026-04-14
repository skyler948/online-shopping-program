package items;

import javax.swing.*;

public class FoodItem extends Item {

    private int calories;
    private float sugarGrams;
    private float proteinGrams;
    private float fatGrams;
    private float carbohydrateGrams;
    private float sodiumMilligrams;
    private float cholesterolMilligrams;
    private String servingSize;

    public FoodItem(ImageIcon img, String name, float price, float weightKilograms,
                    int calories, float sugarGrams, float proteinGrams, float fatGrams, float carbohydrateGrams, float sodiumMilligrams, float cholesterolMilligrams, String servingSize) {
        super(img, name, price, weightKilograms);
        this.calories = Math.max(0, calories);
        this.sugarGrams = Math.max(0.f, sugarGrams);
        this.proteinGrams = Math.max(0.f, proteinGrams);
        this.fatGrams = Math.max(0.f, fatGrams);
        this.carbohydrateGrams = Math.max(0.f, carbohydrateGrams);
        this.sodiumMilligrams = Math.max(0.f, sodiumMilligrams);
        this.cholesterolMilligrams = Math.max(0.f, cholesterolMilligrams);
        this.servingSize = servingSize;

        category = "Food";
    }

    public String getNutritionLabel() {
        StringBuilder label = new StringBuilder();

        label.append(String.format("Serving size: %s\nCalories: %d", servingSize, calories));
        label.append(isFatFree() ?
                "\nFat Free" : String.format("\nTotal Fat: %.1fg", fatGrams));
        label.append(isCholesterolFree() ?
                "\nCholesterol Free" : String.format("\nCholesterol: %.1fmg", cholesterolMilligrams));
        label.append(isSodiumFree() ?
                "\nSodium Free" : String.format("\nSodium: %.1fmg", sodiumMilligrams));
        label.append(isCarbohydrateFree() ?
                "\nCarbohydrate Free" : String.format("\nTotal Carbohydrate: %.1fg", carbohydrateGrams));
        label.append(isSugarFree() ?
                "\nSugar Free" : String.format("\nTotal Sugars: %.1fg", sugarGrams));
        label.append(String.format("\nProtein: %.1fg", proteinGrams));

        return label.toString();
    }

    public boolean isSugarFree() {
        return sugarGrams == 0.f;
    }

    public boolean isFatFree() {
        return fatGrams == 0.f;
    }

    public boolean isCarbohydrateFree() {
        return carbohydrateGrams == 0.f;
    }

    public boolean isSodiumFree() {
        return sodiumMilligrams == 0.f;
    }

    public boolean isCholesterolFree() {
        return cholesterolMilligrams == 0.f;
    }

    public int getCalories() {
        return calories;
    }

    public float getSugarGrams() {
        return sugarGrams;
    }

    public float getProteinGrams() {
        return proteinGrams;
    }

    public float getFatGrams() {
        return fatGrams;
    }

    public float getCarbohydrateGrams() {
        return carbohydrateGrams;
    }

    public float getSodiumMilligrams() {
        return sodiumMilligrams;
    }

    public float getCholesterolMilligrams() {
        return cholesterolMilligrams;
    }

    public String getServingSize() {
        return servingSize;
    }

}
