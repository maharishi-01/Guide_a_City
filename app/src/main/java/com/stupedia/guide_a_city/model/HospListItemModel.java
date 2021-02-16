package com.stupedia.guide_a_city.model;

public class HospListItemModel {
    String url;
    String name;
    String description;
    String lat_lang;
    String rating;

    public HospListItemModel() {
        //empty constructor
    }

    public HospListItemModel(String url, String name,
                             String description, String lat_lang, String rating) {
        this.url = url;
        this.name = name;
        this.description = description;
        this.lat_lang = lat_lang;
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat_lang() {
        return lat_lang;
    }

    public void setLat_lang(String lat_lang) {
        this.lat_lang = lat_lang;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
