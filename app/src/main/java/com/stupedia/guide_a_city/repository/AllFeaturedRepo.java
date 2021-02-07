package com.stupedia.guide_a_city.repository;

import android.widget.ListView;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.stupedia.guide_a_city.localst.LocalString;
import com.stupedia.guide_a_city.model.FeaturedModel;

import java.util.List;

public class AllFeaturedRepo {
    MutableLiveData<List<FeaturedModel>> listMutableLiveData;
    List<FeaturedModel> modelList;


    MutableLiveData<List<FeaturedModel>> fetchData() {

        if (listMutableLiveData == null) {

            getServerData();
        }
        return listMutableLiveData;
    }

    private void getServerData() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(LocalString.FEATURE_DB_REF);


    }
}
