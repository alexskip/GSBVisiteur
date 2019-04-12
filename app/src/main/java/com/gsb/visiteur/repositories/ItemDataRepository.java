package com.gsb.visiteur.repositories;

import android.arch.lifecycle.LiveData;

import com.gsb.visiteur.database.dao.ItemDao;
import com.gsb.visiteur.models.Item;

import java.util.List;

/**
 * Created by Philippe on 27/02/2018.
 */

public class ItemDataRepository {

    private final ItemDao itemDao;

    public ItemDataRepository(ItemDao itemDao) { this.itemDao = itemDao; }

    // --- GET ---

    public LiveData<List<Item>> getItems(long userId){ return this.itemDao.getItems(userId); }

    // --- CREATE ---

    public void createItem(Item item){ itemDao.insertItem(item); }

    // --- DELETE ---
    public void deleteItem(long itemId){ itemDao.deleteItem(itemId); }

    // --- UPDATE ---
    public void updateItem(Item item){ itemDao.updateItem(item); }

}
