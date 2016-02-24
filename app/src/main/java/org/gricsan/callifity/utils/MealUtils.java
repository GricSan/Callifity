package org.gricsan.callifity.utils;

import org.gricsan.callifity.db.FoodItem;

import java.util.ArrayList;

public class MealUtils {

    private final static double PROTEIN_CALORIES = 4.5;
    private final static double CARB_CALORIES = 4.5;
    private final static double FAT_CALORIES = 9.0;

    public static double countTotalProtein(ArrayList<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getItemProtein();
        }

        return result;
    }

    public static double countTotalCarbs(ArrayList<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getItemHydroCarb();
        }

        return result;
    }

    public static double countTotalFats(ArrayList<FoodItem> listOfMeals) {
        double result = 0.0;

        for (FoodItem foodItem : listOfMeals) {
            result += foodItem.getItemFat();
        }

        return result;
    }

    public static double getTotalCalories(ArrayList<FoodItem> listOfMeals) {
        return countTotalProtein(listOfMeals) * PROTEIN_CALORIES
                + countTotalCarbs(listOfMeals) * CARB_CALORIES
                + countTotalFats(listOfMeals) * FAT_CALORIES;
    }

}
