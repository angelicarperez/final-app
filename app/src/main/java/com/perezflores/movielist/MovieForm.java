package com.perezflores.movielist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.perezflores.movielist.Movie;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieForm extends AppCompatActivity implements View.OnClickListener {

    private EditText movieNameText;
    private TextView movieNameLabel;
    private RatingBar ratingBar;
    private Switch favoritesSwitch;
    private EditText descriptionText;
    private TextView descriptionLabel;
    private Button saveButton;
    private SharedPreferences savedPrefs;

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
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(this);
        savedPrefs = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    public void onClick(View v) {
        Gson gson = new Gson();
        String moviesString = savedPrefs.getString("movies", "");
        Movie[] moviesList;
        if (moviesString.length() > 0) {
            moviesList = gson.fromJson(moviesString, Movie[].class);
        } else {
            moviesList = new Movie[]{};
        }
        ArrayList<Movie> movies = new ArrayList<Movie>(Arrays.asList(moviesList));


        int rating = ratingBar.getNumStars();
        String description = descriptionText.getText().toString();
        String name =  movieNameText.getText().toString();
        boolean isFavorite = favoritesSwitch.isChecked();
        Movie movie = new Movie(rating, name, isFavorite, description);

        movies.add(movie);
        String value = gson.toJson(movies);

        SharedPreferences.Editor editor = savedPrefs.edit();
        editor.putString("movies", value);
        editor.commit();
        Log.d("testing","Saved movie!");

        Intent intent = new Intent(this, MainActivity.class);

        this.startActivity(intent);
    }
}
