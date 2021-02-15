package com.stupedia.guide_a_city.repository;

import android.graphics.drawable.GradientDrawable;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.localst.LocalString;
import com.stupedia.guide_a_city.model.CategoriesModel;
import com.stupedia.guide_a_city.viewmodel.CategViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepo {
    MutableLiveData<List<CategoriesModel>> listMutableLiveData;
    List<CategoriesModel> categoriesModels = new ArrayList<>();

    public MutableLiveData<List<CategoriesModel>> getData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
            getDataFromServer();
        }
        return listMutableLiveData;

    }

    private void getDataFromServer() {
        final GradientDrawable[] drawablesArray = new GradientDrawable[4];

        drawablesArray[0] = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        drawablesArray[1] = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        drawablesArray[2] = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        drawablesArray[3] = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(LocalString.CATE_DB_REF).child("education").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i = 0;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String description = dataSnapshot.child("description").getValue(String.class);
                    String location = dataSnapshot.child("location").getValue(String.class);
                    String title = dataSnapshot.child("name").getValue(String.class);
                    /**
                     * pay attention for string or integer
                     */
                    if (i > 3) {
                        i = 0;
                    }
                    // String rating = dataSnapshot.child("rating").getValue(Float.class);
                    categoriesModels.add(new CategoriesModel(drawablesArray[i], R.drawable.hospital_image, title));
                    listMutableLiveData.setValue(categoriesModels);
                    i++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}
