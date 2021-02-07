package com.stupedia.guide_a_city.ui.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.stupedia.guide_a_city.R;

public class RetailerStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_start_up_screen);
    }

    public void callLoginScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn), "transition_login");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this, pairs);
            startActivity(intent, options.toBundle());

        } else {
            startActivity(intent);
        }

    }

    public void callSignUpScreen(View view) {

        Intent intent1 = new Intent(getApplicationContext(), SignUpActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.signup_btn),"transition_Signup_screen");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);
            startActivity(intent1,options.toBundle());
        }else {
            startActivity(intent1);
        }

    }
}