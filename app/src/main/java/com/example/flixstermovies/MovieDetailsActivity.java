package com.example.flixstermovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixstermovies.models.Movie;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class MovieDetailsActivity extends AppCompatActivity {
    Context context;
    Movie movie;

    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbVoteAverage;
    ImageView ivBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        ivBackground = (ImageView)findViewById(R.id.ivBackground);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s", movie.getTitle()));

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        float voteAverage= movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating((voteAverage/ 2.0f));

        String imageUrl;
        imageUrl = movie.getBackdropPath();

        Log.d("MovieDetailsActivity", String.format("Backdrop path: '%s", movie.getBackdropPath()));

        //Glide.with(context).load(imageURL).placeholder(R.drawable.flicks_backdrop_placeholder).into(ivBackground);

    }
}