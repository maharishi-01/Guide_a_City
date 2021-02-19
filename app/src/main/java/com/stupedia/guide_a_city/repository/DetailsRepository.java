package com.stupedia.guide_a_city.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.stupedia.guide_a_city.model.DetailsModel;

public class DetailsRepository {
    DetailsRepository instance;
    DetailsModel detailsModel = new DetailsModel();
    MutableLiveData<DetailsModel> mutableLiveData;

    public MutableLiveData<DetailsModel> getData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            getDataFromServer();
        }
        return mutableLiveData;
    }

    private void getDataFromServer() {
        detailsModel.setTitle("NMCH PMCH PATNA");
        mutableLiveData.setValue(detailsModel);
    }

}
