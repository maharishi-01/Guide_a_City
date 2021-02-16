package com.stupedia.guide_a_city.ui.useful;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stupedia.guide_a_city.adapter.SliderAdapter;
import com.stupedia.guide_a_city.R;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dots_layout;
     SliderAdapter sliderAdapter;
     TextView[] dots;
     Button letsGetstarded;
     Animation animation;
     int currentpostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       //Hooks
        viewPager = findViewById(R.id.slider);
        dots_layout = findViewById(R.id.dots);
        letsGetstarded =findViewById(R.id.get_started);
        // call Adapter
        sliderAdapter= new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }

    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), UserDashActivity.class));
        finish();
    }
    public void letsstart(View view){
        startActivity(new Intent(getApplicationContext(), UserDashActivity.class));
        finish();
    }
    public void  next(View view){
        viewPager.setCurrentItem(currentpostion +1);
    }


    private void addDots(int position){
        dots = new TextView[4];
        dots_layout.removeAllViews();
        for(int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots_layout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
             addDots(position);

             currentpostion = position;

             if(position==0)
             {
                letsGetstarded.setVisibility(View.INVISIBLE);
             }
             else if(position==1){

                 letsGetstarded.setVisibility(View.INVISIBLE);
             }
             else if (position==2){
                 letsGetstarded.setVisibility(View.INVISIBLE);
             }
             else {
                 animation= AnimationUtils.loadAnimation(OnBoardingActivity.this,R.anim.bottom_anim);
                 letsGetstarded.setAnimation(animation);
                 letsGetstarded.setVisibility(View.VISIBLE);
             }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
