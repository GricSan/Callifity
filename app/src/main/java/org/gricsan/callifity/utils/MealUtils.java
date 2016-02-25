package org.gricsan.callifity.utils;

import org.gricsan.callifity.db.FoodItem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MealUtils {

    private final static double PROTEIN_CALORIES = 4.5;
    private final static double CARB_CALORIES = 4.5;
    private final static double FAT_CALORIES = 9.0;

    public static String getTotalProteins(ArrayList<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getProteins();
        }

        return "Total Proteins: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalCarbs(ArrayList<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getCarbs();
        }

        return "Total Carbs: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalFats(ArrayList<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getFats();
        }

        return "Total Fats: " + new DecimalFormat("####.##").format(result) + "g";
    }

    public static String getTotalCalories(ArrayList<FoodItem> listOfMeals) {
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
