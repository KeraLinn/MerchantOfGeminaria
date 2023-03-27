package com.example.merchantofgeminaria.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ItemsTable")
public class CommodityItem {

    @PrimaryKey(autoGenerate = true)
    private final int itemID;
    @ColumnInfo(name = "Name")
    private final String itemName;
    @ColumnInfo(name = "Price")
    private final int itemPrice;
    @ColumnInfo(name = "City Location")
    private final String cityLocation;
    @ColumnInfo(name = "Item Image")
    private int itemImage;

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

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

}
