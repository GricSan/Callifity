package org.gricsan.callifity.db;


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

    public FoodItem(String itemName, double itemProteins, double itemCarbs, double itemFats, double itemCalories, String itemImageUrl) {
        super();
        this.itemName = itemName;
        this.itemCalories = itemCalories;
        this.itemProteins = itemProteins;
        this.itemHydroCarbs = itemCarbs;
        this.itemFats = itemFats;
        this.itemImageUrl = itemImageUrl;
    }

    @Column(name = "ItemName")
    public String itemName;

    @Column(name = "Calories")
    public double itemCalories;

    @Column(name = "Protein")
    public double itemProteins;

    @Column(name = "HydroCarb")
    public double itemHydroCarbs;

    @Column(name = "Fat")
    public double itemFats;

    @Column(name = "ImageUrl")
    public String itemImageUrl;


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
        return itemHydroCarbs;
    }

    public double getFats() {
        return itemFats;
    }

    public String getImageUrl() {
        return itemImageUrl;
    }
}
