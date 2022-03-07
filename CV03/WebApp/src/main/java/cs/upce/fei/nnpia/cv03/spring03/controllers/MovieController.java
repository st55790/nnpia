package cs.upce.fei.nnpia.cv03.spring03.controllers;

import cs.upce.fei.nnpia.cv03.spring03.entities.Movie;
import cs.upce.fei.nnpia.cv03.spring03.services.MovieService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;

@Controller
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String requestAddMovie(){
        return "addMovie";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String requestAddMoviePost(@RequestParam(value = "name")String name, Model model){
        movieService.addMovie(new Movie(name));
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/addMovieByPath/{name}")
    public String addMovieByPath(@PathVariable("name") String name, Model model) {
        movieService.addMovie(new Movie(name));
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }
}
