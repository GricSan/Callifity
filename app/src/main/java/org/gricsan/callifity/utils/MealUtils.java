package org.gricsan.callifity.utils;

import org.gricsan.callifity.db.MealItem;

import java.text.DecimalFormat;
import java.util.List;

public class MealUtils {

    private static MealUtils mMealUtils;

    private MealUtils() {
    }

    public static synchronized MealUtils getInstance() {
        if (mMealUtils == null) {
            mMealUtils = new MealUtils();
        }
        return mMealUtils;
    }

    public static String getTotalDailyProteins(List<MealItem> listOfMeals) {
        double result = 0.0;

        for (MealItem mealItem : listOfMeals) {
            result += mealItem.getProteins();
        }

        return "Total Proteins: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalDailyCarbs(List<MealItem> listOfMeals) {
        double result = 0.0;

        for (MealItem mealItem : listOfMeals) {
            result += mealItem.getCarbs();
        }

        return "Total Carbs: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalDailyFats(List<MealItem> listOfMeals) {
        double result = 0.0;

        for (MealItem mealItem : listOfMeals) {
            result += mealItem.getFats();
        }

        return "Total Fats: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalDailyCalories(List<MealItem> listOfMeals) {
        double result = 0.0;

        for (MealItem mealItem : listOfMeals) {
            result += mealItem.getCalories();
        }
        return "Total Calories: " + new DecimalFormat("####.##").format(result) + " kcal";
    }

    public static String convertToProductNameString(String productName) {
        return "Product: " + productName;
    }

    public static String convertToProteinsString(double amount) {
        return "Proteins: " + new DecimalFormat("####.##").format(amount) + "g";
    }

    public static String convertToCarbsString(double amount) {
        return "Carbs: " + new DecimalFormat("####.##").format(amount) + "g";
    }

    public static String convertToFatsString(double amount) {
        return "Fats: " + new DecimalFormat("####.##").format(amount) + "g";
    }

    public static String convertToEatenString(double amount) {
        return "Eaten: " + new DecimalFormat("####.##").format(amount) + "g";
    }

    public static String convertToCaloriesString(double amount) {
        return "Calories: " + new DecimalFormat("####.##").format(amount) + " kcal";
    }

}
