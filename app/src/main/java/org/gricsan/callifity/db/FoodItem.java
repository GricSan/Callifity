package org.gricsan.callifity.db;


import android.support.annotation.Nullable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "FoodItems", id = "Id")
public class FoodItem extends Model {

    public FoodItem() {
        super();
    }

    public FoodItem(String itemName, double itemCalories) {
        super();
        this.itemName = itemName;
        this.itemCalories = itemCalories;
    }

    public FoodItem(@Nullable String itemName, double itemProteins, double itemCarbs, double itemFats, double itemCalories, String itemImageUrl) {
        super();
        this.itemName = itemName;
        this.itemCalories = itemCalories;
        this.itemProteins = itemProteins;
        this.itemCarbs = itemCarbs;
        this.itemFats = itemFats;
        this.itemImageUrl = itemImageUrl;
    }

    @Column(name = "FoodName", unique = true)
    private String itemName;

    @Column(name = "Calories")
    protected double itemCalories;

    @Column(name = "Proteins")
    protected double itemProteins;

    @Column(name = "Carbs")
    protected double itemCarbs;

    @Column(name = "Fats")
    protected double itemFats;

    @Column(name = "ImageUrl")
    protected String itemImageUrl;


    public String getName() {
        return itemName;
    }

    public double getCalories() {
        return itemCalories;
    }

    public double getProteins() {
        return itemProteins;
    }

    public double getCarbs() {
        return itemCarbs;
    }

    public double getFats() {
        return itemFats;
    }

    public String getImageUrl() {
        return itemImageUrl;
    }

}
