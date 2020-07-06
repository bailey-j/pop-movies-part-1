package com.android.popmoviespart1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();
    final private MovieListItemClickListener mOnClickListener;

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
    }

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
        TextView movieListView;

        //Constructor for our ViewHolder.
        public MovieViewHolder(View itemView) {
            super(itemView);

            //movieListView = (ImageView) itemView.findViewById(R.id.iv_movie);
            movieListView = (TextView) itemView.findViewById(R.id.tv_movie);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            //movieListView.setImageResource(listIndex);
            movieListView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onMovieListItemClick(clickedPosition);
        }
    }


}
