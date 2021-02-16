package com.stupedia.guide_a_city.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stupedia.guide_a_city.model.HospListItemModel;
import com.stupedia.guide_a_city.repository.HospitalRepository;

import java.util.List;

public class HospitalViewModel extends ViewModel {
    MutableLiveData<List<HospListItemModel>> mutableLiveData;
    HospitalRepository repo;

    public void initVM() {
        if (mutableLiveData != null) {
            return;
        }
        repo = new HospitalRepository();
        mutableLiveData = repo.getData();
    }

    public MutableLiveData<List<HospListItemModel>> getMostViewData() {
        return mutableLiveData;
    }

}
