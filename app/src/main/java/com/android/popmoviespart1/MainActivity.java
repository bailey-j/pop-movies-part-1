package com.android.popmoviespart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.popmoviespart1.utils.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieListItemClickListener{

    //static variable - number of items
    private static final int NUM_LIST_ITEMS = 100;

    //private Toast mToast;

    //Adapter variable
    private MovieAdapter mAdapter;
    // RecyclerView variable
    private RecyclerView mMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //store reference to MovieList RecyclerView in activity_main.xml
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

        //makeImageRequest();

    }

    @Override
    public void onMovieListItemClick(int clickedItemIndex) {
        launchDetailActivity(clickedItemIndex);
    }

    private void launchDetailActivity(int position) {
        String positionString = Integer.toString(position);
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.EXTRA_POSITION, position);
        intent.putExtra(intent.EXTRA_TEXT, positionString);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details, menu);
        MenuItem menuItem = menu.findItem(R.id.action_sort);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_sort) {
            //toggle to make new HTTP Request

            //makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
