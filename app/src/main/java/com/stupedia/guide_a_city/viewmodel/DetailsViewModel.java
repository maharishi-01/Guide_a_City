package com.stupedia.guide_a_city.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stupedia.guide_a_city.model.DetailsModel;
import com.stupedia.guide_a_city.repository.DetailsRepository;

public class DetailsViewModel extends ViewModel {
    @SuppressLint("StaticFieldLeak")
    Context context;
    MutableLiveData<DetailsModel> mutableLiveData;
    DetailsRepository detailsRepository;

    public void initVM() {
        if (mutableLiveData != null) {
            return;
        }
        detailsRepository = new DetailsRepository();
        mutableLiveData = detailsRepository.getData();
    }

    MutableLiveData<DetailsModel> getDataFromVM() {
        return mutableLiveData;
    }

}
