package com.stupedia.guide_a_city.ui.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stupedia.guide_a_city.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    ImageView backbtn;
    Button nextBtn, loginBtn;
    TextView titleText;
    TextInputLayout fullName, email, password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        backbtn = findViewById(R.id.signup_back_btn);
        nextBtn = findViewById(R.id.signup_next_btn);
        loginBtn = findViewById(R.id.signup_login_btn);
        titleText = findViewById(R.id.signup_title_txt);
        fullName = findViewById(R.id.signup_fullName);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        username = findViewById(R.id.signup_username);


    }

    public void callNextSignupScreen(View view) {

        if (!validateFullname() | !validateUsername() | !validateEmail() | !validatePassword()) {
            return;
        }


        Intent intent = new Intent(getApplicationContext(), SignUp2ndActivity.class);
        intent.putExtra("fullname", fullName.getEditText().getText().toString());
        intent.putExtra("username", username.getEditText().getText().toString());
        intent.putExtra("email", email.getEditText().getText().toString());
        intent.putExtra("password", password.getEditText().getText().toString());


        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(nextBtn, "transition_next_btn");
        pairs[2] = new Pair<View, String>(loginBtn, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
            startActivity(intent, options.toBundle());


        } else {
            startActivity(intent);
        }


    }


    //Validation Functions

    public boolean validateFullname() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();
        String checkSpace = "^(?=.*[a-zA-Z])(?=\\S+$).{4,}$";
        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        }else if(!val.matches(checkSpace))
        {
            username.setError("no whitespace allowed in the entire username and username must contain at least 4 characters.");
            return false;
        }

        else if (val.length() > 20) {
            username.setError("Username is too large");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    public boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checksemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checksemail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }


    public boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain 4 characters, at least 1 digit,at least 1 lower case and upper case. at least 1 special character");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void goBacktoLogin(View view) {

        //to do for login page
    }
}