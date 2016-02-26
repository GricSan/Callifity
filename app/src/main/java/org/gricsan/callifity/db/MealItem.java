package org.gricsan.callifity.db;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "DailyMealItems", id = "Id")
public class MealItem extends Model {

    public MealItem() {
        super();
    }

    public MealItem(String itemName, double eatenAmount, Date itemConsumptionDate) {
        super();
        this.itemName = itemName;
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = itemConsumptionDate;
    }

    @Column(name = "Name", unique = true)
    public String itemName;

    @Column(name = "EatenAmount")
    public double eatenAmount;

    @Column(name = "ConsumptionDate")
    public Date itemConsumptionDate;


    public void setEatenAmount(double eatenAmount) {
        this.eatenAmount = eatenAmount;
    }

    public void setItemCunsomptionDate(Date itemConsumptionDate) {
        this.itemConsumptionDate = itemConsumptionDate;
    }

    public double getEatenAmount() {
        return eatenAmount;
    }

    public Date getItemConsumptionDate() {
        return itemConsumptionDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemConsumptionDate(Date itemConsumptionDate) {
        this.itemConsumptionDate = itemConsumptionDate;
    }
}
