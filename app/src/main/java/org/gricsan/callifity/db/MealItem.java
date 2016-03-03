package org.gricsan.callifity.db;


import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "DailyMeals", id = "Id")
public class MealItem extends FoodItem {

    public MealItem() {
        super();
    }

    public MealItem(FoodItem foodItem, double eatenAmount) {
        super(
                null,
                convertToConsumedNutritions(foodItem.itemProteins, eatenAmount),
                convertToConsumedNutritions(foodItem.itemCarbs, eatenAmount),
                convertToConsumedNutritions(foodItem.itemFats, eatenAmount),
                convertToConsumedNutritions(foodItem.itemCalories, eatenAmount),
                foodItem.getImageUrl()
        );
        this.itemName = foodItem.getName();
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = new Date();
    }

    @Column(name = "MealName")
    private String itemName;

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

    @Override
    public String getName() {
        return this.itemName;
    }

    private static double convertToConsumedNutritions(double nutritions, double eatenAmount) {
        return nutritions / 100 * eatenAmount;
    }

}
