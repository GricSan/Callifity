package org.gricsan.callifity.db;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "DailyMealItems", id = "Id")
public class DailyMealItem extends Model{

    public DailyMealItem() {
        super();
    }

    public DailyMealItem(int eatenItemID, double eatenAmount, Date itemConsumptionDate) {
        super();
        this.eatenItemID = eatenItemID;
        this.eatenAmount = eatenAmount;
        this.itemConsumptionDate = itemConsumptionDate;
    }

    @Column(name = "EatenItemId")
    public int eatenItemID;

    @Column(name = "EatenItemAmount")
    public double eatenAmount;

    @Column(name = "ConsumptionDate")
    public Date itemConsumptionDate;

    public int getEatenItemID() {
        return eatenItemID;
    }

    public void setEatenItemID(int eatenItemID) {
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
