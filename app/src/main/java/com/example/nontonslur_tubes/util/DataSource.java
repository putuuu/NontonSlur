package com.example.nontonslur_tubes.util;

import com.example.nontonslur_tubes.R;
import com.example.nontonslur_tubes.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies(){

        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Harry Potter and the Deathly Hallows",
                "A spy on an undercover mission gets married and adopts a child as part of his cover. His wife and daughter have secrets of their own, and all three must strive to keep together.",
                R.drawable.hpdeathlyhallowspart1, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                R.drawable.slide1));
        lstMovie.add(new Movie("Harry Potter and the Deathly Hallows","The first Blender Open Movie from 2006",
                R.drawable.hpdeathlyhallowspart1, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                R.drawable.slide1));
        lstMovie.add(new Movie("Harry Potter and the Philosopher's Stone",R.drawable.hpphilosophersstone));
        lstMovie.add(new Movie("Harry Potter and the Prisoner of Azkaban",R.drawable.hpprisonerofazkaban));
        lstMovie.add(new Movie("Harry Potter and the Chamber of Secrets",R.drawable.hpthechamberofsecrets));

        return lstMovie;
    }

    public static List<Movie> getWeekMovies(){
        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Harry Potter and the Prisoner of Azkaban",R.drawable.hpprisonerofazkaban));
        lstMovie.add(new Movie("Harry Potter and the Chamber of Secrets",R.drawable.hpthechamberofsecrets));
        lstMovie.add(new Movie("Harry Potter and the Deathly Hallows", R.drawable.hpdeathlyhallowspart1,R.drawable.slide1));
        lstMovie.add(new Movie("Harry Potter and the Philosopher's Stone",R.drawable.hpphilosophersstone));

        return lstMovie;
    }
}
