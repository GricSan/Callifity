package org.gricsan.callifity.db;


import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.gricsan.callifity.utils.MealUtils;

import java.util.Date;

@Table(name = "DailyMeals", id = "Id")
public class MealItem extends FoodItem {

    public MealItem() {
        super();
    }

    public MealItem(FoodItem foodItem, double eatenAmount) {
        super(foodItem.itemName,
                MealUtils.convertToConsumedNutritions(foodItem.itemProteins, eatenAmount),
                MealUtils.convertToConsumedNutritions(foodItem.itemCarbs, eatenAmount),
                MealUtils.convertToConsumedNutritions(foodItem.itemFats, eatenAmount),
                MealUtils.convertToConsumedNutritions(foodItem.itemCalories, eatenAmount),
                foodItem.getImageUrl());
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = new Date();
    }

    @Column(name = "EatenAmount")
    protected double eatenAmount;

    @Column(name = "ConsumptionDate")
    protected Date itemConsumptionDate;

    public double getEatenAmount() {
        return eatenAmount;
    }

    public Date getItemConsumptionDate() {
        return itemConsumptionDate;
    }

}
