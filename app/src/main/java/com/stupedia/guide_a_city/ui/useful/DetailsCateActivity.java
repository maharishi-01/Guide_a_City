package com.stupedia.guide_a_city.ui.useful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.interfaces.RecyclerViewItemClick;

public class DetailsCateActivity extends AppCompatActivity  {
    TextView titleText, descText, ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_cate);
        initializeView();


    }

    private void initializeView() {

    }

}