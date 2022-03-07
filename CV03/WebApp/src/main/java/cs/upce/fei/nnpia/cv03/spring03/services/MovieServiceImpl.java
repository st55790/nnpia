package cs.upce.fei.nnpia.cv03.spring03.services;

import cs.upce.fei.nnpia.cv03.spring03.entities.Movie;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MovieServiceImpl implements MovieService {

    private ArrayList<Movie> movies;

    public MovieServiceImpl() {
        this.movies = new ArrayList<>();
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void removeMovie(Integer id) {
        for (Movie movie: movies) {
            if(movie.getMovieId() == id){
                movies.remove(movie);
            }
        }
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        return movies;
    }
}
