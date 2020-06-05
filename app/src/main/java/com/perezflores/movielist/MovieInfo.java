package com.perezflores.movielist;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

public class MovieInfo extends AppCompatActivity {
    private TextView movieTitle;
    private TextView movieRating;
    private TextView movieDesc;
    private TextView movieTitleLabel;
    private TextView movieRatingLabel;
    private TextView movieDescLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);
// references
        movieTitle = (TextView) findViewById(R.id.movieTitle);
        movieRating = (TextView) findViewById(R.id.movieRating);
        movieDesc = (TextView) findViewById(R.id.movieDesc);
//
//        // get data from the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int rating = intent.getIntExtra("rating", 0);
        String description = intent.getStringExtra("description").replace('\n', ' ');
//
//        // display data on the widgets
        movieTitle.setText(title);
        movieRating.setText(Integer.toString(rating));
        movieDesc.setText(description);
    }
}
