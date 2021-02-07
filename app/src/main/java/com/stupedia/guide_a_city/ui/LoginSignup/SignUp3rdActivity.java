package com.stupedia.guide_a_city.ui.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ScrollView;

import com.stupedia.guide_a_city.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp3rdActivity extends AppCompatActivity {

    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd);

        scrollView = findViewById(R.id.suignUp3Scrollview);
        countryCodePicker= findViewById(R.id.countrycodepicker);
        phoneNumber = findViewById(R.id.signUp_phoneNumber);

    }

    public void callNextSignupScreen(View view) {

        if (!validatePhoneNumber())
        {
            return;
        }

        String _fullname = getIntent().getStringExtra("fullname");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");
        String _dob = getIntent().getStringExtra("dob");
        String _gender = getIntent().getStringExtra("gender");

        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo= "+"+countryCodePicker.getFullNumber()+_getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);

        intent.putExtra("fullname",_fullname);
        intent.putExtra("username",_username);
        intent.putExtra("email",_email);
        intent.putExtra("password",_password);
        intent.putExtra("dob",_dob);
        intent.putExtra("gender",_gender);
        intent.putExtra("phoneNo",_phoneNo);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(scrollView,"transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdActivity.this,pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }


    }


    public boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        String checkSpace = "[0-9](?=\\S+$).{9,}$";
        if (val.isEmpty()) {
            phoneNumber.setError("Field can not be empty");
            return false;
        }else if(!val.matches(checkSpace))
        {
            phoneNumber.setError("no whitespace allowed in the entire phone number and at least 10 digits contain.");
            return false;
        }

        else if (val.length() > 20) {
            phoneNumber.setError("Username is too large");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }
}