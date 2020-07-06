package com.android.popmoviespart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieListItemClickListener{

    //static variable - number of items
    private static final int NUM_LIST_ITEMS = 100;

    private Toast mToast;

    //Adapter variable
    private MovieAdapter mAdapter;
    // RecyclerView variable
    private RecyclerView mMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //store reference to Movie RecyclerView in activity_main.xml
        mMoviesList = (RecyclerView) findViewById(R.id.rv_movies);

        //We want our movies to display in grid layout
        GridLayoutManager layoutManager = new GridLayoutManager(this,4, GridLayoutManager.VERTICAL, false);
        mMoviesList.setLayoutManager(layoutManager);

        //Keep individual items the same/original size
        mMoviesList.setHasFixedSize(true);

        //Create a new MovieAdapter to store the number of items
        mAdapter = new MovieAdapter(NUM_LIST_ITEMS, this);

        //set new Adapter
        mMoviesList.setAdapter(mAdapter);
    }

    @Override
    public void onMovieListItemClick(int clickedItemIndex) {

        if (mToast != null) {
            mToast.cancel();
        }

        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }

}
