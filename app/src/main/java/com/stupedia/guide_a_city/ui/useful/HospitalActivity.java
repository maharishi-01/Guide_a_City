
package com.stupedia.guide_a_city.ui.useful;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.adapter.HospitalListAdapter;
import com.stupedia.guide_a_city.interfaces.RecyclerViewItemClick;
import com.stupedia.guide_a_city.model.HospListItemModel;
import com.stupedia.guide_a_city.receiver.NetworkChangeReceiver;
import com.stupedia.guide_a_city.viewmodel.HospitalViewModel;

import java.util.ArrayList;
import java.util.List;

public class HospitalActivity extends AppCompatActivity implements RecyclerViewItemClick {
    protected RecyclerView recyclerView;
    protected List<HospListItemModel> itemModels;
    protected HospitalListAdapter hospitalListAdapter;
    protected HospitalViewModel hospitalViewModel;

    private int index = -1, pastVisiblesItems, visibleItemCount, totalItemCount;

    protected LinearLayoutManager layoutManager;
    private View loadMoreView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        initializeView();
        //online status code


        //hospital view mode;
        hospitalViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(HospitalViewModel.class);
        hospitalViewModel.initVM();
        hospitalViewModel.getMostViewData().observe(this, new Observer<List<HospListItemModel>>() {
            @Override
            public void onChanged(List<HospListItemModel> hospListItemModels) {
                itemModels = hospListItemModels;
                hospitalListAdapter.setData(itemModels);

            }
        });

        //recycler view scrolling endless
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
                    if (visibleItemCount + pastVisiblesItems >= totalItemCount - 1) {
                        loadNewData();
                    }

                }
            }
        });
    }


    private void loadNewData() {
        loadMoreView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int position = index + 1;
                for (int i = position; i < position + 10; i++) {
                    HospListItemModel hospListItemModel = new HospListItemModel();
                    hospListItemModel.setLat_lang("123");
                    hospListItemModel.setRating("4.3");
                    hospListItemModel.setDescription("okkkkk byyyyy new oueur");
                    hospListItemModel.setName("Psiphon Hospital");
                    hospListItemModel.setUrl("");
                    index = i;
                    itemModels.add(hospListItemModel);
                }
                System.out.println("last_item-->" + index);
                hospitalListAdapter.notifyDataSetChanged();
                loadMoreView.setVisibility(View.GONE);

            }
        }, 1000);

    }

    private void initializeView() {
        recyclerView = findViewById(R.id.hos_recycler_view);
        loadMoreView = findViewById(R.id.load_more_layout);
        itemModels = new ArrayList<>();
        layoutManager = new LinearLayoutManager(HospitalActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        hospitalListAdapter = new HospitalListAdapter(itemModels, HospitalActivity.this, this);
        recyclerView.setAdapter(hospitalListAdapter);
    }


    @Override
    public void onItemClick(int position) {
        navigateToNextActivity(position);
    }

    private void navigateToNextActivity(int position) {
        Intent i = new Intent(this, DetailsCateActivity.class);
        startActivity(i);
    }
}