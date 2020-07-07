package com.android.popmoviespart1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.popmoviespart1.model.Movie;
import com.android.popmoviespart1.model.MovieList;
import com.android.popmoviespart1.utils.NetworkUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.net.URL;

import static java.security.AccessController.getContext;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();
    final private MovieListItemClickListener mOnClickListener;
    private MovieList mMovieList;

    private int mNumberItems;
    private static int viewHolderCount;

    public interface MovieListItemClickListener {
        void onMovieListItemClick(int clickedItemIndex);
    }

    // MovieAdapter Constructor
    public MovieAdapter(int numberOfItems, MovieListItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    //OnBindViewHolder displays the data at the specified position
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
        //holder.bind(mMovieList.get(position), listener);
        //Picasso.get().load("http://image.tmdb.org/t/p/w154" + mMovieList.getPosterPath()).into(movieListView);

    }


/*    private void makeImageRequest() {
        String baseQuery = "";
        URL githubSearchUrl = NetworkUtils.buildListUrl(baseQuery);
        //mUrlDisplayTextView.setText(githubSearchUrl.toString());
        // COMPLETED (2) Call getResponseFromHttpUrl and display the results in mSearchResultsTextView
        // COMPLETED (3) Surround the call to getResponseFromHttpUrl with a try / catch block to catch an IO Exception
        String githubSearchResults = null;
        try {
            githubSearchResults = NetworkUtils.getResponseFromHttpUrl(githubSearchUrl);
            //mSearchResultsTextView.setText(githubSearchResults);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    //Get number of items in cache
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    //Creating enough ViewHolders for scrolling
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MovieViewHolder viewHolder = new MovieViewHolder(view);

        int height = viewGroup.getMeasuredHeight() / 4;
        view.setMinimumHeight(height);

        return viewHolder;
    }

    //Cache of the children views for a list item.
    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Will display the position in the list, ie 0 through getItemCount() - 1
        //TextView movieListView;
        ImageView movieListView;

        //Constructor for our ViewHolder.
        public MovieViewHolder(View itemView) {
            super(itemView);

            movieListView = (ImageView) itemView.findViewById(R.id.iv_poster);
            //movieListView = (TextView) itemView.findViewById(R.id.tv_movie);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            Picasso.get().load("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1868&q=80").into(movieListView);
            //movieListView.setImageResource(listIndex);
            //movieListView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onMovieListItemClick(clickedPosition);
        }
    }


}
