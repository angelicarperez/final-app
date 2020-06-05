package com.perezflores.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    defined variables

    private ListView moviesListView;
    private ListView favoritesListView;
    private Button addButton;
    private ArrayList<Movie> favorites;
    private ArrayList<Movie> notFavorites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// references
        moviesListView = (ListView) findViewById(R.id.moviesListView);
        favoritesListView = (ListView) findViewById(R.id.favoritesListView);
        addButton = (Button) findViewById(R.id.addbutton);

        addButton.setOnClickListener(this);

        updateDisplay();
        Log.d("News reader", "Feed displayed");
    }

    public void onResume() {
        super.onResume();
        updateDisplay();

        Log.d("News reader", "Feed displayed");
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MovieForm.class);

        this.startActivity(intent);
    }

    private void onFavoriteClick(AdapterView<?> parent, View v,
                                 int position, long id) {
        // get the item at the specified position
        Movie movie = favorites.get(position);

        // create an intent
        Intent intent = new Intent(this, MovieInfo.class);

        intent.putExtra("title", movie.name);
        intent.putExtra("rating", movie.rating);
        intent.putExtra("description", movie.description);
        Log.d("testing","clicked on item");
        this.startActivity(intent);

    }

    private void onNotFavoriteClick(AdapterView<?> parent, View v,
                                 int position, long id) {
        // get the item at the specified position
        Movie movie = notFavorites.get(position);

        // create an intent
        Intent intent = new Intent(this, MovieInfo.class);

        intent.putExtra("title", movie.name);
        intent.putExtra("rating", movie.rating);
        intent.putExtra("description", movie.description);
        Log.d("testing","clicked on item");
        this.startActivity(intent);

    }

    private void updateDisplay() {
        SharedPreferences savedPrefs = getSharedPreferences("SavedValues", MODE_PRIVATE);
        Gson gson = new Gson();
        String moviesString = savedPrefs.getString("movies", "");
        Movie[] moviesList = gson.fromJson(moviesString, Movie[].class);
        Log.d("movies", moviesString);

        Log.d("movies", moviesString);
        // create a List of Map<String, ?> objects
        favorites = new ArrayList<Movie>();
        notFavorites = new ArrayList<Movie>();
        ArrayList<HashMap<String, String>> favoritesMap =
                new ArrayList<HashMap<String, String>>();

        ArrayList<HashMap<String, String>> notFavoritesMap =
                new ArrayList<HashMap<String, String>>();

        for (Movie item : moviesList ) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("title", item.name);
            if (item.isFavorite) {
                favoritesMap.add(map);
                favorites.add(item);
            }


            else
            {
                notFavoritesMap.add(map);
                notFavorites.add(item);
            }
        }

        // create the resource, from, and to variables
        int resource = R.layout.movie_listitem;
        String[] from = {"title"};
        int[] to = {R.id.movieTextView};

        // create and set the adapter
        SimpleAdapter adapter =
                new SimpleAdapter(this, favoritesMap, resource, from, to);
        moviesListView.setAdapter(adapter);
        SimpleAdapter second =
                new SimpleAdapter(this, notFavoritesMap, resource, from, to);
        favoritesListView.setAdapter(second);
        favoritesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the item at the specified position
                Movie movie = MainActivity.this.favorites.get(position);
                MainActivity.this.viewItem(movie);
            }
        });
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the item at the specified position
                Movie movie = MainActivity.this.notFavorites.get(position);
                MainActivity.this.viewItem(movie);
            }
        });

    }

    private void viewItem(Movie movie) {
        // create an inten
        Intent intent = new Intent(this, MovieInfo.class);

        intent.putExtra("title", movie.name);
        intent.putExtra("rating", movie.rating);
        intent.putExtra("description", movie.description);
        Log.d("testing", "clicked on item");
        startActivity(intent);
    }
}
