package com.stupedia.guide_a_city.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stupedia.guide_a_city.model.CategoriesModel;
import com.stupedia.guide_a_city.repository.CategoryRepo;

import java.util.List;

public class CategViewModel extends ViewModel {
    CategoryRepo categoryRepo;
    MutableLiveData<List<CategoriesModel>> mutableLiveData;

    public void initVM() {
        if (mutableLiveData != null) {
            return;
        }
        categoryRepo = new CategoryRepo();
        mutableLiveData = categoryRepo.getData();
    }

    public MutableLiveData<List<CategoriesModel>> getCategoriesData() {
        return mutableLiveData;
    }

}
