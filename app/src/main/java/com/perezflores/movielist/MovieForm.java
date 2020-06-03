package com.perezflores.movielist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieForm extends AppCompatActivity {

    private EditText movieNameText;
    private TextView movieNameLabel;
    private RatingBar ratingBar;
    private Switch favoritesSwitch;
    private EditText descriptionText;
    private TextView descriptionLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_form);
// references
        movieNameText = (EditText) findViewById(R.id.movieNameText);
        movieNameLabel = (TextView) findViewById(R.id.movieNameLabel);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        favoritesSwitch = (Switch) findViewById(R.id.favoritesSwitch);
        descriptionText = (EditText) findViewById(R.id.descriptionText);
        descriptionLabel = (TextView) findViewById(R.id.descriptionLabel);
    }
}
