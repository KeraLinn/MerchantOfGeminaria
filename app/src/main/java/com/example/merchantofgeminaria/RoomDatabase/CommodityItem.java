package com.example.merchantofgeminaria.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Item")
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

}
