package com.stupedia.guide_a_city.repository;

import android.graphics.drawable.GradientDrawable;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.localst.LocalString;
import com.stupedia.guide_a_city.model.CategoriesModel;
import com.stupedia.guide_a_city.model.MostViewedModel;

import java.util.ArrayList;
import java.util.List;

public class MostViewedRepo {

    MutableLiveData<List<MostViewedModel>> listMutableLiveData;
    List<MostViewedModel> mostViewedModels = new ArrayList<>();

    public MutableLiveData<List<MostViewedModel>> getData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            getDataFromServer();
        }
        return listMutableLiveData;

    }

    private void getDataFromServer() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(LocalString.MOST_VIEW_REF).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String description = dataSnapshot.child("description").getValue(String.class);
                    String location = dataSnapshot.child("location").getValue(String.class);
                    String title = dataSnapshot.child("name").getValue(String.class);
                    /**
                     * pay attention for string or integer
                     */

                    System.out.println("ppppp-->" + description);
                    // String rating = dataSnapshot.child("rating").getValue(Float.class);
                    mostViewedModels.add(new MostViewedModel(R.drawable.hospital_image, title));
                    listMutableLiveData.setValue(mostViewedModels);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
