package com.example.merchantofgeminaria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merchantofgeminaria.RoomDatabase.CommodityItem;
import com.example.merchantofgeminaria.RoomDatabase.CommodityListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReviewDatabase extends AppCompatActivity {
    //LiveData<List<CommodityItem>> commodityList;
    ArrayList<CommodityItem> commodityItemArrayList = new ArrayList<>();
    String[] commodityNames = {"Carrot","Cashews"};
    String[] commodityLocations = {"Emeraldis","Tourmalina"};
    int[] commodityPrices = {10, 8};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_recyclerview);

        setUpItemModels();

        RecyclerView recyclerView = findViewById(R.id.dbRecyclerView);
        CommodityListAdapter adapter = new CommodityListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpItemModels(){
        //String[] commodityName = getResources().getResourceName(R.id.commodityName);
        //String[] commodityLocation = getResources().getResourceName(R.id.commodityLocation);
        //int[] commodityPrice =
               // Integer.parseInt(getResources().getResourceName(R.id.commodityPrice));
        int[] commodityImage = {R.drawable.icons8_carrot_100,R.drawable.icons8_cashew_100};

        for (int i = 0; i < commodityNames.length; i++){
            commodityItemArrayList.add(new CommodityItem(i,commodityNames[i],commodityPrices[i],
                    commodityLocations[i]));
        }

        /*String commodityName = getResources().getResourceName(R.id.commodityName);
        String commodityLocation = getResources().getResourceName(R.id.commodityLocation);
        int commodityPrice = Integer.parseInt(getResources().getResourceName(R.id.commodityPrice));*/
        //@SuppressLint("UseCompatLoadingForDrawables") Drawable commodityImage =
          //      getResources().getDrawable(R.drawable.icons8_carrot_100);
        //@SuppressLint("UseCompatLoadingForDrawables") Drawable coinImage =
            //    getResources().getDrawable(R.drawable.icons8_coins_64);*/
    }
}
