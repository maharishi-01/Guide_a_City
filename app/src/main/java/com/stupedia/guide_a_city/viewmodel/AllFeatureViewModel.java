package com.stupedia.guide_a_city.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stupedia.guide_a_city.model.FeaturedModel;

import java.util.List;

public class AllFeatureViewModel extends ViewModel {
    MutableLiveData<List<FeaturedModel>> listMutableLiveData;
    Context context;

    void initVM(Context context) {

    }

}
