package com.constantingeorgiu.loginapplication.ui.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.constantingeorgiu.loginapplication.R;
import com.constantingeorgiu.loginapplication.model.Movie;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private ArrayList<Movie> mDataset;
    private AdapterItemClickListener onItemClickListener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MoviesAdapter(ArrayList<Movie> myDataset, AdapterItemClickListener itemClickListener) {
        this.mDataset = myDataset;
        this.onItemClickListener = itemClickListener;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvMovieName;
        public TextView tvMovieGenre;
        public RatingBar rbMovieRating;
        public ImageView ivMovieIcon;

        public MovieViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, getAdapterPosition());
                }
            });
            tvMovieName = view.findViewById(R.id.tv_movieName);
            tvMovieGenre = view.findViewById(R.id.tv_movieGenre);
            rbMovieRating = view.findViewById(R.id.rb_movieRating);
            ivMovieIcon = view.findViewById(R.id.iv_movieIcon);
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View rlMovieItemContainer = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(rlMovieItemContainer);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Movie movie = mDataset.get(position);
        holder.tvMovieName.setText(movie.getName());
        holder.tvMovieGenre.setText(movie.getGenre());
        holder.rbMovieRating.setRating(movie.getRating());
        holder.ivMovieIcon.setImageBitmap(decodeImageFromString(movie.getPhotoBase64()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    private Bitmap decodeImageFromString(String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}