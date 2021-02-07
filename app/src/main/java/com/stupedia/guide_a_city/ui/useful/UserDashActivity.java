package com.stupedia.guide_a_city.ui.useful;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.stupedia.guide_a_city.ui.LoginSignup.RetailerStartUpScreen;
import com.stupedia.guide_a_city.adapter.HomeAdapter.CategoriesAdapter;
import com.stupedia.guide_a_city.model.CategoriesModel;
import com.stupedia.guide_a_city.adapter.HomeAdapter.FeaturedAdapter;
import com.stupedia.guide_a_city.model.FeaturedModel;
import com.stupedia.guide_a_city.adapter.HomeAdapter.MostViewedAdpater;
import com.stupedia.guide_a_city.model.MostViewModel;
import com.stupedia.guide_a_city.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashActivity extends AppCompatActivity  {

    //variables
    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;

    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    //Drawer menu
    ImageView menuIcon;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks

        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        contentView = findViewById(R.id.content);

        //Menu Hooks



        //Functions will be executed automatically when this activity will be created

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }





    //Recycler Views Functions
    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesModel> categoriesModels = new ArrayList<>();
        categoriesModels.add(new CategoriesModel(gradient1, R.drawable.haldiram, "Education"));
        categoriesModels.add(new CategoriesModel(gradient2, R.drawable.champaran, "HOSPITAL"));
        categoriesModels.add(new CategoriesModel(gradient3, R.drawable.haldiram, "Restaurant"));
        categoriesModels.add(new CategoriesModel(gradient4, R.drawable.macdonald, "Shopping"));
        categoriesModels.add(new CategoriesModel(gradient1, R.drawable.macdonald, "Transport"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesModels);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewModel> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewModel(R.drawable.macdonald, "McDonald's"));
        mostViewedLocations.add(new MostViewModel(R.drawable.champaran, "Edenrobe"));
        mostViewedLocations.add(new MostViewModel(R.drawable.haldiram, "J."));
        mostViewedLocations.add(new MostViewModel(R.drawable.macdonald, "Walmart"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedModel> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedModel(R.drawable.macdonald, "Mcdonald's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedModel(R.drawable.haldiram, "Edenrobe", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new FeaturedModel(R.drawable.champaran, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }


    public void callRetailerScreen(View view) {

        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }
}
