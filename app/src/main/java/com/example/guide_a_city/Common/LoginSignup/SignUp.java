package com.example.guide_a_city.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guide_a_city.R;

public class SignUp extends AppCompatActivity {

    ImageView backbtn;
    Button nextBtn, loginBtn;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        backbtn = findViewById(R.id.signup_back_btn);
        nextBtn = findViewById(R.id.signup_next_btn);
        loginBtn = findViewById(R.id.signup_login_btn);
        titleText = findViewById(R.id.signup_title_txt);


    }

    public void callNextSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), SignUp2ndActivity.class);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(nextBtn, "transition_next_btn");
        pairs[2] = new Pair<View, String>(loginBtn, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
            startActivity(intent, options.toBundle());


        } else {
            startActivity(intent);
        }


    }
}