package org.gricsan.callifity.utils;

import org.gricsan.callifity.db.FoodItem;

import java.text.DecimalFormat;
import java.util.List;

public class MealUtils {

    private static MealUtils mMealUtils;

    private MealUtils() {
    }

    public static synchronized MealUtils getInstance(){
        if(mMealUtils == null){
            mMealUtils = new MealUtils();
        }
        return mMealUtils;
    }

    public static String getTotalProteins(List<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getProteins();
        }

        return "Total Proteins: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalCarbs(List<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getCarbs();
        }

        return "Total Carbs: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalFats(List<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getFats();
        }

        return "Total Fats: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalCalories(List<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getCalories();
        }
        return "Total Calories: " + new DecimalFormat("####.##").format(result) + " kcal";
    }

    public static String convertToProductNameString(String productName) {
        return "Product: " + productName;
    }

    public static String convertToProteinsString(double amount) {
        return "Proteins: " + amount + "g";
    }

    public static String convertToCarbsString(double amount) {
        return "Carbs: " + amount + "g";
    }

    public static String convertToFatsString(double amount) {
        return "Fats: " + amount + "g";
    }

    public static String convertToCaloriesString(double amount) {
        return "Calories: " + amount + " kcal";
    }

}
