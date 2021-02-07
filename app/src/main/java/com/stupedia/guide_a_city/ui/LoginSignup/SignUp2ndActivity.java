package com.stupedia.guide_a_city.ui.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.stupedia.guide_a_city.R;

import java.util.Calendar;

public class SignUp2ndActivity extends AppCompatActivity {

    ImageView backbtn;
    Button nextBtn, loginBtn;
    TextView titleText;
    RadioGroup radioGroup;
    RadioButton selectGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2nd);
        backbtn = findViewById(R.id.signup_back_btn);
        nextBtn = findViewById(R.id.signup_next_btn);
        loginBtn = findViewById(R.id.signup_login_btn);
        titleText = findViewById(R.id.signup_title_txt);
        radioGroup = findViewById(R.id.signUp_radiogroup);
        datePicker = findViewById(R.id.date_picker);
    }

    public void callNextSignupScreen(View view) {

        if (!validateGender() | !validateAge()) {
            return;
        }

        selectGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String date = day + "/" + month + "/" + year;

        String name = getIntent().getStringExtra("fullname");
        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");


        Intent intent = new Intent(getApplicationContext(), SignUp3rdActivity.class);
        intent.putExtra("fullname",name);
        intent.putExtra("username",username);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        intent.putExtra("dob",date);
        intent.putExtra("gender",_gender);


        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(nextBtn, "transition_next_btn");
        pairs[2] = new Pair<View, String>(loginBtn, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndActivity.this, pairs);
            startActivity(intent, options.toBundle());

        } else {
            startActivity(intent);
        }
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}