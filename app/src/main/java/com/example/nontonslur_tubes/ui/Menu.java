package com.example.nontonslur_tubes.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.nontonslur_tubes.R;
import com.example.nontonslur_tubes.adapter.MovieAdapter;
import com.example.nontonslur_tubes.adapter.MovieItemClickListener;
import com.example.nontonslur_tubes.adapter.SliderPagerAdapter;
import com.example.nontonslur_tubes.model.Movie;
import com.example.nontonslur_tubes.model.Slide;
import com.example.nontonslur_tubes.util.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Menu extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager slidepager;
    private TabLayout indicator;
    private RecyclerView MoviesRv, MoviesRvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();
    }

    private void iniWeekMovies() {
        MovieAdapter weekmovieAdapter = new MovieAdapter(this, DataSource.getWeekMovies(),this);
        MoviesRvWeek.setAdapter(weekmovieAdapter);
        MoviesRvWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniPopularMovies() {

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        MoviesRv.setAdapter(movieAdapter);
        MoviesRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "Spy X Family",
                "A spy on an undercover mission gets married and adopts a child as part of his cover. His wife and daughter have secrets of their own, and all three must strive to keep together."));
        lstSlides.add(new Slide(R.drawable.slide2, "Tick, Tick... Boom!",
                "On the cusp of his 30th birthday, a promising young theater composer navigates love, friendship and the pressures of life as an artist in New York City."));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlides);
        slidepager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SlideTImer(), 500, 6000);
        indicator.setupWithViewPager(slidepager, true);
    }

    private void iniViews() {
        slidepager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRv = findViewById(R.id.Rv_movies);
        MoviesRvWeek = findViewById(R.id.Rv_movies_week);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        Intent intent = new Intent(this, MovieDetail.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());
        intent.putExtra("desc",movie.getDescription());
        intent.putExtra("linkStream", movie.getStreamLink());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Menu.this,
                movieImageView, "sharedName");
        startActivity(intent, options.toBundle());

    }

    class SlideTImer extends TimerTask{
        @Override
        public void run() {

            Menu.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidepager.getCurrentItem() <lstSlides.size()-1){
                        slidepager.setCurrentItem(slidepager.getCurrentItem()+1);
                    }else slidepager.setCurrentItem(0);

                }
            });
        }
    }

}