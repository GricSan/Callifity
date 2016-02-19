package org.gricsan.callifity.db;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "FoodItems", id = "Id")
public class FoodItem extends Model {

    public FoodItem() {
        super();
    }

    public FoodItem(String itemName, int itemCalories) {
        super();
        this.itemName = itemName;
        this.itemCalories = itemCalories;
    }

    public FoodItem(String itemName, int itemCalories, int itemProtein, int itemHydroCarb, int itemFat, String itemImageUrl) {
        super();
        this.itemName = itemName;
        this.itemCalories = itemCalories;
        this.itemProtein = itemProtein;
        this.itemHydroCarb = itemHydroCarb;
        this.itemFat = itemFat;
        this.itemImageUrl = itemImageUrl;
    }

    @Column(name = "ItemName")
    public String itemName;

    @Column(name = "Calories")
    public int itemCalories;

    @Column(name = "Protein")
    public int itemProtein;

    @Column(name = "HydroCarb")
    public int itemHydroCarb;

    @Column(name = "Fat")
    public int itemFat;

    @Column(name = "ImageUrl")
    public String itemImageUrl;


}
