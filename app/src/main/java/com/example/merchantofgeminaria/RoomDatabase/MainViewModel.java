package com.example.merchantofgeminaria.RoomDatabase;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ItemRepository repository;
    private LiveData<List<CommodityItem>> allItems;
    private MutableLiveData<List<CommodityItem>> searchResults;

    public MainViewModel(Application application){
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllCommodities();
        searchResults = repository.getSearchResults();
    }

    MutableLiveData<List<CommodityItem>> getSearchResults(){
        return searchResults;
    }

    public LiveData<List<CommodityItem>> getAllItems() {
        return allItems;
    }
    public void insertItem(CommodityItem commodityItem){
        repository.insertCommodity(commodityItem);
    }
    public void findCommodity(CommodityItem commodityItem){
        repository.findCommodity(commodityItem);
    }
    public void deleteItem(CommodityItem commodityItem){
        repository.deleteCommodity(commodityItem);
    }
}
