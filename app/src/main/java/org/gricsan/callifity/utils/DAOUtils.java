package org.gricsan.callifity.utils;


import com.activeandroid.query.Select;

import org.gricsan.callifity.db.DailyMealItem;
import org.gricsan.callifity.db.FoodItem;

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


    public static List<FoodItem> getAllFoodItems(){
        return new Select().from(FoodItem.class).execute();
    }

    public static List<DailyMealItem> getAllDailyMealsItems(){
        return new Select().from(DailyMealItem.class).execute();
    }

    public static boolean addFoodItemToDB(FoodItem foodItem){
        if(!new Select().from(FoodItem.class).where("ItemName = ?", foodItem.getName()).exists()){
            foodItem.save();
            return true;
        }
        return false;
    }

}
