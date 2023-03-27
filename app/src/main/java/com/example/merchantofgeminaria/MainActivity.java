package com.example.merchantofgeminaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.merchantofgeminaria.RoomDatabase.CommodityItem;
import com.example.merchantofgeminaria.RoomDatabase.ItemDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button DBButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBButton = findViewById(R.id.goToDB);
        DBButton.setOnClickListener(this);

        ItemDatabase.getInstance(this);
    }
    private void insertIntoDB(){
        CommodityItem carrot = new CommodityItem(1,"Carrot",10,"Emeraldis");
        ItemDatabase db = ItemDatabase.getInstance(this);
        db.itemDao().insertItem(carrot);
    }
    public void onClick(View v){
        Intent intent;
        if (v == DBButton) {
            intent = new Intent(MainActivity.this, ReviewDatabase.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}