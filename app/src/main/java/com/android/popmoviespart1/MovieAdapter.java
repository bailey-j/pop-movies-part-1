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

    private int mNumberItems;

    // MovieAdapter Constructor
    public MovieAdapter(int numberOfItems) {
        mNumberItems = numberOfItems;
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

        return viewHolder;
    }

    //Cache of the children views for a list item.
    class MovieViewHolder extends RecyclerView.ViewHolder {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView movieListView;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link MovieAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public MovieViewHolder(View itemView) {
            super(itemView);

            //movieListView = (ImageView) itemView.findViewById(R.id.iv_movie);
            movieListView = (TextView) itemView.findViewById(R.id.tv_movie);
        }

        void bind(int listIndex) {
            //movieListView.setImageResource(listIndex);
            movieListView.setText(String.valueOf(listIndex));
        }
    }


}
