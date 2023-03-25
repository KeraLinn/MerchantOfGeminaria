package com.example.merchantofgeminaria.RoomDatabase;

import android.content.ClipData;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = CommodityItem.class, exportSchema = false, version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    private static final String DB_Name = "item_db";
    private static ItemDatabase instance;

    public static synchronized ItemDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ItemDatabase.class,
                    DB_Name)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract ItemDao itemDao();
}
