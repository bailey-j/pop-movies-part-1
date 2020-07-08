package com.android.popmoviespart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private ImageView posterIv;
    private TextView yearText;
    private TextView ratingText;
    private TextView overviewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.item_toolbar);
        Intent intent = getIntent();

        String positionString = intent.getStringExtra(Intent.EXTRA_TEXT);
        myToolbar.setTitle(positionString);

        posterIv = (ImageView) findViewById(R.id.iv_poster);
        yearText =(TextView) findViewById(R.id.tv_year);
        ratingText = (TextView) findViewById(R.id.tv_rating);
        overviewText = (TextView) findViewById(R.id.tv_overview);

    }
}
