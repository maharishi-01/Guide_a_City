package com.stupedia.guide_a_city.ui.useful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.stupedia.guide_a_city.R;

public class SplashScreenActivity extends AppCompatActivity {

    private  static final int SPLASH_TIMER=1500;

    ImageView backgroundImage;
    TextView poweredby;
    //Animation
    Animation sideAnim,bottomAnim;
    //for check user is new or not
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        backgroundImage = findViewById(R.id.background_image);
        poweredby= findViewById(R.id.powered_by);

        //Animation
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //srt Animation on elements
        backgroundImage.setAnimation(sideAnim);
        poweredby.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime =onBoardingScreen.getBoolean("firstTime",true);
                if(isFirstTime){

                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), OnBoardingActivity.class);
                    startActivity(intent);
                    finish();


                }
                else {
                    Intent intent = new Intent(getApplicationContext(), UserDashActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },SPLASH_TIMER);
    }
}
