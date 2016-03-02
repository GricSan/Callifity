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
        super();
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = new Date();
        this.itemName = foodItem.getName();
        this.itemImageUrl = foodItem.getImageUrl();
        this.itemProteins = foodItem.itemProteins*eatenAmount/100.00;
        this.itemCarbs = foodItem.itemCarbs*eatenAmount/100.00;
        this.itemFats = foodItem.itemFats*eatenAmount/100.00;
        this.itemCalories = foodItem.itemCalories/100*eatenAmount;
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

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getImageUrl() {
        return super.getImageUrl();
    }
}
