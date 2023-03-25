package com.example.merchantofgeminaria.RoomDatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Insert;

import java.util.List;

public class ItemRepository {
    private MutableLiveData<List<CommodityItem>> searchResults =
            new MutableLiveData<List<CommodityItem>>();
    private LiveData<List<CommodityItem>> allCommodities;
    private ItemDao itemDao;

    public ItemRepository(Application application){
        ItemDatabase db;
        db = ItemDatabase.getInstance(application);
        itemDao = db.itemDao();
        allCommodities = itemDao.getItemList();
    }

    public LiveData<List<CommodityItem>> getAllCommodities() {
        return allCommodities;
    }
    public MutableLiveData<List<CommodityItem>> getSearchResults(){
        return searchResults;
    }

    private void asyncFinished(List<CommodityItem> results) {
        searchResults.setValue(results);;
    }

    private static class QueryAsyncTask extends AsyncTask<CommodityItem, Void, List<CommodityItem>> {
        private ItemDao asyncItemDao;
        private ItemRepository delegate = null;

        QueryAsyncTask(ItemDao itemDao){
            asyncItemDao = itemDao;
        }
        @Override
        protected List<CommodityItem> doInBackground(final CommodityItem... params){
            return asyncItemDao.findCommodity(params[0]);
        }
        @Override
        protected void onPostExecute(List<CommodityItem> result){
            delegate.asyncFinished(result);
        }
    }

    private static class InsertAsyncTask extends AsyncTask<CommodityItem, Void, Void> {
        private ItemDao asyncTaskDao;

        InsertAsyncTask(ItemDao dao) {
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final CommodityItem... params){
            asyncTaskDao.insertItem(params[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<CommodityItem, Void, Void> {
        private ItemDao asyncTaskDao;
        DeleteAsyncTask(ItemDao dao){
            asyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final CommodityItem... params) {
            asyncTaskDao.deleteItem(params[0]);
            return null;
        }
    }

    public void insertCommodity(CommodityItem newItem){
        InsertAsyncTask task = new InsertAsyncTask(itemDao);
        task.execute(newItem);
    }
    public void deleteCommodity(CommodityItem commodityItem){
        DeleteAsyncTask task = new DeleteAsyncTask(itemDao);
        task.execute(commodityItem);
    }
    public void findCommodity(CommodityItem commodityItem){
        QueryAsyncTask task = new QueryAsyncTask(itemDao);
        task.delegate = this;
        task.execute(commodityItem);
    }

}
