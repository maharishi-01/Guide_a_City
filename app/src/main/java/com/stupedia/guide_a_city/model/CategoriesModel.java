package com.stupedia.guide_a_city.model;

import android.graphics.drawable.GradientDrawable;

public class CategoriesModel {


    int image;
    String title,description;

    GradientDrawable gradient;

    public CategoriesModel(GradientDrawable gradient, int image, String title) {
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
