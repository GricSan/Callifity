package org.gricsan.callifity.db;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.gricsan.callifity.utils.MealUtils;

import java.util.Date;

@Table(name = "DailyMealItems", id = "Id")
public class MealItem extends Model {

    public MealItem() {
        super();
    }

    public MealItem(FoodItem foodItem, double eatenAmount) {
        super();
        this.itemName = foodItem.getName();
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = new Date();
        this.totalCalories = MealUtils.countTotalNutritions(foodItem.getCalories(), eatenAmount);
        this.totalProteins = MealUtils.countTotalNutritions(foodItem.getProteins(), eatenAmount);
        this.totalCarbs = MealUtils.countTotalNutritions(foodItem.getCarbs(), eatenAmount);
        this.totalFats = MealUtils.countTotalNutritions(foodItem.getFats(), eatenAmount);
        this.itemImageUrl = foodItem.getImageUrl();
    }

    @Column(name = "Name")
    private String itemName;

    @Column(name = "EatenAmount")
    private double eatenAmount;

    @Column(name = "ConsumptionDate")
    private Date itemConsumptionDate;

    @Column(name = "TotalCalories")
    private double totalCalories;

    @Column(name = "TotalProteins")
    private double totalProteins;

    @Column(name = "TotalCarbs")
    private double totalCarbs;

    @Column(name = "TotalFats")
    private double totalFats;

    @Column(name = "ImageUrl")
    private String itemImageUrl;


    public String getName() {
        return itemName;
    }

    public double getEatenAmount() {
        return eatenAmount;
    }

    public Date getItemConsumptionDate() {
        return itemConsumptionDate;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalProteins() {
        return totalProteins;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public double getTotalFats() {
        return totalFats;
    }

    public String getImageUrl() {
        return itemImageUrl;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setEatenAmount(double eatenAmount) {
        this.eatenAmount = eatenAmount;
    }

    public void setItemConsumptionDate(Date itemConsumptionDate) {
        this.itemConsumptionDate = itemConsumptionDate;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setTotalProteins(double totalProteins) {
        this.totalProteins = totalProteins;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public void setTotalFats(double totalFats) {
        this.totalFats = totalFats;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }
}
