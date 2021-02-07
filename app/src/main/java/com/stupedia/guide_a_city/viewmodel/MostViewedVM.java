package com.stupedia.guide_a_city.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.stupedia.guide_a_city.model.CategoriesModel;
import com.stupedia.guide_a_city.model.MostViewedModel;
import com.stupedia.guide_a_city.repository.CategoryRepo;
import com.stupedia.guide_a_city.repository.MostViewedRepo;

import java.util.List;

public class MostViewedVM extends ViewModel {
    MutableLiveData<List<MostViewedModel>> mutableLiveData;
    MostViewedRepo repo;

    public void initVM() {
        if (mutableLiveData != null) {
            return;
        }
        repo = new MostViewedRepo();
        mutableLiveData = repo.getData();
    }

    public MutableLiveData<List<MostViewedModel>> getMostViewData() {
        return mutableLiveData;
    }

}
