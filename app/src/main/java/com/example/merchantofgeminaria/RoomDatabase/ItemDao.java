package com.example.merchantofgeminaria.RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverter;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insertItem(CommodityItem item);

    //@Query("DELETE FROM ItemsTable WHERE itemID = :item")
    @Delete
    void deleteItem(CommodityItem item);


    @Query("SELECT * FROM ItemsTable WHERE itemID = :item")
    List<CommodityItem> findCommodity(CommodityItem item);


    @Query("SELECT * FROM ItemsTable")
    LiveData<List<CommodityItem>> getItemList();
}
