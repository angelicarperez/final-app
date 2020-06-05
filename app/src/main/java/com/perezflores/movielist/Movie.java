package com.perezflores.movielist;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

public class Movie {
    public int rating;
    public String name;
    public boolean isFavorite;
    public String description;

    public Movie(int rating, String name, boolean isFavorite, String description ){
        this.rating = rating;
        this.name = name;
        this.isFavorite = isFavorite;
        this.description = description;
    }



}
