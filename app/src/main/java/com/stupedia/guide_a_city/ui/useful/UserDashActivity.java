package com.stupedia.guide_a_city.ui.useful;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.adapter.HomeAdapter.CategoriesAdapter;
import com.stupedia.guide_a_city.adapter.HomeAdapter.FeaturedAdapter;
import com.stupedia.guide_a_city.adapter.HomeAdapter.MostViewedAdpater;
import com.stupedia.guide_a_city.model.CategoriesModel;
import com.stupedia.guide_a_city.model.FeaturedModel;
import com.stupedia.guide_a_city.model.MostViewedModel;
import com.stupedia.guide_a_city.viewmodel.CategViewModel;
import com.stupedia.guide_a_city.viewmodel.MostViewedVM;

import java.util.ArrayList;
import java.util.List;

public class UserDashActivity extends AppCompatActivity {

    //variables

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;

    LinearLayout contentView;

    CategViewModel categViewModel;
    MostViewedVM mostViewedVM;
    List<CategoriesModel> categoriesModels;
    List<MostViewedModel> mostViewedModels;

    CategoriesAdapter categoriesAdapter;
    MostViewedAdpater mostViewedAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);
        initializeView();


        categViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(CategViewModel.class);
        categViewModel.initVM();
        categViewModel.getCategoriesData().observe(this, new Observer<List<CategoriesModel>>() {
            @Override
            public void onChanged(List<CategoriesModel> categoriesModels) {

                categoriesAdapter.setData(categoriesModels);

            }
        });

        mostViewedVM = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(MostViewedVM.class);
        mostViewedVM.initVM();
        mostViewedVM.getMostViewData().observe(this, new Observer<List<MostViewedModel>>() {
            @Override
            public void onChanged(List<MostViewedModel> mostViewedModels) {
                mostViewedAdpater.setData(mostViewedModels);

            }
        });


    }

    private void initializeView() {
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_item_recy);

        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        contentView = findViewById(R.id.content);

        categoriesModels = new ArrayList<>();
        categoriesAdapter = new CategoriesAdapter(categoriesModels);
        categoriesRecycler.setAdapter(categoriesAdapter);


        mostViewedModels = new ArrayList<>();
        mostViewedAdpater = new MostViewedAdpater(mostViewedModels);
        mostViewedRecycler.setAdapter(mostViewedAdpater);


    }

}
