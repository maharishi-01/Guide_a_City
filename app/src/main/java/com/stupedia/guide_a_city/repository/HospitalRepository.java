package com.stupedia.guide_a_city.repository;

import androidx.lifecycle.MutableLiveData;

import com.stupedia.guide_a_city.model.HospListItemModel;

import java.util.ArrayList;
import java.util.List;

public class HospitalRepository {
    MutableLiveData<List<HospListItemModel>> listMutableLiveData;
    List<HospListItemModel> categoriesModels = new ArrayList<>();

    public MutableLiveData<List<HospListItemModel>> getData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            getDataFromServer();
        }
        return listMutableLiveData;

    }

    private void getDataFromServer() {
        //

        for (int i = 0; i < 10; i++) {
            HospListItemModel hospListItemModel = new HospListItemModel();
            hospListItemModel.setLat_lang("123");
            hospListItemModel.setRating("4.3");
            hospListItemModel.setDescription("okkkkk byyyyy new oueur");
            hospListItemModel.setName("Psiphon Hospital");
            hospListItemModel.setUrl("");
            categoriesModels.add(hospListItemModel);
        }
        listMutableLiveData.setValue(categoriesModels);

    }
}

