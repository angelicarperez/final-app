package com.perezflores.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


public class MainActivity extends AppCompatActivity {
//    defined variables

    private ListView moviesListView;
    private ListView favoritesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// references
        moviesListView = (ListView) findViewById(R.id.moviesListView);
        favoritesListView = (ListView) findViewById(R.id.favoritesListView);


    }


}
