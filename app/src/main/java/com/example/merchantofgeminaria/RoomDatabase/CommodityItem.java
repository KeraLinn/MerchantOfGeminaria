package com.example.merchantofgeminaria.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "ItemsTable")
public class CommodityItem {

    @PrimaryKey(autoGenerate = true)
    private int itemID;
    @ColumnInfo(name = "Name")
    private String itemName;
    @ColumnInfo(name = "Price")
    private int itemPrice;
    @ColumnInfo(name = "City Location")
    private String cityLocation;
    //tbd if needed /*@ColumnInfo(name = "Item Image") private int itemImage;*/

    public CommodityItem(int itemID, String itemName, int itemPrice, String cityLocation) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.cityLocation = cityLocation;
    }
    public int getItemID() {
        return this.itemID;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getItemPrice() {
        return this.itemPrice;
    }

    public String getCityLocation() {
        return this.cityLocation;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

}
