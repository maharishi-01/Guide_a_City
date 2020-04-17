package com.example.guide_a_city.HelperClasses.HomeAdapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;

public class CategoriesHelperClass {


    int image;
    String title,description;

    GradientDrawable gradient;

    public CategoriesHelperClass(GradientDrawable gradient,int image, String title) {
        this.image = image;
        this.title = title;
        this.gradient=gradient;
    }

    public int getImage() {
        return image;
    }


    public GradientDrawable getGradient() {
        return gradient;
    }

    public String getTitle() {
        return title;
    }



}
