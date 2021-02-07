package com.stupedia.guide_a_city.ui.useful;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.stupedia.guide_a_city.R;

public class ShowAllCateActivity extends AppCompatActivity {


    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_categories);

        //Hooks

        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAllCateActivity.super.onBackPressed();
            }
        });


    }
}
