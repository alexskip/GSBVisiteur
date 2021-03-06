package com.gsb.visiteur.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.gsb.visiteur.repositories.ItemDataRepository;
import com.gsb.visiteur.repositories.UserDataRepository;
import com.gsb.visiteur.todolist.ItemViewModel;

import java.util.concurrent.Executor;

/**
 * Created by Philippe on 27/02/2018.
 */


public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ItemDataRepository itemDataSource;
    private final UserDataRepository userDataSource;
    private final Executor executor;

    public ViewModelFactory(ItemDataRepository itemDataSource, UserDataRepository userDataSource, Executor executor) {
        this.itemDataSource = itemDataSource;
        this.userDataSource = userDataSource;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ItemViewModel.class)) {
            return (T) new ItemViewModel(itemDataSource, userDataSource, executor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}