package com.perezflores.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
//    defined variables

    private ListView moviesListView;
    private ListView favoritesListView;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// references
        moviesListView = (ListView) findViewById(R.id.moviesListView);
        favoritesListView = (ListView) findViewById(R.id.favoritesListView);
        addButton = (Button) findViewById(R.id.addbutton);

        addButton.setOnClickListener(this);

        SharedPreferences savedPrefs = getSharedPreferences("SavedValues", MODE_PRIVATE);
        Gson gson = new Gson();
        String moviesString = savedPrefs.getString("movies", "");
        Movie[] moviesList = gson.fromJson(moviesString, Movie[].class);
        Log.d("movies", moviesString);

    }

    public void onResume() {
        super.onResume();
        SharedPreferences savedPrefs = getSharedPreferences("SavedValues", MODE_PRIVATE);
        Gson gson = new Gson();
        String moviesString = savedPrefs.getString("movies", "");
        Movie[] moviesList = gson.fromJson(moviesString, Movie[].class);
        Log.d("movies", moviesString);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MovieForm.class);

        this.startActivity(intent);
    }

}
