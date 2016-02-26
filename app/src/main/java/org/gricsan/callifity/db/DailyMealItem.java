package org.gricsan.callifity.db;


import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "DailyMealItems", id = "Id")
public class DailyMealItem {

    public DailyMealItem() {
        super();
    }

    public DailyMealItem(String eatenItemID, double eatenAmount, Date itemConsumptionDate) {
        this.eatenItemID = eatenItemID;
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = itemConsumptionDate;
    }

    @Column(name = "EatenItemId")
    private String eatenItemID;

    @Column(name = "EatenItemAmount")
    private double eatenAmount;

    @Column(name = "ConsumptionDate")
    private Date itemConsumptionDate;

    public String getEatenItemID() {
        return eatenItemID;
    }

    public void setEatenItemID(String eatenItemID) {
        this.eatenItemID = eatenItemID;
    }

    public double getEatenAmount() {
        return eatenAmount;
    }

    public void setEatenAmount(double eatenAmount) {
        this.eatenAmount = eatenAmount;
    }

    public Date getItemConsumptionDate() {
        return itemConsumptionDate;
    }

    public void setItemCunsomptionDate(Date itemConsumptionDate) {
        this.itemConsumptionDate = itemConsumptionDate;
    }
}
