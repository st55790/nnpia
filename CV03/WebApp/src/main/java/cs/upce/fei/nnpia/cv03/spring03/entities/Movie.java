package cs.upce.fei.nnpia.cv03.spring03.entities;

import cs.upce.fei.nnpia.cv03.spring03.enums.Genre;
import cs.upce.fei.nnpia.cv03.spring03.entities.Actor;
import java.util.ArrayList;

public class Movie {

    private static Integer counter = 0;
    private final Integer movieId;
    private final String name;
    private ArrayList<Actor> actors;
    private ArrayList<Genre> genre;

    public Movie() {
        this.movieId = counter++;
        this.name = "";
    }

    public Movie(String name) {
        this.movieId = counter++;
        this.name = name;
        this.actors = new ArrayList<>();
        this.genre = new ArrayList<>();
    }

    public static Integer getCounter() {
        return counter;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }
}
