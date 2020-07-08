package com.android.popmoviespart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.popmoviespart1.utils.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieListItemClickListener{

    private String state = "Top Rated";
    //private EditText search;
    private TextView result;
    private Button button;
    private Spinner spinner;

    //static variable - number of items
    private static final int NUM_LIST_ITEMS = 100;

    //Adapter variable
    private MovieAdapter mAdapter;
    // RecyclerView variable
    private RecyclerView mMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.action_search);
        result = findViewById(R.id.tv_url_display);
        spinner = findViewById(R.id.action_sort);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle(R.string.app_name);
        //setSupportActionBar(myToolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_sort);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.api_query, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //store reference to MovieList RecyclerView in activity_main.xml
        mMoviesList = (RecyclerView) findViewById(R.id.rv_movies);

        //We want our movies to display in grid layout
        GridLayoutManager layoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL, false);
        mMoviesList.setLayoutManager(layoutManager);

        //Keep individual items the same/original size
        mMoviesList.setHasFixedSize(true);

        //Create a new MovieAdapter to store the number of items
        mAdapter = new MovieAdapter(NUM_LIST_ITEMS, this);

        //set new Adapter
        mMoviesList.setAdapter(mAdapter);

        //makeImageRequest();


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeTopApiQuery();
            }
        });
    }

    private void makeTopApiQuery() {
        URL topRatedUrl = NetworkUtils.buildTopUrl();
        result.setText(topRatedUrl.toString());
    }

    private void makePopApiQuery() {
        URL mostPopUrl = NetworkUtils.buildPopUrl();
        result.setText(mostPopUrl.toString());
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

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details, menu);
        //MenuItem menuItem = menu.findItem(R.id.action_sort);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_sort) {
            //toggle to make new HTTP Request

            //makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}
