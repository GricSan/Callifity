package org.gricsan.callifity.utils;


import com.activeandroid.query.Select;

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


    public static List<FoodItem> getAllFoodItemsDB(){
        return new Select().from(FoodItem.class).execute();
    }


}
