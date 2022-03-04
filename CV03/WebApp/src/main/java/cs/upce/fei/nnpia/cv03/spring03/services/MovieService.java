package cs.upce.fei.nnpia.cv03.spring03.services;

import cs.upce.fei.nnpia.cv03.spring03.entities.Movie;

import java.util.ArrayList;

public interface MovieService {
    void addMovie(Movie movie);
    void removeMovie(Integer id);
    ArrayList<Movie> getAllMovies();
}
