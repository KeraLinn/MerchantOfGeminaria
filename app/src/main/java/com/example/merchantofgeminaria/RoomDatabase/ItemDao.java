package com.example.merchantofgeminaria.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("Select * from Name")
    List<CommodityItem> getItemList();
    @Insert
    void insertItem(CommodityItem item);
    @Update
    void updateItem(CommodityItem item);
    @Delete
    void deleteItem(CommodityItem item);
}
