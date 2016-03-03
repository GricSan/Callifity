package org.gricsan.callifity.utils;


import com.activeandroid.query.Select;

import org.gricsan.callifity.db.FoodItem;
import org.gricsan.callifity.db.MealItem;

import java.util.List;

public class DAOUtils {

    private static DAOUtils mDaoUtils;

    private DAOUtils() {
        mDaoUtils = new DAOUtils();
    }

    public static synchronized DAOUtils getInstance() {
        if (mDaoUtils == null) {
            mDaoUtils = new DAOUtils();
        }
        return mDaoUtils;
    }


    public static List<FoodItem> getAllFoodItems() {
        return new Select().from(FoodItem.class).execute();
    }

    public static boolean registerFoodItem(FoodItem foodItem) {
        if (!new Select().from(FoodItem.class).where("Name = ?", foodItem.getName()).exists()) {
            foodItem.save();
            return true;
        }
        return false;
    }

    public static List<MealItem> getAllDailyMeals() {
        return new Select().from(MealItem.class).execute();
    }

    public static boolean registerMeals(MealItem... mealItem) {
        for (MealItem item : mealItem) {
            item.save();
        }
        return true;
    }

    public static void removeMealItem(MealItem mealItem) {
        MealItem searchedMealItem = new Select().from(MealItem.class).where("Id = ?", mealItem.getId()).executeSingle();
        if (searchedMealItem != null) {
            mealItem.delete();
        }
    }

}
